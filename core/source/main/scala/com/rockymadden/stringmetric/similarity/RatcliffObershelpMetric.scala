package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.Metric.StringMetricLike

case object RatcliffObershelpMetric extends StringMetricLike[Double] {
	import com.rockymadden.stringmetric.CompareTuple

	override def compare(a: Array[Char], b: Array[Char]): Option[Double] =
		if (a.length == 0 || b.length == 0) None
		else if (a.sameElements(b)) Some(1d)
		else Some(2d * commonSequences(a, b).foldLeft(0)(_ + _.length) / (a.length + b.length))

	override def compare(a: String, b: String): Option[Double] = compare(a.toCharArray, b.toCharArray)

	private def longestCommonSubsequence(ct: CompareTuple[Char]) = {
		val m = Array.ofDim[Int](ct._1.length + 1, ct._2.length + 1)
		var lrc = (0, 0, 0) // Length, row, column.

		for (r <- 0 to ct._1.length - 1; c <- 0 to ct._2.length - 1) {
			if (ct._1(r) == ct._2(c)) {
				val l = m(r)(c) + 1
				m(r + 1)(c + 1) = l
				if (l > lrc._1) lrc = (l, r + 1, c + 1)
			}
		}

		lrc
	}

	private def commonSequences(ct: CompareTuple[Char]): Array[Array[Char]] = {
		val lcs = longestCommonSubsequence(ct)

		if (lcs._1 == 0) Array.empty
		else {
			val sct1 = (ct._1.take(lcs._2 - lcs._1), ct._1.takeRight(ct._1.length - lcs._2))
			val sct2 = (ct._2.take(lcs._3 - lcs._1), ct._2.takeRight(ct._2.length - lcs._3))

			Array(ct._1.slice(lcs._2 - lcs._1, lcs._2)) ++ commonSequences(sct1._1, sct2._1) ++ commonSequences(sct1._2, sct2._2)
		}
	}
}
