package com.rockymadden.stringmetric.similarity

object RatcliffObershelpMetricSpec extends org.specs2.mutable.Specification {
	"RatcliffObershelpMetric compare()" should {
		"return None with empty arguments" in {
			RatcliffObershelpMetric.compare("", "").isDefined must beFalse
			RatcliffObershelpMetric.compare("abc", "").isDefined must beFalse
			RatcliffObershelpMetric.compare("", "xyz").isDefined must beFalse
		}
		"return 0 with equal arguments" in {
			RatcliffObershelpMetric.compare("abc", "abc").get must beEqualTo(1)
			RatcliffObershelpMetric.compare("123", "123").get must beEqualTo(1)
		}
		"return distance with unequal arguments" in {
			RatcliffObershelpMetric.compare("abc", "xyz").get must beEqualTo(0)
			RatcliffObershelpMetric.compare("123", "456").get must beEqualTo(0)
		}
		"return distance with valid arguments" in {
			RatcliffObershelpMetric.compare("aleksander", "alexandre").get must beEqualTo(0.7368421052631579)
			RatcliffObershelpMetric.compare("alexandre", "aleksander").get must beEqualTo(0.7368421052631579)
			RatcliffObershelpMetric.compare("pennsylvania", "pencilvaneya").get must beEqualTo(0.6666666666666666)
			RatcliffObershelpMetric.compare("pencilvaneya", "pennsylvania").get must beEqualTo(0.6666666666666666)
			RatcliffObershelpMetric.compare("abcefglmn", "abefglmo").get must beEqualTo(0.8235294117647058)
			RatcliffObershelpMetric.compare("abefglmo", "abcefglmn").get must beEqualTo(0.8235294117647058)
		}
	}
}
