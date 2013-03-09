package com.rockymadden.stringmetric

trait StringMetric[R] extends Metric[String, R] {
	def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[R]
}

object StringMetric {
	type HammingMetric = com.rockymadden.stringmetric.similarity.HammingMetric
	val HammingMetric = com.rockymadden.stringmetric.similarity.HammingMetric

	type JaroMetric = com.rockymadden.stringmetric.similarity.JaroMetric
	val JaroMetric = com.rockymadden.stringmetric.similarity.JaroMetric

	type JaroWinklerMetric = com.rockymadden.stringmetric.similarity.JaroWinklerMetric
	val JaroWinklerMetric = com.rockymadden.stringmetric.similarity.JaroWinklerMetric

	type LevenshteinMetric = com.rockymadden.stringmetric.similarity.LevenshteinMetric
	val LevenshteinMetric = com.rockymadden.stringmetric.similarity.LevenshteinMetric

	type MetaphoneMetric = com.rockymadden.stringmetric.phonetic.MetaphoneMetric
	val MetaphoneMetric = com.rockymadden.stringmetric.phonetic.MetaphoneMetric

	type NysiisMetric = com.rockymadden.stringmetric.phonetic.NysiisMetric
	val NysiisMetric = com.rockymadden.stringmetric.phonetic.NysiisMetric

	type RefinedNysiisMetric = com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric
	val RefinedNysiisMetric = com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric

	type RefinedSoundexMetric = com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric
	val RefinedSoundexMetric = com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric

	type SoundexMetric = com.rockymadden.stringmetric.phonetic.SoundexMetric
	val SoundexMetric = com.rockymadden.stringmetric.phonetic.SoundexMetric

	def compareWithHamming(charArray1: Array[Char], charArray2: Array[Char]) =
		HammingMetric.compare(charArray1, charArray2)

	def compareWithHamming(string1: String, string2: String)= HammingMetric.compare(string1, string2)

	def compareWithJaro(charArray1: Array[Char], charArray2: Array[Char]) = JaroMetric.compare(charArray1, charArray2)

	def compareWithJaro(string1: String, string2: String) = JaroMetric.compare(string1, string2)

	def compareWithJaroWinkler(charArray1: Array[Char], charArray2: Array[Char]) =
		JaroWinklerMetric.compare(charArray1, charArray2)

	def compareWithJaroWinkler(string1: String, string2: String) = JaroWinklerMetric.compare(string1, string2)

	def compareWithLevenshtein(charArray1: Array[Char], charArray2: Array[Char]) =
		LevenshteinMetric.compare(charArray1, charArray2)

	def compareWithLevenshtein(string1: String, string2: String) = LevenshteinMetric.compare(string1, string2)

	def compareWithMetaphone(charArray1: Array[Char], charArray2: Array[Char]) =
		MetaphoneMetric.compare(charArray1, charArray2)

	def compareWithMetaphone(string1: String, string2: String) = MetaphoneMetric.compare(string1, string2)

	def compareWithNysiis(charArray1: Array[Char], charArray2: Array[Char]) =
		NysiisMetric.compare(charArray1, charArray2)

	def compareWithNysiis(string1: String, string2: String) = NysiisMetric.compare(string1, string2)

	def compareWithRefinedNysiis(charArray1: Array[Char], charArray2: Array[Char]) =
		RefinedNysiisMetric.compare(charArray1, charArray2)

	def compareWithRefinedNysiis(string1: String, string2: String) = RefinedNysiisMetric.compare(string1, string2)

	def compareWithRefinedSoundex(charArray1: Array[Char], charArray2: Array[Char]) =
		RefinedSoundexMetric.compare(charArray1, charArray2)

	def compareWithRefinedSoundex(string1: String, string2: String) = RefinedSoundexMetric.compare(string1, string2)

	def compareWithSoundex(charArray1: Array[Char], charArray2: Array[Char]) =
		SoundexMetric.compare(charArray1, charArray2)

	def compareWithSoundex(string1: String, string2: String) = SoundexMetric.compare(string1, string2)
}
