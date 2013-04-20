package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{CompareTuple, StringFilter, StringMetric}

/** An implementation of the Ratcliff/Obershelp metric. */
class RatcliffObershelpMetric extends StringMetric[DummyImplicit, Double] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit di: DummyImplicit): Option[Double] = {

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || fca2.length == 0) None
		else if (fca1.sameElements(fca2)) Some(1d)
		else Some(2d * commonSequences(fca1, fca2).foldLeft(0)(_ + _.length) / (fca1.length + fca2.length))
	}

	final override def compare(string1: String, string2: String)(implicit di: DummyImplicit): Option[Double] =
		compare(string1.toCharArray, string2.toCharArray)

	private[this] def longestCommonSubsequence(ct: CompareTuple[Char]) = {
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

	private[this] def commonSequences(ct: CompareTuple[Char]): Array[Array[Char]] = {
		val lcs = longestCommonSubsequence(ct)

		if (lcs._1 == 0) Array.empty
		else {
			val sct1 = (ct._1.take(lcs._2 - lcs._1), ct._1.takeRight(ct._1.length - lcs._2))
			val sct2 = (ct._2.take(lcs._3 - lcs._1), ct._2.takeRight(ct._2.length - lcs._3))

			Array(ct._1.slice(lcs._2 - lcs._1, lcs._2)) ++ commonSequences(sct1._1, sct2._1) ++ commonSequences(sct1._2, sct2._2)
		}
	}
}

object RatcliffObershelpMetric {
	private lazy val self = apply()

	def apply(): RatcliffObershelpMetric = new RatcliffObershelpMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char]) = self.compare(charArray1, charArray2)

	def compare(string1: String, string2: String) = self.compare(string1, string2)
}
