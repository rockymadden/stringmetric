package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.similarity.{ DiceSorensenMetric, NGramMetric, WeightedLevenshteinMetric }

trait ConfigurableStringMetric[R, O] extends ConfigurableMetric[String, R, O] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit o: O): Option[R]
}

object ConfigurableStringMetric {
	def compareWithDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int): Option[Double] =
		DiceSorensenMetric().compare(charArray1, charArray2)(n)

	def compareWithDiceSorensen(string1: String, string2: String)(n: Int): Option[Double] =
		DiceSorensenMetric().compare(string1, string2)(n)

	def compareWithNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int): Option[Double] =
		NGramMetric().compare(charArray1, charArray2)(n)

	def compareWithNGram(string1: String, string2: String)(n: Int): Option[Double] =
		NGramMetric().compare(string1, string2)(n)

	def compareWithWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] =

		WeightedLevenshteinMetric().compare(charArray1, charArray2)(options)

	def compareWithWeightedLevenshtein(string1: String, string2: String)
		(options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] =

		WeightedLevenshteinMetric().compare(string1, string2)(options)

	def diceSorensen: DiceSorensenMetric.type = DiceSorensenMetric

	def nGram: NGramMetric.type = NGramMetric

	def weightedLevenshtein: WeightedLevenshteinMetric.type = WeightedLevenshteinMetric
}
