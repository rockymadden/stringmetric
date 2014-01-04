package com.rockymadden.stringmetric

object Metric {
	import Transform.StringTransform


	trait Metric[A, B] {
		def compare(a: A, b: A): Option[B]
	}


	trait StringMetric[A] extends Metric[Array[Char], A] {
		def compare(a: String, b: String): Option[A]
	}


	object StringMetric {
		val DiceSorensen = similarity.DiceSorensenMetric
		val Hamming = similarity.HammingMetric
		val Jaccard = similarity.JaccardMetric
		val Jaro = similarity.JaroMetric
		val JaroWinkler = similarity.JaroWinklerMetric
		val Levenshtein = similarity.LevenshteinMetric
		val Metaphone = phonetic.MetaphoneMetric
		val NGram = similarity.NGramMetric
		val Nysiis = phonetic.NysiisMetric
		val Overlap = similarity.OverlapMetric
		val RefinedNysiis = phonetic.RefinedNysiisMetric
		val RefinedSoundex = phonetic.RefinedSoundexMetric
		val Soundex = phonetic.SoundexMetric
		val WeightedLevenshtein = similarity.WeightedLevenshteinMetric

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
