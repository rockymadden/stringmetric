package com.rockymadden.stringmetric

import scala.language.implicitConversions

trait StringAlgorithm extends Algorithm[Array[Char]] {
	def compute(a: String): Option[String]
}

object StringAlgorithm {
	val Metaphone = phonetic.MetaphoneAlgorithm
	val Nysiis = phonetic.NysiisAlgorithm
	val RefinedNysiis = phonetic.RefinedNysiisAlgorithm
	val RefinedSoundex = phonetic.RefinedSoundexAlgorithm
	val Soundex = phonetic.SoundexAlgorithm

	implicit def toStringAlgorithmDecorator(sa: StringAlgorithm): StringAlgorithmDecorator =
		new StringAlgorithmDecorator(sa)

	def computeWithMetaphone(a: Array[Char]) = Metaphone.compute(a)

	def computeWithNysiis(a: Array[Char]) = Nysiis.compute(a)

	def computeWithRefinedNysiis(a: Array[Char]) = RefinedNysiis.compute(a)

	def computeWithRefinedSoundex(a: Array[Char]) = RefinedSoundex.compute(a)

	def computeWithSoundex(a: Array[Char]) = Soundex.compute(a)
}
