package com.rockymadden.stringmetric

object Algorithm {
	trait Algorithm[A] {
		def compute(a: A): Option[A]
	}


	trait StringAlgorithm extends Algorithm[Array[Char]] {
		def compute(a: String): Option[String]
	}


	object StringAlgorithm {
		final val Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
		final val Nysiis = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm
		final val RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm
		final val RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm
		final val Soundex = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm

		def computeWithMetaphone(a: Array[Char]) = Metaphone.compute(a)

		def computeWithNysiis(a: Array[Char]) = Nysiis.compute(a)

		def computeWithRefinedNysiis(a: Array[Char]) = RefinedNysiis.compute(a)

		def computeWithRefinedSoundex(a: Array[Char]) = RefinedSoundex.compute(a)

		def computeWithSoundex(a: Array[Char]) = Soundex.compute(a)
	}
}
