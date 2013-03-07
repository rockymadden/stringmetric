package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic._

trait StringAlgorithm[R] extends Algorithm[String, R] {
	def compute(charArray: Array[Char]): Option[Array[_]]
}

object StringAlgorithm {
	lazy val metaphone = MetaphoneAlgorithm()
	lazy val nysiis = NysiisAlgorithm()
	lazy val refinedNysiis = RefinedNysiisAlgorithm()
	lazy val refinedSoundex = RefinedSoundexAlgorithm()
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
