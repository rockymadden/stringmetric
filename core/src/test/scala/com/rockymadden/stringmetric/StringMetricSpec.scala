package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic._
import com.rockymadden.stringmetric.similarity._
import com.rockymadden.stringmetric.transform._

object StringMetricSpec extends org.specs2.mutable.Specification {
	"StringMetric convenience methods" should {
		"pass through" in {
			StringMetric.compareWithDiceSorensen(1)("testone", "testtwo").get must
				beEqualTo(DiceSorensenMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithHamming("testone", "testtwo").get must
				beEqualTo(HammingMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithJaccard(1)("testone", "testtwo").get must
				beEqualTo(JaccardMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithJaro("testone", "testtwo").get must
				beEqualTo(JaroMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithJaroWinkler("testone", "testtwo").get must
				beEqualTo(JaroWinklerMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithLevenshtein("testone", "testtwo").get must
				beEqualTo(LevenshteinMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithMetaphone("testone", "testtwo").get must
				beEqualTo(MetaphoneMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithNGram(1)("testone", "testtwo").get must
				beEqualTo(NGramMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithNysiis("testone", "testtwo").get must
				beEqualTo(NysiisMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithOverlap(1)("testone", "testtwo").get must
				beEqualTo(OverlapMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithRefinedNysiis("testone", "testtwo").get must
				beEqualTo(RefinedNysiisMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithRefinedSoundex("testone", "testtwo").get must
				beEqualTo(RefinedSoundexMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithSoundex("testone", "testtwo").get must
				beEqualTo(SoundexMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithWeightedLevenshtein(1, 2, 3)("testone", "testtwo").get must
				beEqualTo(WeightedLevenshteinMetric(1, 2, 3).compare("testone".toCharArray, "testtwo".toCharArray).get)
		}
	}

	"StringMetricDecorator withMemoization()" should {
		"memoize" in {
			val memo = MetaphoneMetric withMemoization

			(0 until 1000000) foreach { i =>
				memo.compare("abc123", "abc456")
				memo.compare("abc456", "abc123")
			}

			true must beTrue
		}
	}

	"StringMetricDecorator withTransform()" should {
		"transform" in {
			(MetaphoneMetric withTransform filterAlpha).compare("abc123", "abc456").get must
				beEqualTo(true)
			(DiceSorensenMetric(1) withTransform filterAlpha).compare("abc123", "abc456").get must
				beEqualTo(1.0)
		}
	}
}
