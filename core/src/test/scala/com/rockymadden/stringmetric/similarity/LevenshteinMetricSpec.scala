package com.rockymadden.stringmetric.similarity

object LevenshteinMetricSpec extends org.specs2.mutable.Specification {
	"LevenshteinMetric compare()" should {
		"return None with empty arguments" in {
			LevenshteinMetric.compare("", "").isDefined must beFalse
			LevenshteinMetric.compare("abc", "").isDefined must beFalse
			LevenshteinMetric.compare("", "xyz").isDefined must beFalse
		}
		"return 0 with equal arguments" in {
			LevenshteinMetric.compare("abc", "abc").get must beEqualTo(0)
			LevenshteinMetric.compare("123", "123").get must beEqualTo(0)
		}
		"return distance with unequal arguments" in {
			LevenshteinMetric.compare("abc", "xyz").get must beEqualTo(3)
			LevenshteinMetric.compare("123", "456").get must beEqualTo(3)
		}
		"return distance with valid arguments" in {
			LevenshteinMetric.compare("abc", "a").get must beEqualTo(2)
			LevenshteinMetric.compare("a", "abc").get must beEqualTo(2)
			LevenshteinMetric.compare("abc", "c").get must beEqualTo(2)
			LevenshteinMetric.compare("c", "abc").get must beEqualTo(2)
			LevenshteinMetric.compare("sitting", "kitten").get must beEqualTo(3)
			LevenshteinMetric.compare("kitten", "sitting").get must beEqualTo(3)
			LevenshteinMetric.compare("cake", "drake").get must beEqualTo(2)
			LevenshteinMetric.compare("drake", "cake").get must beEqualTo(2)
			LevenshteinMetric.compare("saturday", "sunday").get must beEqualTo(3)
			LevenshteinMetric.compare("sunday", "saturday").get must beEqualTo(3)
			LevenshteinMetric.compare("book", "back").get must beEqualTo(2)
			LevenshteinMetric.compare("dog", "fog").get must beEqualTo(1)
			LevenshteinMetric.compare("foq", "fog").get must beEqualTo(1)
			LevenshteinMetric.compare("fvg", "fog").get must beEqualTo(1)
			LevenshteinMetric.compare("encyclopedia", "encyclopediaz").get must beEqualTo(1)
			LevenshteinMetric.compare("encyclopediz", "encyclopediaz").get must beEqualTo(1)
		}
	}
}
