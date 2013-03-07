package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic.{ MetaphoneAlgorithm, NysiisAlgorithm, RefinedSoundexAlgorithm, SoundexAlgorithm }

trait StringAlgorithm[R] extends Algorithm[String, R] {
	def compute(charArray: Array[Char]): Option[Array[_]]
}

object StringAlgorithm {
	def computeWithMetaphone(charArray: Array[Char]): Option[Array[Char]] = MetaphoneAlgorithm().compute(charArray)

	def computeWithMetaphone(string: String): Option[String] = MetaphoneAlgorithm().compute(string)

	def computeWithNysiis(charArray: Array[Char]): Option[Array[Char]] = NysiisAlgorithm().compute(charArray)

	def computeWithNysiis(string: String): Option[String] = NysiisAlgorithm().compute(string)

	def computeWithRefinedSoundex(charArray: Array[Char]): Option[Array[Char]] =
		RefinedSoundexAlgorithm().compute(charArray)

	def computeWithRefinedSoundex(string: String): Option[String] = RefinedSoundexAlgorithm().compute(string)

	def computeWithSoundex(charArray: Array[Char]): Option[Array[Char]] = SoundexAlgorithm().compute(charArray)

	def computeWithSoundex(string: String): Option[String] = SoundexAlgorithm().compute(string)

	def metaphone: MetaphoneAlgorithm.type = MetaphoneAlgorithm

	def nysiis: NysiisAlgorithm.type = NysiisAlgorithm

	def refinedSoundex: RefinedSoundexAlgorithm.type = RefinedSoundexAlgorithm

	def soundex: SoundexAlgorithm.type = SoundexAlgorithm
}
