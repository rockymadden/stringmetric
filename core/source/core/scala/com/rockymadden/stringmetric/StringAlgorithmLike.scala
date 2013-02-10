package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic.{ MetaphoneAlgorithm, NysiisAlgorithm, RefinedSoundexAlgorithm, SoundexAlgorithm }
import com.rockymadden.stringmetric.similarity.NGramAlgorithm

trait StringAlgorithmLike[R] extends AlgorithmLike[String, R] { this: StringFilterLike =>
	def compute(charArray: Array[Char]): Option[Array[_]]

	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}

object StringAlgorithmLike {
	def computeWithMetaphone(charArray: Array[Char]): Option[Array[Char]] = MetaphoneAlgorithm().compute(charArray)

	def computeWithMetaphone(string: String): Option[String] = MetaphoneAlgorithm().compute(string)

	def computeWithNGram(charArray: Array[Char])(n: Int): Option[Array[Array[Char]]] =
		NGramAlgorithm().compute(charArray)(n)

	def computeWithNGram(string: String)(n: Int): Option[Array[String]] = NGramAlgorithm().compute(string)(n)

	def computeWithNysiis(charArray: Array[Char]): Option[Array[Char]] = NysiisAlgorithm().compute(charArray)

	def computeWithNysiis(string: String): Option[String] = NysiisAlgorithm().compute(string)

	def computeWithRefinedSoundex(charArray: Array[Char]): Option[Array[Char]] =
		RefinedSoundexAlgorithm().compute(charArray)

	def computeWithRefinedSoundex(string: String): Option[String] = RefinedSoundexAlgorithm().compute(string)

	def computeWithSoundex(charArray: Array[Char]): Option[Array[Char]] = SoundexAlgorithm().compute(charArray)

	def computeWithSoundex(string: String): Option[String] = SoundexAlgorithm().compute(string)

	def metaphone: MetaphoneAlgorithm.type = MetaphoneAlgorithm

	def nGram: NGramAlgorithm.type = NGramAlgorithm

	def nysiis: NysiisAlgorithm.type = NysiisAlgorithm

	def refinedSoundex: RefinedSoundexAlgorithm.type = RefinedSoundexAlgorithm

	def soundex: SoundexAlgorithm.type = SoundexAlgorithm
}
