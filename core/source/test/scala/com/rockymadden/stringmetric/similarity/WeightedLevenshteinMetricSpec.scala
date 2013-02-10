package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class WeightedLevenshteinMetricSpec extends ScalaTest {
	import WeightedLevenshteinMetricSpec._

	"WeightedLevenshteinMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					Metric.compare("", "")(Options).isDefined should be (false)
					Metric.compare("abc", "")(Options).isDefined should be (false)
					Metric.compare("", "xyz")(Options).isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"0" in {
					Metric.compare("abc", "abc")(Options).get should be (0)
					Metric.compare("123", "123")(Options).get should be (0)
				}
			}
			"unequal arguments" should returns {
				"Double indicating distance" in {
					Metric.compare("abc", "xyz")(Options).get should be (3)
					Metric.compare("123", "456")(Options).get should be (3)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					Metric.compare("az", "z")(Options).get should be (10)
					Metric.compare("z", "az")(Options).get should be (0.1)
					Metric.compare("a", "z")(Options).get should be (1)
					Metric.compare("z", "a")(Options).get should be (1)
					Metric.compare("ab", "yz")(Options).get should be (2)
					Metric.compare("yz", "ab")(Options).get should be (2)
					Metric.compare("0", "0123456789")(Options).get should be (0.9)
					Metric.compare("0123456789", "0")(Options).get should be (90)
					Metric.compare("book", "back")(Options).get should be (2)
					Metric.compare("back", "book")(Options).get should be (2)
					Metric.compare("hosp", "hospital")(Options).get should be (0.4)
					Metric.compare("hospital", "hosp")(Options).get should be (40)
					Metric.compare("clmbs blvd", "columbus boulevard")(Options).get should be (0.8)
					Metric.compare("columbus boulevard", "clmbs blvd")(Options).get should be (80)
				}
			}
		}
	}
}

object WeightedLevenshteinMetricSpec {
	private final val Options = Tuple3[BigDecimal, BigDecimal, BigDecimal](10, 0.1, 1)
	private final val Metric = new WeightedLevenshteinMetric
}
