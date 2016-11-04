package com.rockymadden.stringmetric.phonetic

object SoundexMetricSpec extends org.specs2.mutable.Specification {
	"SoundexMetric compare()" should {
		"return None with empty arguments" in {
			SoundexMetric.compare("", "").isDefined must beFalse
			SoundexMetric.compare("abc", "").isDefined must beFalse
			SoundexMetric.compare("", "xyz").isDefined must beFalse
		}
		"return None with non-phonetic arguments" in {
			SoundexMetric.compare("123", "123").isDefined must beFalse
			SoundexMetric.compare("123", "").isDefined must beFalse
			SoundexMetric.compare("", "123").isDefined must beFalse
		}
		"return true with phonetically similar arguments" in {
			SoundexMetric.compare("robert", "rupert").get must beTrue
		}
		"return false with phonetically dissimilar arguments" in {
			SoundexMetric.compare("robert", "rubin").get must beFalse
		}
	}
}
