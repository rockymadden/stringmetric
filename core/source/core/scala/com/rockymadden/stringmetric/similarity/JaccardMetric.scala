package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{StringMetric, StringFilter}
import com.rockymadden.stringmetric.tokenization.NGramTokenizer

/* An implementation of the Jaccard metric. */
class JaccardMetric extends StringMetric[Int, Double] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit n: Int): Option[Double] = {
		if (n <= 0) throw new IllegalArgumentException("Expected valid n.")

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length < n || fca2.length < n) None // Because length is less than n, it is not possible to compare.
		else if (fca1.sameElements(fca2)) Some(1d)
		else NGramTokenizer.tokenize(fca1)(n).flatMap { ca1bg =>
			NGramTokenizer.tokenize(fca2)(n).map { ca2bg =>
				val i = (ca1bg.map(_.mkString) intersect ca2bg.map(_.mkString)).length

				i.toDouble / (ca1bg.length + ca2bg.length - i)
			}
		}
	}

	final override def compare(string1: String, string2: String)(implicit n: Int): Option[Double] =
		compare(string1.toCharArray, string2.toCharArray)(n: Int)
}

object JaccardMetric {
	private lazy val self = apply()

	def apply(): JaccardMetric = new JaccardMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char])(n: Int) = self.compare(charArray1, charArray2)(n)

	def compare(string1: String, string2: String)(n: Int) = self.compare(string1, string2)(n)
}
