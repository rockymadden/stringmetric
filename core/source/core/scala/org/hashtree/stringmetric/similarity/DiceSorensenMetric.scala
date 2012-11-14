package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ FilterableConfigurableStringMetric, MatchTuple, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate

/**
 * An implementation of the Dice, and lesser known Sorensen, [[org.hashtree.stringmetric.StringMetric]]. This
 * implementation differs in that n-gram size is required. Traditionally, the algorithm uses bigrams.
 */
object DiceSorensenMetric extends StringMetric with FilterableConfigurableStringMetric[Int] {
	type CompareReturn = Double

	override def compare(charArray1: Array[Char], charArray2: Array[Char])(n: Int)
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		if (n <= 0) throw new IllegalArgumentException("Expected valid n.")

		val ca1 = stringFilter.filter(charArray1)
		lazy val ca2 = stringFilter.filter(charArray2)

		if (ca1.length < n || ca2.length < n) None // Because length is less than n, it is not possible to compare.
		else if (ca1.sameElements(ca2)) Some(1d)
		else {
			val ca1bg = NGramAlgorithm.compute(ca1)(n)
			lazy val ca2bg = NGramAlgorithm.compute(ca2)(n)

			if (!ca1bg.isDefined || !ca2bg.isDefined) None
			else {
				val ms = scoreMatches((ca1bg.get.map(_.mkString), ca2bg.get.map(_.mkString)))

				Some((2d * ms) / (ca1bg.get.length + ca2bg.get.length))
			}
		}
	}

	override def compare(string1: String, string2: String)(n: Int)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(n: Int)(new StringFilterDelegate)

	private[this] def scoreMatches(mt: MatchTuple[String]) = mt._1.intersect(mt._2).length
}