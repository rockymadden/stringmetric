package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringMetric, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate

/** An implementation of the refined NYSIIS [[org.hashtree.stringmetric.StringMetric]]. */
object RefinedNysiisMetric extends StringMetric with FilterableStringMetric {
	type CompareReturn = Boolean

	override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		val ca1 = stringFilter.filter(charArray1)
		lazy val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else {
			val rny1 = RefinedNysiisAlgorithm.compute(ca1)
			lazy val rny2 = RefinedNysiisAlgorithm.compute(ca2)

			if (!rny1.isDefined || rny1.get.length == 0 || !rny2.isDefined || rny2.get.length == 0) None
			else Some(rny1.get.sameElements(rny2.get))
		}
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}