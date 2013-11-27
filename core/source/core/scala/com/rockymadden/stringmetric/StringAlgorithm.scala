package com.rockymadden.stringmetric

trait StringAlgorithm[A, B] extends Algorithm[String, A, B] {
	def compute(charArray: Array[Char])(implicit a: A): Option[Array[Char]]
}

object StringAlgorithm {
	type Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
	val Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm

	type Nysiis = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm
	val Nysiis = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm

	type RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm
	val RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm

	type RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm
	val RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm

	type Soundex = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm
	val Soundex = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm

	def computeWithMetaphone(charArray: Array[Char]) = Metaphone.compute(charArray)

	def computeWithMetaphone(string: String) = Metaphone.compute(string)

	def computeWithNysiis(charArray: Array[Char]) = Nysiis.compute(charArray)

	def computeWithNysiis(string: String) = Nysiis.compute(string)

	def computeWithRefinedNysiis(charArray: Array[Char]) = RefinedNysiis.compute(charArray)

	def computeWithRefinedNysiis(string: String) = RefinedNysiis.compute(string)

	def computeWithRefinedSoundex(charArray: Array[Char]) = RefinedSoundex.compute(charArray)

	def computeWithRefinedSoundex(string: String) = RefinedSoundex.compute(string)

	def computeWithSoundex(charArray: Array[Char]) = Soundex.compute(charArray)

	def computeWithSoundex(string: String) = Soundex.compute(string)
}
