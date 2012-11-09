package org.hashtree.stringmetric

import org.hashtree.stringmetric.phonetic.{ MetaphoneMetric, NysiisMetric, RefinedSoundexMetric, SoundexMetric }
import org.hashtree.stringmetric.similarity._

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Metric]]. */
trait StringMetric extends Metric[String] {

}

/** Convenience object for those extending [[org.hashtree.stringmetric.StringMetric]]. */
object StringMetric {
	def compareDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int)(implicit stringFilter: StringFilter): Option[Double] =
		DiceSorensenMetric.compare(charArray1, charArray2)(n)(stringFilter)

	def compareDiceSorensen(string1: String, string2: String)(n: Int)(implicit stringFilter: StringFilter): Option[Double] =
		DiceSorensenMetric.compare(string1, string2)(n)(stringFilter)

	def compareHamming(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Int] =
		HammingMetric.compare(charArray1, charArray2)(stringFilter)

	def compareHamming(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Int] =
		HammingMetric.compare(string1, string2)(stringFilter)

	def compareJaro(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Double] =
		JaroMetric.compare(charArray1, charArray2)(stringFilter)

	def compareJaro(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Double] =
		JaroMetric.compare(string1, string2)(stringFilter)

	def compareJaroWinkler(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Double] =
		JaroWinklerMetric.compare(charArray1, charArray2)(stringFilter)

	def compareJaroWinkler(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Double] =
		JaroWinklerMetric.compare(string1, string2)(stringFilter)

	def compareLevenshtein(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Int] =
		LevenshteinMetric.compare(charArray1, charArray2)(stringFilter)

	def compareLevenshtein(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Int] =
		LevenshteinMetric.compare(string1, string2)(stringFilter)

	def compareMetaphone(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Boolean] =
		MetaphoneMetric.compare(charArray1, charArray2)(stringFilter)

	def compareMetaphone(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Boolean] =
		MetaphoneMetric.compare(string1, string2)(stringFilter)

	def compareNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int)(implicit stringFilter: StringFilter): Option[Double] =
		NGramMetric.compare(charArray1, charArray2)(n)(stringFilter)

	def compareNGram(string1: String, string2: String)(n: Int)(implicit stringFilter: StringFilter): Option[Double] =
		NGramMetric.compare(string1, string2)(n)(stringFilter)

	def compareNysiis(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Boolean] =
		NysiisMetric.compare(charArray1, charArray2)(stringFilter)

	def compareNysiis(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Boolean] =
		NysiisMetric.compare(string1, string2)(stringFilter)

	def compareRefinedSoundex(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Boolean] =
		RefinedSoundexMetric.compare(charArray1, charArray2)(stringFilter)

	def compareRefinedSoundex(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Boolean] =
		RefinedSoundexMetric.compare(string1, string2)(stringFilter)

	def compareSoundex(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Boolean] =
		SoundexMetric.compare(charArray1, charArray2)(stringFilter)

	def compareSoundex(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Boolean] =
		SoundexMetric.compare(string1, string2)(stringFilter)

	def compareWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: Tuple3[BigDecimal, BigDecimal, BigDecimal])(implicit stringFilter: StringFilter): Option[Double] =
		WeightedLevenshteinMetric.compare(charArray1, charArray2)(options)(stringFilter)

	def compareWeightedLevenshtein(string1: String, string2: String)
		(options: Tuple3[BigDecimal, BigDecimal, BigDecimal])(implicit stringFilter: StringFilter): Option[Double] =
		WeightedLevenshteinMetric.compare(string1, string2)(options)(stringFilter)

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