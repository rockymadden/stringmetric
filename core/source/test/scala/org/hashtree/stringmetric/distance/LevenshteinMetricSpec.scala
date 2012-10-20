package org.hashtree.stringmetric.distance

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class LevenshteinMetricSpec extends ScalaTest {
	"LevenshteinMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					LevenshteinMetric.compare("", "").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"0" in {
					LevenshteinMetric.compare("abc", "abc").get should be (0)
				}
			}
			"unequal arguments" should returns {
				"Int indicating distance" in {
					LevenshteinMetric.compare("abc", "").get should be (3)
					LevenshteinMetric.compare("", "xyz").get should be (3)
					LevenshteinMetric.compare("abc", "xyz").get should be (3)
				}
			}
			"valid arguments" should returns {
				"Int indicating distance" in {
					LevenshteinMetric.compare("abc", "a").get should be (2)
					LevenshteinMetric.compare("a", "abc").get should be (2)
					LevenshteinMetric.compare("abc", "c").get should be (2)
					LevenshteinMetric.compare("c", "abc").get should be (2)
					LevenshteinMetric.compare("kitten", "sitting").get should be (3)
					LevenshteinMetric.compare("drake", "cake").get should be (2)
				}
			}
		}
	}
}