package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{ ConfigurableStringMetric, MatchTuple, StringFilter }
import com.rockymadden.stringmetric.tokenization.NGramTokenizer

/* An implementation of the Jaccard metric. */
class JaccardMetric extends ConfigurableStringMetric[Int, Double] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit n: Int): Option[Double] = {
		if (n <= 0) throw new IllegalArgumentException("Expected valid n.")

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length < n || fca2.length < n) None // Because length is less than n, it is not possible to compare.
		else if (fca1.sameElements(fca2)) Some(1d)
		else {
			val nGramTokenizer = NGramTokenizer()

			nGramTokenizer.tokenize(fca1)(n).flatMap { ca1bg =>
				nGramTokenizer.tokenize(fca2)(n).map { ca2bg =>
					val ms = scoreMatches(ca1bg.map(_.mkString), ca2bg.map(_.mkString))

					ms.toDouble / (ca1bg.length + ca2bg.length)
				}
			}
		}
	}

	final override def compare(string1: String, string2: String)(implicit n: Int): Option[Double] =
		compare(string1.toCharArray, string2.toCharArray)(n: Int)

	private[this] def scoreMatches(mt: MatchTuple[String]) = mt._1.intersect(mt._2).length
}

object JaccardMetric {
	private lazy val self = apply()

	def apply(): JaccardMetric = new JaccardMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char])(n: Int) = self.compare(charArray1, charArray2)(n)

	def compare(string1: String, string2: String)(n: Int) = self.compare(string1, string2)(n)
}
