package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringMetric, StringFilter, StringFilterDelegate, StringMetric }

/** An implementation of the Metaphone [[org.hashtree.stringmetric.StringMetric]]. */
object MetaphoneMetric extends StringMetric with FilterableStringMetric {
	type CompareReturn = Boolean

	override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		val ca1 = stringFilter.filter(charArray1)
		lazy val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else {
			val mp1 = MetaphoneAlgorithm.compute(ca1)
			lazy val mp2 = MetaphoneAlgorithm.compute(ca2)

			if (!mp1.isDefined || mp1.get.length == 0 || !mp2.isDefined || mp2.get.length == 0) None
			else Some(mp1.get.sameElements(mp2.get))
		}
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}