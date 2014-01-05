package com.rockymadden.stringmetric

object Algorithm {
	import scala.collection.immutable.Map
	import Transform._


	trait Algorithm[A] {
		def compute(a: A): Option[A]
	}


	object Algorithm {
		implicit def stringAlgorithmToDecorated(sa: StringAlgorithm): StringAlgorithmDecorator =
			new StringAlgorithmDecorator(sa)
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


	trait AlgorithmDecorator[A] {
		val withMemoization: Algorithm[A]

		val withTransform: (Transform[A] => Algorithm[A])
	}


	final case class StringAlgorithmDecorator(sa: StringAlgorithm) extends AlgorithmDecorator[Array[Char]] {
		override val withMemoization: StringAlgorithm = new StringAlgorithm {
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

		override val withTransform: (StringTransform => StringAlgorithm) = (st) => new StringAlgorithm {
			private val base: StringAlgorithm = sa
			private val transform: StringTransform = st

			override def compute(a: Array[Char]): Option[Array[Char]] = base.compute(transform(a))

			override def compute(a: String): Option[String] = compute(a.toCharArray).map(_.mkString)
		}
	}
}
