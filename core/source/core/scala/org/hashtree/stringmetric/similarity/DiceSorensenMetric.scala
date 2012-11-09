package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ FilterableStringMetric, MatchTuple, StringFilter, StringMetric, StringFilterDelegate }

/** An implementation of the Dice, and Sorensen, [[org.hashtree.stringmetric.StringMetric]]. */
object DiceSorensenMetric extends StringMetric with FilterableStringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Double] = {
		val ca1 = stringFilter.filter(charArray1)
		val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else if (ca1.length < 2 || ca2.length < 2) Some(0d) // Because length is less than that of bigram, it will always be 0.
		else if (ca1.sameElements(ca2)) Some(1d)
		else {
			val ca1bg = NGramAlgorithm.compute(ca1)(2).get
			val ca2bg = NGramAlgorithm.compute(ca2)(2).get
			val ms = scoreMatches((ca1bg.map(_.mkString), ca2bg.map(_.mkString)))

			Some((2d * ms) / (ca1bg.length + ca2bg.length))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Double] =
		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)

	private[this] def scoreMatches(mt: MatchTuple[String]) = mt._1.intersect(mt._2).length
}