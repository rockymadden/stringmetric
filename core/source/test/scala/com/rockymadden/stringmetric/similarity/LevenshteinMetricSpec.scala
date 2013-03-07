package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class LevenshteinMetricSpec extends ScalaTest {
	import LevenshteinMetricSpec.Metric

	"LevenshteinMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					Metric.compare("", "").isDefined should be (false)
					Metric.compare("abc", "").isDefined should be (false)
					Metric.compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"0" in {
					Metric.compare("abc", "abc").get should be (0)
					Metric.compare("123", "123").get should be (0)
				}
			}
			"unequal arguments" should returns {
				"Int indicating distance" in {
					Metric.compare("abc", "xyz").get should be (3)
					Metric.compare("123", "456").get should be (3)
				}
			}
			"valid arguments" should returns {
				"Int indicating distance" in {
					Metric.compare("abc", "a").get should be (2)
					Metric.compare("a", "abc").get should be (2)
					Metric.compare("abc", "c").get should be (2)
					Metric.compare("c", "abc").get should be (2)
					Metric.compare("sitting", "kitten").get should be (3)
					Metric.compare("kitten", "sitting").get should be (3)
					Metric.compare("cake", "drake").get should be (2)
					Metric.compare("drake", "cake").get should be (2)
					Metric.compare("saturday", "sunday").get should be (3)
					Metric.compare("sunday", "saturday").get should be (3)
					Metric.compare("book", "back").get should be (2)
					Metric.compare("dog", "fog").get should be (1)
					Metric.compare("foq", "fog").get should be (1)
					Metric.compare("fvg", "fog").get should be (1)
					Metric.compare("encyclopedia", "encyclopediaz").get should be (1)
					Metric.compare("encyclopediz", "encyclopediaz").get should be (1)
				}
			}
		}
	}
}

object LevenshteinMetricSpec {
	private final val Metric = LevenshteinMetric()
}
