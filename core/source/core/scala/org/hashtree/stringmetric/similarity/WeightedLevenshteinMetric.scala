package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ CompareTuple, FilterableConfigurableStringMetric, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate
import scala.math.BigDecimal

/** An implementation of a weighted Levenshtein [[org.hashtree.stringmetric.StringMetric]]. */
object WeightedLevenshteinMetric
	extends StringMetric with FilterableConfigurableStringMetric[Tuple3[BigDecimal, BigDecimal, BigDecimal]] {

	type CompareReturn = Double
	type Options = Tuple3[BigDecimal, BigDecimal, BigDecimal]

	/** Options order is delete, insert, then substitute weight. */
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(options: Options)
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		if (options._1 < 0 || options._2 < 0 || options._3 < 0)
			throw new IllegalArgumentException("Expected valid weight options.")

		val fca1 = stringFilter.filter(charArray1)
		val fca2 = stringFilter.filter(charArray2)

		if (fca1.length == 0 && fca2.length == 0) None
		else if (fca1.length == 0) Some((options._2 * fca2.length).toDouble)
		else if (fca2.length == 0) Some((options._1 * fca1.length).toDouble)
		else if (fca1.sameElements(fca2)) Some(0d)
		else Some(weightedLevenshtein((fca1, fca2), options).toDouble)
	}

	/** Options order is delete, insert, then substitute weight. */
	override def compare(string1: String, string2: String)(options: Options)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(options)(new StringFilterDelegate)

	private[this] def weightedLevenshtein(ct: CompareTuple[Char], w: Options) = {
		val m = Array.ofDim[BigDecimal](ct._1.length + 1, ct._2.length + 1)

		for (r <- 0 to ct._1.length) m(r)(0) = w._1 * r
		for (c <- 0 to ct._2.length) m(0)(c) = w._2 * c

		for (r <- 1 to ct._1.length; c <- 1 to ct._2.length) {
			m(r)(c) = {
				if (ct._1(r - 1) == ct._2(c - 1)) m(r - 1)(c - 1)
				else (m(r - 1)(c) + w._1).min( // Delete (left).
					(m(r)(c - 1) + w._2).min( // Insert (up).
						m(r - 1)(c - 1) + w._3 // Substitute (left-up).
					)
				)
			}
		}

		m(ct._1.length)(ct._2.length)
	}
}