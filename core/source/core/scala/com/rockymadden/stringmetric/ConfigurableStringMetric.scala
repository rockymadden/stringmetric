package com.rockymadden.stringmetric

trait ConfigurableStringMetric[R, O] extends ConfigurableMetric[String, R, O] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit o: O): Option[R]
}

object ConfigurableStringMetric {
	type DiceSorensenMetric = com.rockymadden.stringmetric.similarity.DiceSorensenMetric
	val DiceSorensenMetric = com.rockymadden.stringmetric.similarity.DiceSorensenMetric
	lazy val diceSorensen = DiceSorensenMetric()

	type NGramMetric = com.rockymadden.stringmetric.similarity.NGramMetric
	val NGramMetric = com.rockymadden.stringmetric.similarity.NGramMetric
	lazy val nGram = NGramMetric()

	type WeightedLevenshteinMetric = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric
	val WeightedLevenshteinMetric = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric
	lazy val weightedLevenshtein = WeightedLevenshteinMetric()

	def compareWithDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int): Option[Double] =
		diceSorensen.compare(charArray1, charArray2)(n)

	def compareWithDiceSorensen(string1: String, string2: String)(n: Int): Option[Double] =
		diceSorensen.compare(string1, string2)(n)

	def compareWithNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int): Option[Double] =
		nGram.compare(charArray1, charArray2)(n)

	def compareWithNGram(string1: String, string2: String)(n: Int): Option[Double] = nGram.compare(string1, string2)(n)

	def compareWithWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] =

		weightedLevenshtein.compare(charArray1, charArray2)(options)

	def compareWithWeightedLevenshtein(string1: String, string2: String)
		(options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] =

		weightedLevenshtein.compare(string1, string2)(options)
}
