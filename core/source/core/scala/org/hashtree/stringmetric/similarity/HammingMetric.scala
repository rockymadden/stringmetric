package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ CompareTuple, FilterableStringMetric, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate

/** An implementation of the Hamming [[org.hashtree.stringmetric.StringMetric]]. */
object HammingMetric extends StringMetric with FilterableStringMetric {
	type CompareReturn = Int

	override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		val ca1 = stringFilter.filter(charArray1)
		lazy val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0 || ca1.length != ca2.length) None
		else if (ca1.sameElements(ca2)) Some(0)
		else Some(hamming(ca1, ca2))
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)

	private[this] def hamming(ct: CompareTuple[Char]) = {
		require(ct._1.length == ct._2.length)

		if (ct._1.length == 0) 0
		else
			ct._1.zip(ct._2).count(t => t._1 != t._2)
	}
}