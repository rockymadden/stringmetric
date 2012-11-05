package org.hashtree.stringmetric

import org.hashtree.stringmetric.similarity.WeightedLevenshteinMetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.OptionMetric]]. */
trait StringOptionMetric[O] extends OptionMetric[String, O, StringFilter] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(o: O)(implicit stringFilter: StringFilter): Option[AnyVal]
}

/** Convenience object for those extending [[org.hashtree.stringmetric.StringOptionMetric]]. */
object StringOptionMetric {
	def compareWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: Tuple3[BigDecimal, BigDecimal, BigDecimal])(implicit stringFilter: StringFilter): Option[Double] =
		WeightedLevenshteinMetric.compare(charArray1, charArray2)(options)(stringFilter)

	def compareWeightedLevenshtein(string1: String, string2: String)
		(options: Tuple3[BigDecimal, BigDecimal, BigDecimal])(implicit stringFilter: StringFilter): Option[Double] =
		WeightedLevenshteinMetric.compare(string1, string2)(options)(stringFilter)

	def weightedLevenshtein: WeightedLevenshteinMetric.type = WeightedLevenshteinMetric
}