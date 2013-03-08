package com.rockymadden.stringmetric

trait StringAlgorithm[R] extends Algorithm[String, R] {
	def compute(charArray: Array[Char]): Option[Array[_]]
}

object StringAlgorithm {
	type MetaphoneAlgorithm = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
	val MetaphoneAlgorithm = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
	lazy val metaphone = MetaphoneAlgorithm()

	type NysiisAlgorithm = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm
	val NysiisAlgorithm = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm
	lazy val nysiis = NysiisAlgorithm()

	type RefinedNysiisAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm
	val RefinedNysiisAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm
	lazy val refinedNysiis = RefinedNysiisAlgorithm()

	type RefinedSoundexAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm
	val RefinedSoundexAlgorithm = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm
	lazy val refinedSoundex = RefinedSoundexAlgorithm()

	type SoundexAlgorithm = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm
	val SoundexAlgorithm = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm
	lazy val soundex = SoundexAlgorithm()

	def computeWithMetaphone(charArray: Array[Char]): Option[Array[Char]] = metaphone.compute(charArray)

	def computeWithMetaphone(string: String): Option[String] = metaphone.compute(string)

	def computeWithNysiis(charArray: Array[Char]): Option[Array[Char]] = nysiis.compute(charArray)

	def computeWithNysiis(string: String): Option[String] = nysiis.compute(string)

	def computeWithRefinedNysiis(charArray: Array[Char]): Option[Array[Char]] = refinedNysiis.compute(charArray)

	def computeWithRefinedNysiis(string: String): Option[String] = refinedNysiis.compute(string)

	def computeWithRefinedSoundex(charArray: Array[Char]): Option[Array[Char]] = refinedSoundex.compute(charArray)

	def computeWithRefinedSoundex(string: String): Option[String] = refinedSoundex.compute(string)

	def computeWithSoundex(charArray: Array[Char]): Option[Array[Char]] = soundex.compute(charArray)

	def computeWithSoundex(string: String): Option[String] = soundex.compute(string)
}
