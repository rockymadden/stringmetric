package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class HammingMetricSpec extends ScalaTest {
	import HammingMetricSpec.Metric

	"HammingMetric" should provide {
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
					Metric.compare("toned", "roses").get should be (3)
					Metric.compare("1011101", "1001001").get should be (2)
					Metric.compare("2173896", "2233796").get should be (3)
				}
			}
		}
	}
	"HammingMetric companion object" should provide {
		"pass-through compare method" should returns {
			"same value as class" in {
				HammingMetric.compare("2173896", "2233796").get should be (3)
			}
		}
	}
}

object HammingMetricSpec {
	private final val Metric = HammingMetric()
}
