package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ CompareTuple, MatchTuple, StringFilter, StringMetric }
import org.hashtree.stringmetric.StringFilterDelegate
import scala.annotation.tailrec

/** An implementation of the Dice, and Sorensen, [[org.hashtree.stringmetric.StringMetric]]. */
object DiceSorensenMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Double] = {
		val ca1 = stringFilter.filter(charArray1)
		val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else if (ca1.sameElements(ca2)) Some(1d)
		else {
			val b = bigrams(ca1, ca2)
			val ms = scoreMatches(b)

			Some((2d * ms) / (b._1.length + b._2.length))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Double] =
		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)

	private[this] def bigrams(ct: CompareTuple[Char]): MatchTuple[String] = {
		@tailrec
		def set(ca: Array[Char], sa: Array[String]): Array[String] = {
			if (ca.length <= 1) sa
			else
				set(ca.tail, sa :+ "" + ca.head + ca(1))
		}

		(set(ct._1, Array.empty[String]), set(ct._2, Array.empty[String]))
	}

	private[this] def scoreMatches(mt: MatchTuple[String]) = mt._1.intersect(mt._2).length
}