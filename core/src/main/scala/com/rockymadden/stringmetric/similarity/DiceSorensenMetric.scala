package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric._

/**
 * An implementation of the Dice/Sorensen metric. This implementation differs in that n-gram size is required.
 * Traditionally, the algorithm uses bigrams.
 */
final case class DiceSorensenMetric(n: Int) extends StringMetric[Double] {
	override def compare(a: Array[Char], b: Array[Char]): Option[Double] =
		if (n <= 0 || a.length < n || b.length < n) None // Because length is less than n, it is not possible to compare.
		else if (a.sameElements(b)) Some(1d)
		else NGramTokenizer(n).tokenize(a).flatMap { ca1bg =>
			NGramTokenizer(n).tokenize(b).map { ca2bg =>
				val ms = scoreMatches(ca1bg.map(_.mkString), ca2bg.map(_.mkString))

				(2d * ms) / (ca1bg.length + ca2bg.length)
			}
		}

	override def compare(a: String, b: String): Option[Double] = compare(a.toCharArray, b.toCharArray)

	private val scoreMatches: (MatchTuple[String] => Int) = (mt) => mt._1.intersect(mt._2).length
}
