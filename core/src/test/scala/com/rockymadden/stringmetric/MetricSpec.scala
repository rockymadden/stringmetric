package com.rockymadden.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class MetricSpec extends ScalaTest {
	import phonetic._
	import similarity._
	import Metric._
	import Transform.StringTransform

	"StringMetric standalone object" should provide {
		"compare method and companion object pass through" in {
			StringMetric.compareWithDiceSorensen(1)("testone", "testtwo").get should
				equal (DiceSorensenMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithHamming("testone", "testtwo").get should
				equal (HammingMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithJaccard(1)("testone", "testtwo").get should
				equal (JaccardMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithJaro("testone", "testtwo").get should
				equal (JaroMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithJaroWinkler("testone", "testtwo").get should
				equal (JaroWinklerMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithLevenshtein("testone", "testtwo").get should
				equal (LevenshteinMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithMetaphone("testone", "testtwo").get should
				equal (MetaphoneMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithNGram(1)("testone", "testtwo").get should
				equal (NGramMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithNysiis("testone", "testtwo").get should
				equal (NysiisMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithOverlap(1)("testone", "testtwo").get should
				equal (OverlapMetric(1).compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithRefinedNysiis("testone", "testtwo").get should
				equal (RefinedNysiisMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithRefinedSoundex("testone", "testtwo").get should
				equal (RefinedSoundexMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithSoundex("testone", "testtwo").get should
				equal (SoundexMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
			StringMetric.compareWithWeightedLevenshtein(1, 2, 3)("testone", "testtwo").get should
				equal (WeightedLevenshteinMetric(1, 2, 3).compare("testone".toCharArray, "testtwo".toCharArray).get)
		}
	}

	"StringMetricDecorator" should provide {
		"withMemoization()" in {
			val memo = MetaphoneMetric withMemoization

			(0 until 1000000) foreach { i =>
				memo.compare("abc123", "abc456")
				memo.compare("abc456", "abc123")
			}
		}

		"withTransform()" in {
			(MetaphoneMetric withTransform StringTransform.filterAlpha).compare("abc123", "abc456").get should
				equal (true)
			(DiceSorensenMetric(1) withTransform StringTransform.filterAlpha).compare("abc123", "abc456").get should
				equal (1.0)

			(MetaphoneMetric withTransform (StringTransform.filterAlpha andThen StringTransform.filterUpperCase)).compare("abc123", "abc456")
		}
	}
}
