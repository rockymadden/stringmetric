package com.rockymadden.stringmetric.phonetic

object NysiisMetricSpec extends org.specs2.mutable.Specification {
	"NysiisMetric compare()" should {
		"return None with empty arguments" in {
			NysiisMetric.compare("", "").isDefined must beFalse
			NysiisMetric.compare("abc", "").isDefined must beFalse
			NysiisMetric.compare("", "xyz").isDefined must beFalse
		}
		"return None with non-phonetic arguments" in {
			NysiisMetric.compare("123", "123").isDefined must beFalse
			NysiisMetric.compare("123", "").isDefined must beFalse
			NysiisMetric.compare("", "123").isDefined must beFalse
		}
		"return true with phonetically similar arguments" in {
			NysiisMetric.compare("ham", "hum").get must beTrue
		}
		"return false with phonetically dissimilar arguments" in {
			NysiisMetric.compare("dumb", "gum").get must beFalse
		}
	}
}
