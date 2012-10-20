package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ StringCleaner, StringCleanerDelegate, StringMetric }

/** An implementation of the Metaphone [[org.hashtree.stringmetric.StringMetric]]. */
object MetaphoneMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Option[Boolean] = {
		val ca1 = stringCleaner.clean(charArray1)
		val ca2 = stringCleaner.clean(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else {
			val mp1 = Metaphone.compute(ca1)
			val mp2 = Metaphone.compute(ca2)

			if (!mp1.isDefined || !mp2.isDefined || (mp1.get.length == 0 && mp2.get.length == 0))
				None
			else
				Some(mp1.get.sameElements(mp2.get))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Option[Boolean] = {
		// Unable to perform simple equality check, due to situations where no letters are passed.
		compare(
			stringCleaner.clean(string1.toCharArray),
			stringCleaner.clean(string2.toCharArray)
		)(new StringCleanerDelegate)
	}
}