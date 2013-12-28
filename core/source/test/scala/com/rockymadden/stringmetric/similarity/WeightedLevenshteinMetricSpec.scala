package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class WeightedLevenshteinMetricSpec extends ScalaTest {
	"WeightedLevenshteinMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					WeightedLevenshteinMetric(10, 0.1, 1).compare("", "").isDefined should be (false)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("abc", "").isDefined should be (false)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"0" in {
					WeightedLevenshteinMetric(10, 0.1, 1).compare("abc", "abc").get should be (0)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("123", "123").get should be (0)
				}
			}
			"unequal arguments" should returns {
				"Double indicating distance" in {
					WeightedLevenshteinMetric(10, 0.1, 1).compare("abc", "xyz").get should be (3)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("123", "456").get should be (3)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					WeightedLevenshteinMetric(10, 0.1, 1).compare("az", "z").get should be (10)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("z", "az").get should be (0.1)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("a", "z").get should be (1)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("z", "a").get should be (1)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("ab", "yz").get should be (2)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("yz", "ab").get should be (2)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("0", "0123456789").get should be (0.9)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("0123456789", "0").get should be (90)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("book", "back").get should be (2)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("back", "book").get should be (2)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("hosp", "hospital").get should be (0.4)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("hospital", "hosp").get should be (40)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("clmbs blvd", "columbus boulevard").get should be (0.8)
					WeightedLevenshteinMetric(10, 0.1, 1).compare("columbus boulevard", "clmbs blvd").get should be (80)
				}
			}
		}
	}
}
