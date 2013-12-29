package com.rockymadden.stringmetric

object Algorithm {
	trait Algorithm[A] {
		def compute(a: A): Option[A]
	}


	trait StringAlgorithm extends Algorithm[Array[Char]] {
		def compute(a: String): Option[String]
	}


	object StringAlgorithm {
		val Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
		val Nysiis = com.rockymadden.stringmetric.phonetic.NysiisAlgorithm
		val RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm
		val RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm
		val Soundex = com.rockymadden.stringmetric.phonetic.SoundexAlgorithm

		def computeWithMetaphone(charArray: Array[Char]) = Metaphone.compute(charArray)

		def computeWithNysiis(charArray: Array[Char]) = Nysiis.compute(charArray)

		def computeWithRefinedNysiis(charArray: Array[Char]) = RefinedNysiis.compute(charArray)

		def computeWithRefinedSoundex(charArray: Array[Char]) = RefinedSoundex.compute(charArray)

		def computeWithSoundex(charArray: Array[Char]) = Soundex.compute(charArray)
	}
}
