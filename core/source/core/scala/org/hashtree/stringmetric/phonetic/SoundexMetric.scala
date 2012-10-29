package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ StringFilter, StringFilterDelegate, StringMetric }

/** An implementation of the Soundex [[org.hashtree.stringmetric.StringMetric]]. */
object SoundexMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Boolean] = {
		val ca1 = stringFilter.filter(charArray1)
		val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else {
			val se1 = SoundexAlgorithm.compute(ca1)
			val se2 = SoundexAlgorithm.compute(ca2)

			if (!se1.isDefined || !se2.isDefined || (se1.get.length == 0 && se2.get.length == 0)) None
			else Some(se1.get.sameElements(se2.get))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Boolean] =
		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}