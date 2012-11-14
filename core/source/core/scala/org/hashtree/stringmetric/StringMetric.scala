package org.hashtree.stringmetric

import org.hashtree.stringmetric.phonetic.{ MetaphoneMetric, NysiisMetric, RefinedSoundexMetric, SoundexMetric }
import org.hashtree.stringmetric.similarity._

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Metric]]. */
trait StringMetric extends Metric[String] {

}

/** Convenience object for those extending [[org.hashtree.stringmetric.StringMetric]]. */
object StringMetric {
	def compareWithDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int)
		(implicit stringFilter: StringFilter): Option[DiceSorensenMetric.CompareReturn] =

		DiceSorensenMetric.compare(charArray1, charArray2)(n)(stringFilter)

	def compareWithDiceSorensen(string1: String, string2: String)(n: Int)
		(implicit stringFilter: StringFilter): Option[DiceSorensenMetric.CompareReturn] =

		DiceSorensenMetric.compare(string1, string2)(n)(stringFilter)

	def compareWithHamming(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[HammingMetric.CompareReturn] =

		HammingMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithHamming(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[HammingMetric.CompareReturn] =

		HammingMetric.compare(string1, string2)(stringFilter)

	def compareWithJaro(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[JaroMetric.CompareReturn] =

		JaroMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithJaro(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[JaroMetric.CompareReturn] =

		JaroMetric.compare(string1, string2)(stringFilter)

	def compareWithJaroWinkler(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[JaroWinklerMetric.CompareReturn] =

		JaroWinklerMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithJaroWinkler(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[JaroWinklerMetric.CompareReturn] =

		JaroWinklerMetric.compare(string1, string2)(stringFilter)

	def compareWithLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[LevenshteinMetric.CompareReturn] =

		LevenshteinMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithLevenshtein(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[LevenshteinMetric.CompareReturn] =

		LevenshteinMetric.compare(string1, string2)(stringFilter)

	def compareWithMetaphone(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[MetaphoneMetric.CompareReturn] =

		MetaphoneMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithMetaphone(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[MetaphoneMetric.CompareReturn] =

		MetaphoneMetric.compare(string1, string2)(stringFilter)

	def compareWithNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int)
		(implicit stringFilter: StringFilter): Option[NGramMetric.CompareReturn] =

		NGramMetric.compare(charArray1, charArray2)(n)(stringFilter)

	def compareWithNGram(string1: String, string2: String)(n: Int)
		(implicit stringFilter: StringFilter): Option[NGramMetric.CompareReturn] =

		NGramMetric.compare(string1, string2)(n)(stringFilter)

	def compareWithNysiis(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[NysiisMetric.CompareReturn] =

		NysiisMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithNysiis(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[NysiisMetric.CompareReturn] =

		NysiisMetric.compare(string1, string2)(stringFilter)

	def compareWithRefinedSoundex(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[RefinedSoundexMetric.CompareReturn] =

		RefinedSoundexMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithRefinedSoundex(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[RefinedSoundexMetric.CompareReturn] =

		RefinedSoundexMetric.compare(string1, string2)(stringFilter)

	def compareWithSoundex(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[SoundexMetric.CompareReturn] =

		SoundexMetric.compare(charArray1, charArray2)(stringFilter)

	def compareWithSoundex(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[SoundexMetric.CompareReturn] =

		SoundexMetric.compare(string1, string2)(stringFilter)

	def compareWithWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: Tuple3[BigDecimal, BigDecimal, BigDecimal])
		(implicit stringFilter: StringFilter): Option[WeightedLevenshteinMetric.CompareReturn] =

		WeightedLevenshteinMetric.compare(charArray1, charArray2)(options)(stringFilter)

	def compareWithWeightedLevenshtein(string1: String, string2: String)
		(options: Tuple3[BigDecimal, BigDecimal, BigDecimal])
		(implicit stringFilter: StringFilter): Option[WeightedLevenshteinMetric.CompareReturn] =

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