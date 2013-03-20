package com.rockymadden.stringmetric

trait StringMetric[A, B] extends Metric[String, A, B] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit a: A): Option[B]
}

object StringMetric {
	type DiceSorensen = com.rockymadden.stringmetric.similarity.DiceSorensenMetric
	val DiceSorensen = com.rockymadden.stringmetric.similarity.DiceSorensenMetric

	type Hamming = com.rockymadden.stringmetric.similarity.HammingMetric
	val Hamming = com.rockymadden.stringmetric.similarity.HammingMetric

	type Jaccard = com.rockymadden.stringmetric.similarity.JaccardMetric
	val Jaccard = com.rockymadden.stringmetric.similarity.JaccardMetric

	type Jaro = com.rockymadden.stringmetric.similarity.JaroMetric
	val Jaro = com.rockymadden.stringmetric.similarity.JaroMetric

	type JaroWinkler = com.rockymadden.stringmetric.similarity.JaroWinklerMetric
	val JaroWinkler = com.rockymadden.stringmetric.similarity.JaroWinklerMetric

	type Levenshtein = com.rockymadden.stringmetric.similarity.LevenshteinMetric
	val Levenshtein = com.rockymadden.stringmetric.similarity.LevenshteinMetric

	type Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneMetric
	val Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneMetric

	type NGram = com.rockymadden.stringmetric.similarity.NGramMetric
	val NGram = com.rockymadden.stringmetric.similarity.NGramMetric

	type Nysiis = com.rockymadden.stringmetric.phonetic.NysiisMetric
	val Nysiis = com.rockymadden.stringmetric.phonetic.NysiisMetric

	type Overlap = com.rockymadden.stringmetric.similarity.OverlapMetric
	val Overlap = com.rockymadden.stringmetric.similarity.OverlapMetric

	type RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric
	val RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric

	type RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric
	val RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric

	type Soundex = com.rockymadden.stringmetric.phonetic.SoundexMetric
	val Soundex = com.rockymadden.stringmetric.phonetic.SoundexMetric

	type WeightedLevenshtein = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric
	val WeightedLevenshtein = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric

	def compareWithDiceSorensen(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		DiceSorensen.compare(charArray1, charArray2)(n)

	def compareWithDiceSorensen(string1: String, string2: String)(n: Int) = DiceSorensen.compare(string1, string2)(n)

	def compareWithHamming(charArray1: Array[Char], charArray2: Array[Char]) = Hamming.compare(charArray1, charArray2)

	def compareWithHamming(string1: String, string2: String)= Hamming.compare(string1, string2)

	def compareWithJaccard(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		Jaccard.compare(charArray1, charArray2)(n)

	def compareWithJaccard(string1: String, string2: String)(n: Int) = Jaccard.compare(string1, string2)(n)

	def compareWithJaro(charArray1: Array[Char], charArray2: Array[Char]) = Jaro.compare(charArray1, charArray2)

	def compareWithJaro(string1: String, string2: String) = Jaro.compare(string1, string2)

	def compareWithJaroWinkler(charArray1: Array[Char], charArray2: Array[Char]) =
		JaroWinkler.compare(charArray1, charArray2)

	def compareWithJaroWinkler(string1: String, string2: String) = JaroWinkler.compare(string1, string2)

	def compareWithLevenshtein(charArray1: Array[Char], charArray2: Array[Char]) =
		Levenshtein.compare(charArray1, charArray2)

	def compareWithLevenshtein(string1: String, string2: String) = Levenshtein.compare(string1, string2)

	def compareWithMetaphone(charArray1: Array[Char], charArray2: Array[Char]) =
		Metaphone.compare(charArray1, charArray2)

	def compareWithMetaphone(string1: String, string2: String) = Metaphone.compare(string1, string2)

	def compareWithNGram(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		NGram.compare(charArray1, charArray2)(n)

	def compareWithNGram(string1: String, string2: String)(n: Int) = NGram.compare(string1, string2)(n)

	def compareWithNysiis(charArray1: Array[Char], charArray2: Array[Char]) = Nysiis.compare(charArray1, charArray2)

	def compareWithNysiis(string1: String, string2: String) = Nysiis.compare(string1, string2)

	def compareWithOverlap(charArray1: Array[Char], charArray2: Array[Char])(n: Int) =
		Overlap.compare(charArray1, charArray2)(n)

	def compareWithOverlap(string1: String, string2: String)(n: Int) = Overlap.compare(string1, string2)(n)

	def compareWithRefinedNysiis(charArray1: Array[Char], charArray2: Array[Char]) =
		RefinedNysiis.compare(charArray1, charArray2)

	def compareWithRefinedNysiis(string1: String, string2: String) = RefinedNysiis.compare(string1, string2)

	def compareWithRefinedSoundex(charArray1: Array[Char], charArray2: Array[Char]) =
		RefinedSoundex.compare(charArray1, charArray2)

	def compareWithRefinedSoundex(string1: String, string2: String) = RefinedSoundex.compare(string1, string2)

	def compareWithSoundex(charArray1: Array[Char], charArray2: Array[Char]) = Soundex.compare(charArray1, charArray2)

	def compareWithSoundex(string1: String, string2: String) = Soundex.compare(string1, string2)

	def compareWithWeightedLevenshtein(charArray1: Array[Char], charArray2: Array[Char])
		(options: (BigDecimal, BigDecimal, BigDecimal)) =

		WeightedLevenshtein.compare(charArray1, charArray2)(options)

	def compareWithWeightedLevenshtein(string1: String, string2: String)
		(options: (BigDecimal, BigDecimal, BigDecimal)) =

		WeightedLevenshtein.compare(string1, string2)(options)
}
