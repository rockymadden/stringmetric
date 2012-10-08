package org.hashtree.stringmetric

/**
 * An implementation of the Jaro-Winkler string metric. One differing detail in this implementation is that if a
 * character is matched in string2, it cannot be matched upon again. This results in a more penalized distance in these
 * scenarios (e.g. comparing henka and henkan distance is 0.9666 versus the typical 0.9722).
 */
object JaroWinklerMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char]): Float = {
		val jaro = JaroMetric.compare(charArray1, charArray2)
		val prefix = charArray1.zip(charArray2).takeWhile(t => t._1 == t._2).map(_._1)

		jaro + ((if (prefix.length <= 4) prefix.length else 4) * (0.1f * (1 - jaro)))
	}

	override def compare(string1: String, string2: String): Float = {
		compare(string1.replaceAllLiterally(" ", "").toLowerCase.toCharArray,
			string2.replaceAllLiterally(" ", "").toLowerCase.toCharArray)
	}
}