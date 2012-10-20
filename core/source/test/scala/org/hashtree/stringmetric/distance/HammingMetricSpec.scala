package org.hashtree.stringmetric.distance

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class HammingMetricSpec extends ScalaTest {
	"HammingMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Int indicating distance" in {
					HammingMetric.compare("", "").isDefined should be (false)
					HammingMetric.compare("abc", "").isDefined should be (false)
					HammingMetric.compare("", "xyz").isDefined should be (false)

					HammingMetric.compare("abc", "abc").get should be (0)
					HammingMetric.compare("abc", "xyz").get should be (3)
					HammingMetric.compare("toned", "roses").get should be (3)
					HammingMetric.compare("1011101", "1001001").get should be (2)
					HammingMetric.compare("2173896", "2233796").get should be (3)
				}
			}
		}
	}
}