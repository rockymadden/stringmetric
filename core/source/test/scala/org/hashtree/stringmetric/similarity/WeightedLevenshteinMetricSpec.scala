package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class WeightedLevenshteinMetricSpec extends ScalaTest {
	private[this] val Options = Tuple3[BigDecimal, BigDecimal, BigDecimal](10, 0.1, 1)

	"WeightedLevenshteinMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					WeightedLevenshteinMetric.compare("", "")(Options).isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"0" in {
					WeightedLevenshteinMetric.compare("abc", "abc")(Options).get should be (0)
					WeightedLevenshteinMetric.compare("123", "123")(Options).get should be (0)
				}
			}
			"unequal arguments" should returns {
				"Double indicating distance" in {
					WeightedLevenshteinMetric.compare("abc", "")(Options).get should be (30)
					WeightedLevenshteinMetric.compare("", "xyz")(Options).get should be (0.3)
					WeightedLevenshteinMetric.compare("123", "456")(Options).get should be (3)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					WeightedLevenshteinMetric.compare("az", "z")(Options).get should be (10)
					WeightedLevenshteinMetric.compare("z", "az")(Options).get should be (0.1)
					WeightedLevenshteinMetric.compare("a", "z")(Options).get should be (1)
					WeightedLevenshteinMetric.compare("z", "a")(Options).get should be (1)
					WeightedLevenshteinMetric.compare("ab", "yz")(Options).get should be (2)
					WeightedLevenshteinMetric.compare("yz", "ab")(Options).get should be (2)
					WeightedLevenshteinMetric.compare("0", "0123456789")(Options).get should be (0.9)
					WeightedLevenshteinMetric.compare("0123456789", "0")(Options).get should be (90)
					WeightedLevenshteinMetric.compare("book", "back")(Options).get should be (2)
					WeightedLevenshteinMetric.compare("back", "book")(Options).get should be (2)
					WeightedLevenshteinMetric.compare("hosp", "hospital")(Options).get should be (0.4)
					WeightedLevenshteinMetric.compare("hospital", "hosp")(Options).get should be (40)
					WeightedLevenshteinMetric.compare("clmbs blvd", "columbus boulevard")(Options).get should be (0.8)
					WeightedLevenshteinMetric.compare("columbus boulevard", "clmbs blvd")(Options).get should be (80)
				}
			}
		}
	}
}