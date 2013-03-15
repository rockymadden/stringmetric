package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic._
import com.rockymadden.stringmetric.similarity._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class StringMetricSpec extends ScalaTest {
	"StringMetric standalone object" should provide {
		"compare method, type, and companion object pass-throughs" in {
			val hamming: StringMetric.Hamming = StringMetric.Hamming()

			hamming.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithHamming("testone", "testtwo").get)
			hamming.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithHamming("testone".toCharArray, "testtwo".toCharArray).get)
			hamming.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (HammingMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val jaro: StringMetric.Jaro = StringMetric.Jaro()

			jaro.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithJaro("testone", "testtwo").get)
			jaro.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithJaro("testone".toCharArray, "testtwo".toCharArray).get)
			jaro.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (JaroMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val jaroWinkler: StringMetric.JaroWinkler = StringMetric.JaroWinkler()

			jaroWinkler.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithJaroWinkler("testone", "testtwo").get)
			jaroWinkler.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithJaroWinkler("testone".toCharArray, "testtwo".toCharArray).get)
			jaroWinkler.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (JaroWinklerMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val levenshtein: StringMetric.Levenshtein = StringMetric.Levenshtein()

			levenshtein.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithLevenshtein("testone", "testtwo").get)
			levenshtein.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithLevenshtein("testone".toCharArray, "testtwo".toCharArray).get)
			levenshtein.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (LevenshteinMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val metaphone: StringMetric.Metaphone = StringMetric.Metaphone()

			metaphone.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithMetaphone("testone", "testtwo").get)
			metaphone.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithMetaphone("testone".toCharArray, "testtwo".toCharArray).get)
			metaphone.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (MetaphoneMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val nysiis: StringMetric.Nysiis = StringMetric.Nysiis()

			nysiis.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithNysiis("testone", "testtwo").get)
			nysiis.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithNysiis("testone".toCharArray, "testtwo".toCharArray).get)
			nysiis.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (NysiisMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val refinedNysiis: StringMetric.RefinedNysiis = StringMetric.RefinedNysiis()

			refinedNysiis.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithRefinedNysiis("testone", "testtwo").get)
			refinedNysiis.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithRefinedNysiis("testone".toCharArray, "testtwo".toCharArray).get)
			refinedNysiis.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (RefinedNysiisMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val refinedSoundex: StringMetric.RefinedSoundex = StringMetric.RefinedSoundex()

			refinedSoundex.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithRefinedSoundex("testone", "testtwo").get)
			refinedSoundex.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithRefinedSoundex("testone".toCharArray, "testtwo".toCharArray).get)
			refinedSoundex.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (RefinedSoundexMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)

			val soundex: StringMetric.Soundex = StringMetric.Soundex()

			soundex.compare("testone", "testtwo").get should
				equal (StringMetric.compareWithSoundex("testone", "testtwo").get)
			soundex.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (StringMetric.compareWithSoundex("testone".toCharArray, "testtwo".toCharArray).get)
			soundex.compare("testone".toCharArray, "testtwo".toCharArray).get should
				equal (SoundexMetric.compare("testone".toCharArray, "testtwo".toCharArray).get)
		}
	}
}


