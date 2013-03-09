package com.rockymadden.stringmetric

trait StringAlgorithm[R] extends Algorithm[String, R] {
	def compute(charArray: Array[Char]): Option[Array[_]]
}

object StringAlgorithm {
	type MetaphoneAlgorithm = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
	val MetaphoneAlgorithm = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm

	type NysiisAlgorithm = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm
	val NysiisAlgorithm = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm

	type RefinedNysiisAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm
	val RefinedNysiisAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm

	type RefinedSoundexAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm
	val RefinedSoundexAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm

	type SoundexAlgorithm = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm
	val SoundexAlgorithm = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm

	def computeWithMetaphone(charArray: Array[Char]) = MetaphoneAlgorithm.compute(charArray)

	def computeWithMetaphone(string: String) = MetaphoneAlgorithm.compute(string)

	def computeWithNysiis(charArray: Array[Char]) = NysiisAlgorithm.compute(charArray)

	def computeWithNysiis(string: String) = NysiisAlgorithm.compute(string)

	def computeWithRefinedNysiis(charArray: Array[Char]) = RefinedNysiisAlgorithm.compute(charArray)

	def computeWithRefinedNysiis(string: String) = RefinedNysiisAlgorithm.compute(string)

	def computeWithRefinedSoundex(charArray: Array[Char]) = RefinedSoundexAlgorithm.compute(charArray)

	def computeWithRefinedSoundex(string: String) = RefinedSoundexAlgorithm.compute(string)

	def computeWithSoundex(charArray: Array[Char]) = SoundexAlgorithm.compute(charArray)

	def computeWithSoundex(string: String) = SoundexAlgorithm.compute(string)
}
