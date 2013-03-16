package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{ ConfigurableStringMetric, MatchTuple, StringFilter }

/**
 * An implementation of the Dice/Sorensen metric. This implementation differs in that n-gram size is required.
 * Traditionally, the algorithm uses bigrams.
 */
class DiceSorensenMetric extends ConfigurableStringMetric[Double, Int] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit n: Int): Option[Double] = {
		if (n <= 0) throw new IllegalArgumentException("Expected valid n.")

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length < n || fca2.length < n) None // Because length is less than n, it is not possible to compare.
		else if (fca1.sameElements(fca2)) Some(1d)
		else {
			val nGramAlgorithm = NGramAlgorithm()

			nGramAlgorithm.compute(fca1)(n).flatMap { ca1bg =>
				nGramAlgorithm.compute(fca2)(n).map { ca2bg =>
					val ms = scoreMatches((ca1bg.map(_.mkString), ca2bg.map(_.mkString)))

					(2d * ms) / (ca1bg.length + ca2bg.length)
				}
			}
		}
	}

	final override def compare(string1: String, string2: String)(implicit n: Int): Option[Double] =
		compare(string1.toCharArray, string2.toCharArray)(n: Int)

	private[this] def scoreMatches(mt: MatchTuple[String]) = mt._1.intersect(mt._2).length
}

object DiceSorensenMetric {
	private lazy val self = apply()

	def apply(): DiceSorensenMetric = new DiceSorensenMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char])(n: Int) = self.compare(charArray1, charArray2)(n)

	def compare(string1: String, string2: String)(n: Int) = self.compare(string1, string2)(n)
}
