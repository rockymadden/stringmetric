package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class LevenshteinMetricSpec extends ScalaTest {
	"LevenshteinMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					LevenshteinMetric.compare("", "").isDefined should be (false)
					LevenshteinMetric.compare("abc", "").isDefined should be (false)
					LevenshteinMetric.compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"0" in {
					LevenshteinMetric.compare("abc", "abc").get should be (0)
					LevenshteinMetric.compare("123", "123").get should be (0)
				}
			}
			"unequal arguments" should returns {
				"Int indicating distance" in {
					LevenshteinMetric.compare("abc", "xyz").get should be (3)
					LevenshteinMetric.compare("123", "456").get should be (3)
				}
			}
			"valid arguments" should returns {
				"Int indicating distance" in {
					LevenshteinMetric.compare("abc", "a").get should be (2)
					LevenshteinMetric.compare("a", "abc").get should be (2)
					LevenshteinMetric.compare("abc", "c").get should be (2)
					LevenshteinMetric.compare("c", "abc").get should be (2)
					LevenshteinMetric.compare("sitting", "kitten").get should be (3)
					LevenshteinMetric.compare("kitten", "sitting").get should be (3)
					LevenshteinMetric.compare("cake", "drake").get should be (2)
					LevenshteinMetric.compare("drake", "cake").get should be (2)
					LevenshteinMetric.compare("saturday", "sunday").get should be (3)
					LevenshteinMetric.compare("sunday", "saturday").get should be (3)
					LevenshteinMetric.compare("book", "back").get should be (2)
					LevenshteinMetric.compare("dog", "fog").get should be (1)
					LevenshteinMetric.compare("foq", "fog").get should be (1)
					LevenshteinMetric.compare("fvg", "fog").get should be (1)
					LevenshteinMetric.compare("encyclopedia", "encyclopediaz").get should be (1)
					LevenshteinMetric.compare("encyclopediz", "encyclopediaz").get should be (1)
				}
			}
		}
	}
}