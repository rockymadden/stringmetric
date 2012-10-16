package org.hashtree.stringmetric

import org.hashtree.stringmetric.LevenshteinMetric.stringCleaner
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class LevenshteinMetricSpec extends ScalaTest {
	"LevenshteinMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Int indicating distance" in {
					LevenshteinMetric.compare("", "").isDefined should be (false)

					LevenshteinMetric.compare("abc", "").get should be (3)
					LevenshteinMetric.compare("", "xyz").get should be (3)
					LevenshteinMetric.compare("abc", "abc").get should be (0)
					LevenshteinMetric.compare("abc", "xyz").get should be (3)
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