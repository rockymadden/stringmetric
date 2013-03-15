package com.rockymadden.stringmetric

trait StringMetric[R] extends Metric[String, R] {
	def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[R]
}

object StringMetric {
	type Hamming = com.rockymadden.stringmetric.similarity.HammingMetric
	val Hamming = com.rockymadden.stringmetric.similarity.HammingMetric

	type Jaro = com.rockymadden.stringmetric.similarity.JaroMetric
	val Jaro = com.rockymadden.stringmetric.similarity.JaroMetric

	type JaroWinkler = com.rockymadden.stringmetric.similarity.JaroWinklerMetric
	val JaroWinkler = com.rockymadden.stringmetric.similarity.JaroWinklerMetric

	type Levenshtein = com.rockymadden.stringmetric.similarity.LevenshteinMetric
	val Levenshtein = com.rockymadden.stringmetric.similarity.LevenshteinMetric

	type Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneMetric
	val Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneMetric

	type Nysiis = com.rockymadden.stringmetric.phonetic.NysiisMetric
	val Nysiis = com.rockymadden.stringmetric.phonetic.NysiisMetric

	type RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric
	val RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric

	type RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric
	val RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric

	type Soundex = com.rockymadden.stringmetric.phonetic.SoundexMetric
	val Soundex = com.rockymadden.stringmetric.phonetic.SoundexMetric

	def compareWithHamming(charArray1: Array[Char], charArray2: Array[Char]) = Hamming.compare(charArray1, charArray2)

	def compareWithHamming(string1: String, string2: String)= Hamming.compare(string1, string2)

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

	def compareWithNysiis(charArray1: Array[Char], charArray2: Array[Char]) = Nysiis.compare(charArray1, charArray2)

	def compareWithNysiis(string1: String, string2: String) = Nysiis.compare(string1, string2)

	def compareWithRefinedNysiis(charArray1: Array[Char], charArray2: Array[Char]) =
		RefinedNysiis.compare(charArray1, charArray2)

	def compareWithRefinedNysiis(string1: String, string2: String) = RefinedNysiis.compare(string1, string2)

	def compareWithRefinedSoundex(charArray1: Array[Char], charArray2: Array[Char]) =
		RefinedSoundex.compare(charArray1, charArray2)

	def compareWithRefinedSoundex(string1: String, string2: String) = RefinedSoundex.compare(string1, string2)

	def compareWithSoundex(charArray1: Array[Char], charArray2: Array[Char]) = Soundex.compare(charArray1, charArray2)

	def compareWithSoundex(string1: String, string2: String) = Soundex.compare(string1, string2)
}
