package com.rockymadden.stringmetric.similarity

object HammingMetricSpec extends org.specs2.mutable.Specification {
	"HammingMetric compare()" should {
		"return None with empty arguments" in {
			HammingMetric.compare("", "").isDefined must beFalse
			HammingMetric.compare("abc", "").isDefined must beFalse
			HammingMetric.compare("", "xyz").isDefined must beFalse
		}
		"return 0 with equal arguments" in {
			HammingMetric.compare("abc", "abc").get must beEqualTo(0)
			HammingMetric.compare("123", "123").get must beEqualTo(0)
		}
		"return distance with unequal arguments" in {
			HammingMetric.compare("abc", "xyz").get must beEqualTo(3)
			HammingMetric.compare("123", "456").get must beEqualTo(3)
		}
		"return distance with valid arguments" in {
			HammingMetric.compare("toned", "roses").get must beEqualTo(3)
			HammingMetric.compare("1011101", "1001001").get must beEqualTo(2)
			HammingMetric.compare("2173896", "2233796").get must beEqualTo(3)
		}
	}
}
