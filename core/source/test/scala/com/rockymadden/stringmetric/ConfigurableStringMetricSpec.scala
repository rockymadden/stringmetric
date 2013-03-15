package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.similarity._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class ConfigurableStringMetricSpec extends ScalaTest {
	"StringMetric standalone object" should provide {
		"compare method, type, and companion object pass-throughs" in {
			val diceSorensen: ConfigurableStringMetric.DiceSorensen = ConfigurableStringMetric.DiceSorensen()

			diceSorensen.compare("testone", "testtwo")(1).get should
				equal (ConfigurableStringMetric.compareWithDiceSorensen("testone", "testtwo")(1).get)
			diceSorensen.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (ConfigurableStringMetric.compareWithDiceSorensen("testone".toCharArray, "testtwo".toCharArray)(1).get)
			diceSorensen.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (DiceSorensenMetric.compare("testone".toCharArray, "testtwo".toCharArray)(1).get)

			val jaccard: ConfigurableStringMetric.Jaccard = ConfigurableStringMetric.Jaccard()

			jaccard.compare("testone", "testtwo")(1).get should
				equal (ConfigurableStringMetric.compareWithJaccard("testone", "testtwo")(1).get)
			jaccard.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (ConfigurableStringMetric.compareWithJaccard("testone".toCharArray, "testtwo".toCharArray)(1).get)
			jaccard.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (JaccardMetric.compare("testone".toCharArray, "testtwo".toCharArray)(1).get)

			val nGram: ConfigurableStringMetric.NGram = ConfigurableStringMetric.NGram()

			nGram.compare("testone", "testtwo")(1).get should
				equal (ConfigurableStringMetric.compareWithNGram("testone", "testtwo")(1).get)
			nGram.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (ConfigurableStringMetric.compareWithNGram("testone".toCharArray, "testtwo".toCharArray)(1).get)
			nGram.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (NGramMetric.compare("testone".toCharArray, "testtwo".toCharArray)(1).get)

			val overlap: ConfigurableStringMetric.Overlap = ConfigurableStringMetric.Overlap()

			overlap.compare("testone", "testtwo")(1).get should
				equal (ConfigurableStringMetric.compareWithOverlap("testone", "testtwo")(1).get)
			overlap.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (ConfigurableStringMetric.compareWithOverlap("testone".toCharArray, "testtwo".toCharArray)(1).get)
			overlap.compare("testone".toCharArray, "testtwo".toCharArray)(1).get should
				equal (OverlapMetric.compare("testone".toCharArray, "testtwo".toCharArray)(1).get)

			val weightedLevenshtein: ConfigurableStringMetric.WeightedLevenshtein = ConfigurableStringMetric.WeightedLevenshtein()

			weightedLevenshtein.compare("testone", "testtwo")(1, 2, 3).get should
				equal (ConfigurableStringMetric.compareWithWeightedLevenshtein("testone", "testtwo")(1, 2, 3).get)
			weightedLevenshtein.compare("testone".toCharArray, "testtwo".toCharArray)(1, 2, 3).get should
				equal (ConfigurableStringMetric.compareWithWeightedLevenshtein("testone".toCharArray, "testtwo".toCharArray)(1, 2, 3).get)
			weightedLevenshtein.compare("testone".toCharArray, "testtwo".toCharArray)(1, 2, 3).get should
				equal (WeightedLevenshteinMetric.compare("testone".toCharArray, "testtwo".toCharArray)(1, 2, 3).get)
		}
	}
}


