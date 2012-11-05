package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringMetric, StringFilter, StringFilterDelegate, StringMetric }

/** An implementation of the refined Soundex [[org.hashtree.stringmetric.StringMetric]]. */
object RefinedSoundexMetric extends StringMetric with FilterableStringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Boolean] = {
		val ca1 = stringFilter.filter(charArray1)
		val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else {
			val rse1 = RefinedSoundexAlgorithm.compute(ca1)
			val rse2 = RefinedSoundexAlgorithm.compute(ca2)

			if (!rse1.isDefined || !rse2.isDefined || (rse1.get.length == 0 && rse2.get.length == 0)) None
			else Some(rse1.get.sameElements(rse2.get))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Boolean] =
		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}