package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.Metric.StringMetric

final case class JaccardMetric(n: Int) extends StringMetric[Double] {
	import com.rockymadden.stringmetric.tokenize.NGramTokenizer

	override def compare(a: Array[Char], b: Array[Char]): Option[Double] =
		if (n <= 0 || a.length < n || b.length < n) None // Because length is less than n, it is not possible to compare.
		else if (a.sameElements(b)) Some(1d)
		else NGramTokenizer(n).tokenize(a).flatMap { ca1bg =>
			NGramTokenizer(n).tokenize(b).map { ca2bg =>
				val i = (ca1bg.map(_.mkString) intersect ca2bg.map(_.mkString)).length

				i.toDouble / (ca1bg.length + ca2bg.length - i)
			}
		}

	override def compare(a: String, b: String): Option[Double] = compare(a.toCharArray, b.toCharArray)
}
