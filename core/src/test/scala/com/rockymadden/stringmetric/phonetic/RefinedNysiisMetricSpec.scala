package com.rockymadden.stringmetric.phonetic

object RefinedNysiisMetricSpec extends org.specs2.mutable.Specification {
	"RefinedNysiisMetric compare()" should {
		"return None with empty arguments" in {
			RefinedNysiisMetric.compare("", "").isDefined must beFalse
			RefinedNysiisMetric.compare("abc", "").isDefined must beFalse
			RefinedNysiisMetric.compare("", "xyz").isDefined must beFalse
		}
		"return None with non-phonetic arguments" in {
			RefinedNysiisMetric.compare("123", "123").isDefined must beFalse
			RefinedNysiisMetric.compare("123", "").isDefined must beFalse
			RefinedNysiisMetric.compare("", "123").isDefined must beFalse
		}
		"return true with phonetically similar arguments" in {
			RefinedNysiisMetric.compare("ham", "hum").get must beTrue
		}
		"return false with phonetically dissimilar arguments" in {
			RefinedNysiisMetric.compare("dumb", "gum").get must beFalse
		}
	}
}
