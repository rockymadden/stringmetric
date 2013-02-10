package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic.{ MetaphoneMetric, NysiisMetric, RefinedSoundexMetric, SoundexMetric }
import com.rockymadden.stringmetric.similarity._

trait StringMetricLike[R] extends MetricLike[String, R] { this: StringFilterLike =>
	def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[R]

	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}

object StringMetricLike {
	def compareWithDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int): Option[Double] =
		DiceSorensenMetric().compare(charArray1, charArray2)(n)

	def compareWithDiceSorensen(string1: String, string2: String)(n: Int): Option[Double] =
		DiceSorensenMetric().compare(string1, string2)(n)

	def compareWithHamming(charArray1: Array[Char], charArray2: Array[Char]): Option[Int] =
		HammingMetric().compare(charArray1, charArray2)

	def compareWithHamming(string1: String, string2: String): Option[Int] = HammingMetric().compare(string1, string2)

	def compareWithJaro(charArray1: Array[Char], charArray2: Array[Char]): Option[Double] =
		JaroMetric().compare(charArray1, charArray2)

	def compareWithJaro(string1: String, string2: String): Option[Double] = JaroMetric().compare(string1, string2)

	def compareWithJaroWinkler(charArray1: Array[Char], charArray2: Array[Char]): Option[Double] =
		JaroWinklerMetric().compare(charArray1, charArray2)

	def compareWithJaroWinkler(string1: String, string2: String): Option[Double] =
		JaroWinklerMetric().compare(string1, string2)

	def compareWithLevenshtein(charArray1: Array[Char], charArray2: Array[Char]): Option[Int] =
		LevenshteinMetric().compare(charArray1, charArray2)

	def compareWithLevenshtein(string1: String, string2: String): Option[Int] =
		LevenshteinMetric().compare(string1, string2)

	def compareWithMetaphone(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		MetaphoneMetric().compare(charArray1, charArray2)

	def compareWithMetaphone(string1: String, string2: String): Option[Boolean] =
		MetaphoneMetric().compare(string1, string2)

	def compareWithNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int): Option[Double] =
		NGramMetric().compare(charArray1, charArray2)(n)

	def compareWithNGram(string1: String, string2: String)(n: Int): Option[Double] =
		NGramMetric().compare(string1, string2)(n)

	def compareWithNysiis(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		NysiisMetric().compare(charArray1, charArray2)

	def compareWithNysiis(string1: String, string2: String): Option[Boolean] = NysiisMetric().compare(string1, string2)

	def compareWithRefinedSoundex(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		RefinedSoundexMetric().compare(charArray1, charArray2)

	def compareWithRefinedSoundex(string1: String, string2: String): Option[Boolean] =
		RefinedSoundexMetric().compare(string1, string2)

	def compareWithSoundex(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		SoundexMetric().compare(charArray1, charArray2)

	def compareWithSoundex(string1: String, string2: String): Option[Boolean] =
		SoundexMetric().compare(string1, string2)

	def compareWithWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] =

		WeightedLevenshteinMetric().compare(charArray1, charArray2)(options)

	def compareWithWeightedLevenshtein(string1: String, string2: String)
		(options: (BigDecimal, BigDecimal, BigDecimal)): Option[Double] =

		WeightedLevenshteinMetric().compare(string1, string2)(options)

	def diceSorensen: DiceSorensenMetric.type = DiceSorensenMetric

	def hamming: HammingMetric.type = HammingMetric

	def jaro: JaroMetric.type = JaroMetric

	def jaroWinkler: JaroWinklerMetric.type = JaroWinklerMetric

	def levenshtein: LevenshteinMetric.type = LevenshteinMetric

	def metaphone: MetaphoneMetric.type = MetaphoneMetric

	def nGram: NGramMetric.type = NGramMetric

	def nysiis: NysiisMetric.type = NysiisMetric

	def refinedSoundex: RefinedSoundexMetric.type = RefinedSoundexMetric

	def soundex: SoundexMetric.type = SoundexMetric

	def weightedLevenshtein: WeightedLevenshteinMetric.type = WeightedLevenshteinMetric
}
