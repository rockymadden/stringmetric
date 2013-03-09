package com.rockymadden.stringmetric

trait ConfigurableStringMetric[R, O] extends ConfigurableMetric[String, R, O] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit o: O): Option[R]
}

object ConfigurableStringMetric {
	type DiceSorensenMetric = com.rockymadden.stringmetric.similarity.DiceSorensenMetric
	val DiceSorensenMetric = com.rockymadden.stringmetric.similarity.DiceSorensenMetric

	type NGramMetric = com.rockymadden.stringmetric.similarity.NGramMetric
	val NGramMetric = com.rockymadden.stringmetric.similarity.NGramMetric

	type WeightedLevenshteinMetric = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric
	val WeightedLevenshteinMetric = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric

	def compareWithDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		DiceSorensenMetric.compare(charArray1, charArray2)(n)

	def compareWithDiceSorensen(string1: String, string2: String)(n: Int) =
		DiceSorensenMetric.compare(string1, string2)(n)

	def compareWithNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		NGramMetric.compare(charArray1, charArray2)(n)

	def compareWithNGram(string1: String, string2: String)(n: Int) = NGramMetric.compare(string1, string2)(n)

	def compareWithWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: (BigDecimal, BigDecimal, BigDecimal)) =

		WeightedLevenshteinMetric.compare(charArray1, charArray2)(options)

	def compareWithWeightedLevenshtein(string1: String, string2: String)
		(options: (BigDecimal, BigDecimal, BigDecimal)) =

		WeightedLevenshteinMetric.compare(string1, string2)(options)
}
