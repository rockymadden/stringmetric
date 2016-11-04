package com.rockymadden.stringmetric.phonetic

object RefinedSoundexMetricSpec extends org.specs2.mutable.Specification {
	"RefinedSoundexMetric compare()" should {
		"return None with empty arguments" in {
			RefinedSoundexMetric.compare("", "").isDefined must beFalse
			RefinedSoundexMetric.compare("abc", "").isDefined must beFalse
			RefinedSoundexMetric.compare("", "xyz").isDefined must beFalse
		}
		"return None with non-phonetic arguments" in {
			RefinedSoundexMetric.compare("123", "123").isDefined must beFalse
			RefinedSoundexMetric.compare("123", "").isDefined must beFalse
			RefinedSoundexMetric.compare("", "123").isDefined must beFalse
		}
		"return true with phonetically similar arguments" in {
			RefinedSoundexMetric.compare("robert", "rupert").get must beTrue
		}
		"return false with phonetically dissimilar arguments" in {
			RefinedSoundexMetric.compare("robert", "rubin").get must beFalse
		}
	}
}
