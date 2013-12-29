package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.Metric.StringMetric

final case class OverlapMetric(private val n: Int) extends StringMetric[Double] {
	import com.rockymadden.stringmetric.MatchTuple
	import com.rockymadden.stringmetric.tokenize.NGramTokenizer
	import scala.math

	override def compare(a: Array[Char], b: Array[Char]): Option[Double] = {
		if (n <= 0) return None

		if (a.length < n || b.length < n) None // Because length is less than n, it is not possible to compare.
		else if (a.sameElements(b)) Some(1d)
		else NGramTokenizer(n).tokenize(a).flatMap { ca1bg =>
			NGramTokenizer(n).tokenize(b).map { ca2bg =>
				val ms = scoreMatches(ca1bg.map(_.mkString), ca2bg.map(_.mkString))

				ms.toDouble / math.min(ca1bg.length, ca2bg.length)
			}
		}
	}

	override def compare(a: String, b: String): Option[Double] = compare(a.toCharArray, b.toCharArray)

	private val scoreMatches: (MatchTuple[String] => Int) = (mt) => mt._1.intersect(mt._2).length
}
