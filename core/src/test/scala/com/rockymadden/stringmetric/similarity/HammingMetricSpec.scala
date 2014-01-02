package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class HammingMetricSpec extends ScalaTest { "HammingMetric" should provide {
	"compare method" when passed {
		"empty arguments" should returns {
			"None" in {
				HammingMetric.compare("", "").isDefined should be (false)
				HammingMetric.compare("abc", "").isDefined should be (false)
				HammingMetric.compare("", "xyz").isDefined should be (false)
			}
		}
		"equal arguments" should returns {
			"0" in {
				HammingMetric.compare("abc", "abc").get should be (0)
				HammingMetric.compare("123", "123").get should be (0)
			}
		}
		"unequal arguments" should returns {
			"Int indicating distance" in {
				HammingMetric.compare("abc", "xyz").get should be (3)
				HammingMetric.compare("123", "456").get should be (3)
			}
		}
		"valid arguments" should returns {
			"Int indicating distance" in {
				HammingMetric.compare("toned", "roses").get should be (3)
				HammingMetric.compare("1011101", "1001001").get should be (2)
				HammingMetric.compare("2173896", "2233796").get should be (3)
			}
		}
	}
}}
