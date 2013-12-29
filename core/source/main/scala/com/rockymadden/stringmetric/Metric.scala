package com.rockymadden.stringmetric

object Metric {
	import com.rockymadden.stringmetric.Transform.StringTransform


	trait Metric[A, B] {
		def compare(a: A, b: A): Option[B]
	}


	trait StringMetric[A] extends Metric[Array[Char], A] {
		def compare(a: String, b: String): Option[A]
	}


	object StringMetric {
		final val DiceSorensen = com.rockymadden.stringmetric.similarity.DiceSorensenMetric
		final val Hamming = com.rockymadden.stringmetric.similarity.HammingMetric
		final val Jaccard = com.rockymadden.stringmetric.similarity.JaccardMetric
		final val Jaro = com.rockymadden.stringmetric.similarity.JaroMetric
		final val JaroWinkler = com.rockymadden.stringmetric.similarity.JaroWinklerMetric
		final val Levenshtein = com.rockymadden.stringmetric.similarity.LevenshteinMetric
		final val Metaphone = com.rockymadden.stringmetric.phonetic.MetaphoneMetric
		final val NGram = com.rockymadden.stringmetric.similarity.NGramMetric
		final val Nysiis = com.rockymadden.stringmetric.phonetic.NysiisMetric
		final val Overlap = com.rockymadden.stringmetric.similarity.OverlapMetric
		final val RefinedNysiis = com.rockymadden.stringmetric.phonetic.RefinedNysiisMetric
		final val RefinedSoundex = com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric
		final val Soundex = com.rockymadden.stringmetric.phonetic.SoundexMetric
		final val WeightedLevenshtein = com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric

		def compareWithDiceSorensen(n: Int)(a: Array[Char], b: Array[Char]) = DiceSorensen(n).compare(a, b)

		def compareWithHamming(a: Array[Char], b: Array[Char]) = Hamming.compare(a, b)

		def compareWithJaccard(n: Int)(a: Array[Char], b: Array[Char]) = Jaccard(n).compare(a, b)

		def compareWithJaro(a: Array[Char], b: Array[Char]) = Jaro.compare(a, b)

		def compareWithJaroWinkler(a: Array[Char], b: Array[Char]) = JaroWinkler.compare(a, b)

		def compareWithLevenshtein(a: Array[Char], b: Array[Char]) = Levenshtein.compare(a, b)

		def compareWithMetaphone(a: Array[Char], b: Array[Char]) = Metaphone.compare(a, b)

		def compareWithNGram(n: Int)(a: Array[Char], b: Array[Char]) = NGram(n).compare(a, b)

		def compareWithNysiis(a: Array[Char], b: Array[Char]) = Nysiis.compare(a, b)

		def compareWithOverlap(n: Int)(a: Array[Char], b: Array[Char]) = Overlap(n).compare(a, b)

		def compareWithRefinedNysiis(a: Array[Char], b: Array[Char]) = RefinedNysiis.compare(a, b)

		def compareWithRefinedSoundex(a: Array[Char], b: Array[Char]) = RefinedSoundex.compare(a, b)

		def compareWithSoundex(a: Array[Char], b: Array[Char]) = Soundex.compare(a, b)

		def compareWithWeightedLevenshtein(delete: BigDecimal, insert: BigDecimal, substitute: BigDecimal)
			(a: Array[Char], b: Array[Char]) =

			WeightedLevenshtein(delete, insert, substitute).compare(a, b)
	}

	final class StringMetricDecorator[A](val sm: StringMetric[A]) {
		val withTransform: (StringTransform => StringMetric[A]) = (st) => new StringMetric[A] {
			private[this] val self: StringMetric[A] = sm
			private[this] val transform: StringTransform = st

			override def compare(a: Array[Char], b: Array[Char]): Option[A] =
				self.compare(transform(a), transform(b))

			override def compare(a: String, b: String): Option[A] =
				self.compare(transform(a.toCharArray), transform(b.toCharArray))
		}
	}
}
