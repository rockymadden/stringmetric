package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.similarity.{ DiceSorensenMetric, NGramMetric, WeightedLevenshteinMetric }

trait ConfigurableStringMetric[R, O] extends ConfigurableMetric[String, R, O] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit o: O): Option[R]
}

object ConfigurableStringMetric {
	lazy val diceSorensen = DiceSorensenMetric()
	lazy val nGram = NGramMetric()
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
