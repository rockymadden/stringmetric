package com.rockymadden.stringmetric

object Algorithm {
	import scala.collection.immutable.Map
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
		val withMemoization: StringAlgorithm = new StringAlgorithm {
			private val base: StringAlgorithm = sa
			private var memo: Map[String, Option[String]] = Map()

			override def compute(a: Array[Char]): Option[Array[Char]] =
				compute(a.toString).map(_.toCharArray)

			override def compute(a: String): Option[String] =
				if (memo.contains(a)) memo(a)
				else {
					memo = memo + (a -> base.compute(a))
					memo(a)
				}
		}

		val withTransform: (StringTransform => StringAlgorithm) = (st) => new StringAlgorithm {
			private val base: StringAlgorithm = sa
			private val transform: StringTransform = st

			override def compute(a: Array[Char]): Option[Array[Char]] = base.compute(transform(a))

			override def compute(a: String): Option[String] = compute(a.toCharArray).map(_.mkString)
		}
	}
}
