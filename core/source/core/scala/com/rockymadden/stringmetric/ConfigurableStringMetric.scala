package com.rockymadden.stringmetric

trait ConfigurableStringMetric[R, O] extends ConfigurableMetric[String, R, O] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit o: O): Option[R]
}

object ConfigurableStringMetric {
	type DiceSorensen = com.rockymadden.stringmetric.similarity.DiceSorensenMetric
	val DiceSorensen = com.rockymadden.stringmetric.similarity.DiceSorensenMetric

	type Jaccard = com.rockymadden.stringmetric.similarity.JaccardMetric
	val Jaccard = com.rockymadden.stringmetric.similarity.JaccardMetric

	type NGram = com.rockymadden.stringmetric.similarity.NGramMetric
	val NGram = com.rockymadden.stringmetric.similarity.NGramMetric

	type Overlap = com.rockymadden.stringmetric.similarity.OverlapMetric
	val Overlap = com.rockymadden.stringmetric.similarity.OverlapMetric

	type WeightedLevenshtein = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric
	val WeightedLevenshtein = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric

	def compareWithDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		DiceSorensen.compare(charArray1, charArray2)(n)

	def compareWithDiceSorensen(string1: String, string2: String)(n: Int) = DiceSorensen.compare(string1, string2)(n)

	def compareWithJaccard(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		Jaccard.compare(charArray1, charArray2)(n)

	def compareWithJaccard(string1: String, string2: String)(n: Int) = Jaccard.compare(string1, string2)(n)

	def compareWithNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		NGram.compare(charArray1, charArray2)(n)

	def compareWithNGram(string1: String, string2: String)(n: Int) = NGram.compare(string1, string2)(n)

	def compareWithOverlap(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		Overlap.compare(charArray1, charArray2)(n)

	def compareWithOverlap(string1: String, string2: String)(n: Int) = Overlap.compare(string1, string2)(n)

	def compareWithWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: (BigDecimal, BigDecimal, BigDecimal)) =

		WeightedLevenshtein.compare(charArray1, charArray2)(options)

	def compareWithWeightedLevenshtein(string1: String, string2: String)
		(options: (BigDecimal, BigDecimal, BigDecimal)) =

		WeightedLevenshtein.compare(string1, string2)(options)
}
