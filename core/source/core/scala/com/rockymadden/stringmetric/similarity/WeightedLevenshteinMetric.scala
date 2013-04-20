package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{CompareTuple, StringMetric, StringFilter}
import scala.math.BigDecimal

/** An implementation of a weighted Levenshtein metric. */
class WeightedLevenshteinMetric
	extends StringMetric[(BigDecimal, BigDecimal, BigDecimal), Double] { this: StringFilter =>

	/** Options order is delete, insert, then substitute weight. */
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] = {

		if (options._1 < 0 || options._2 < 0 || options._3 < 0)
			throw new IllegalArgumentException("Expected valid weight options.")

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || fca2.length == 0) None
		else if (fca1.sameElements(fca2)) Some(0d)
		else Some(weightedLevenshtein((fca1, fca2), options).toDouble)
	}

	/** Options order is delete, insert, then substitute weight. */
	final override def compare(string1: String, string2: String)
		(implicit options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] =

		compare(string1.toCharArray, string2.toCharArray)(options)

	private[this] def weightedLevenshtein(ct: CompareTuple[Char], w: (BigDecimal, BigDecimal, BigDecimal)) = {
		val m = Array.ofDim[BigDecimal](ct._1.length + 1, ct._2.length + 1)

		for (r <- 0 to ct._1.length) m(r)(0) = w._1 * r
		for (c <- 0 to ct._2.length) m(0)(c) = w._2 * c

		for (r <- 1 to ct._1.length; c <- 1 to ct._2.length) {
			m(r)(c) =
				if (ct._1(r - 1) == ct._2(c - 1)) m(r - 1)(c - 1)
				else (m(r - 1)(c) + w._1).min( // Delete (left).
					(m(r)(c - 1) + w._2).min( // Insert (up).
						m(r - 1)(c - 1) + w._3 // Substitute (left-up).
					)
				)
		}

		m(ct._1.length)(ct._2.length)
	}
}

object WeightedLevenshteinMetric {
	private lazy val self = apply()

	def apply(): WeightedLevenshteinMetric = new WeightedLevenshteinMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char])(options: (BigDecimal, BigDecimal, BigDecimal)) =
		self.compare(charArray1, charArray2)(options)

	def compare(string1: String, string2: String)(options: (BigDecimal, BigDecimal, BigDecimal)) =
		self.compare(string1, string2)(options)
}
