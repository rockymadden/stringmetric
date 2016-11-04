package com.rockymadden.stringmetric.similarity

object WeightedLevenshteinMetricSpec extends org.specs2.mutable.Specification {
	"WeightedLevenshteinMetric compare()" should {
		"return None with empty arguments" in {
			WeightedLevenshteinMetric(10, 0.1, 1).compare("", "").isDefined must beFalse
			WeightedLevenshteinMetric(10, 0.1, 1).compare("abc", "").isDefined must beFalse
			WeightedLevenshteinMetric(10, 0.1, 1).compare("", "xyz").isDefined must beFalse
		}
		"return 0 with equal arguments" in {
			WeightedLevenshteinMetric(10, 0.1, 1).compare("abc", "abc").get must beEqualTo(0)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("123", "123").get must beEqualTo(0)
		}
		"return distance with unequal arguments" in {
			WeightedLevenshteinMetric(10, 0.1, 1).compare("abc", "xyz").get must beEqualTo(3)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("123", "456").get must beEqualTo(3)
		}
		"return distance with valid arguments" in {
			WeightedLevenshteinMetric(10, 0.1, 1).compare("az", "z").get must beEqualTo(10)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("z", "az").get must beEqualTo(0.1)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("a", "z").get must beEqualTo(1)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("z", "a").get must beEqualTo(1)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("ab", "yz").get must beEqualTo(2)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("yz", "ab").get must beEqualTo(2)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("0", "0123456789").get must beEqualTo(0.9)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("0123456789", "0").get must beEqualTo(90)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("book", "back").get must beEqualTo(2)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("back", "book").get must beEqualTo(2)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("hosp", "hospital").get must beEqualTo(0.4)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("hospital", "hosp").get must beEqualTo(40)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("clmbs blvd", "columbus boulevard").get must beEqualTo(0.8)
			WeightedLevenshteinMetric(10, 0.1, 1).compare("columbus boulevard", "clmbs blvd").get must beEqualTo(80)
		}
	}
}
