package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RatcliffObershelpMetricSpec extends ScalaTest {
	import RatcliffObershelpMetricSpec.Metric

	"RatcliffObershelpMetric" should provide {
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
					Metric.compare("abc", "abc").get should be (1)
					Metric.compare("123", "123").get should be (1)
				}
			}
			"unequal arguments" should returns {
				"Double indicating distance" in {
					Metric.compare("abc", "xyz").get should be (0)
					Metric.compare("123", "456").get should be (0)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					Metric.compare("aleksander", "alexandre").get should be (0.7368421052631579)
					Metric.compare("alexandre", "aleksander").get should be (0.7368421052631579)
					Metric.compare("pennsylvania", "pencilvaneya").get should be (0.6666666666666666)
					Metric.compare("pencilvaneya", "pennsylvania").get should be (0.6666666666666666)
					Metric.compare("abcefglmn", "abefglmo").get should be (0.8235294117647058)
					Metric.compare("abefglmo", "abcefglmn").get should be (0.8235294117647058)
				}
			}
		}
	}
}

object RatcliffObershelpMetricSpec {
	private final val Metric = RatcliffObershelpMetric()
}

