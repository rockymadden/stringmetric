package com.rockymadden.stringmetric

object Algorithm {
	import Transform.StringTransform


	trait Algorithm[A] {
		def compute(a: A): Option[A]
	}


	trait StringAlgorithm extends Algorithm[Array[Char]] {
		def compute(a: String): Option[String]
	}


	object StringAlgorithm {
		val Metaphone = phonetic.MetaphoneAlgorithm
		val Nysiis = phonetic.NysiisAlgorithm
		val RefinedNysiis = phonetic.RefinedNysiisAlgorithm
		val RefinedSoundex = phonetic.RefinedSoundexAlgorithm
		val Soundex = phonetic.SoundexAlgorithm

		def computeWithMetaphone(a: Array[Char]) = Metaphone.compute(a)

		def computeWithNysiis(a: Array[Char]) = Nysiis.compute(a)

		def computeWithRefinedNysiis(a: Array[Char]) = RefinedNysiis.compute(a)

		def computeWithRefinedSoundex(a: Array[Char]) = RefinedSoundex.compute(a)

		def computeWithSoundex(a: Array[Char]) = Soundex.compute(a)
	}


	final class StringAlgorithmDecorator(val sa: StringAlgorithm) {
		val withTransform: (StringTransform => StringAlgorithm) = (st) => new StringAlgorithm {
			private[this] val self: StringAlgorithm = sa
			private[this] val transform: StringTransform = st

			override def compute(a: Array[Char]): Option[Array[Char]] = self.compute(transform(a))

			override def compute(a: String): Option[String] = self.compute(transform(a.toCharArray)).map(_.mkString)
		}
	}
}
