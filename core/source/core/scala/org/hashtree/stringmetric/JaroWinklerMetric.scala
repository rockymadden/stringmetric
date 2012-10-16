package org.hashtree.stringmetric

/**
 * An implementation of the Jaro-Winkler [[org.hashtree.stringmetric.StringMetric]]. One differing detail in this
 * implementation is that if a character is matched in string2, it cannot be matched upon again. This results in a more
 * penalized distance in these scenarios (e.g. comparing henka and henkan distance is 0.9666 versus the typical 0.9722).
 */
object JaroWinklerMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Option[Float] = {
		val ca1 = stringCleaner.clean(charArray1)
		val ca2 = stringCleaner.clean(charArray2)

		JaroMetric.compare(ca1, ca2)(new StringCleanerDelegate) match {
			case Some(jaro) => {
				val prefix = ca1.zip(ca2).takeWhile(t => t._1 == t._2).map(_._1)

				Some(jaro + ((if (prefix.length <= 4) prefix.length else 4) * 0.1f * (1 - jaro)))
			}
			case None => None
		}
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Option[Float] = {
		// Return 1 if strings are an exact match.
		if (string1.length > 0 && string1 == string2) return Some(1f)

		compare(stringCleaner.clean(string1.toCharArray), stringCleaner.clean(string2.toCharArray))(new StringCleanerDelegate)
	}
}