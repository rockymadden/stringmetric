package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RatcliffObershelpMetricSpec extends ScalaTest { "RatcliffObershelpMetric" should provide {
	"compare method" when passed {
		"empty arguments" should returns {
			"None" in {
				RatcliffObershelpMetric.compare("", "").isDefined should be (false)
				RatcliffObershelpMetric.compare("abc", "").isDefined should be (false)
				RatcliffObershelpMetric.compare("", "xyz").isDefined should be (false)
			}
		}
		"equal arguments" should returns {
			"0" in {
				RatcliffObershelpMetric.compare("abc", "abc").get should be (1)
				RatcliffObershelpMetric.compare("123", "123").get should be (1)
			}
		}
		"unequal arguments" should returns {
			"Double indicating distance" in {
				RatcliffObershelpMetric.compare("abc", "xyz").get should be (0)
				RatcliffObershelpMetric.compare("123", "456").get should be (0)
			}
		}
		"valid arguments" should returns {
			"Double indicating distance" in {
				RatcliffObershelpMetric.compare("aleksander", "alexandre").get should be (0.7368421052631579)
				RatcliffObershelpMetric.compare("alexandre", "aleksander").get should be (0.7368421052631579)
				RatcliffObershelpMetric.compare("pennsylvania", "pencilvaneya").get should be (0.6666666666666666)
				RatcliffObershelpMetric.compare("pencilvaneya", "pennsylvania").get should be (0.6666666666666666)
				RatcliffObershelpMetric.compare("abcefglmn", "abefglmo").get should be (0.8235294117647058)
				RatcliffObershelpMetric.compare("abefglmo", "abcefglmn").get should be (0.8235294117647058)
			}
		}
	}
}}
