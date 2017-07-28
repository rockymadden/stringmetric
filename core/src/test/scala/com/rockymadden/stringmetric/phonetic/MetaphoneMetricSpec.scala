package com.rockymadden.stringmetric.phonetic

object MetaphoneMetricSpec extends org.specs2.mutable.Specification {
	"MetaphoneMetric compare()" should {
		"return None with empty arguments" in {
			MetaphoneMetric.compare("", "").isDefined must beFalse
			MetaphoneMetric.compare("abc", "").isDefined must beFalse
			MetaphoneMetric.compare("", "xyz").isDefined must beFalse
		}
		"return None with non-phonetic arguments" in {
			"None" in {
			MetaphoneMetric.compare("123", "123").isDefined must beFalse
			MetaphoneMetric.compare("123", "").isDefined must beFalse
			MetaphoneMetric.compare("", "123").isDefined must beFalse
			}
		}
		"return true with phonetically similar arguments" in {
			MetaphoneMetric.compare("dumb", "dum").get must beTrue
			MetaphoneMetric.compare("smith", "smeth").get must beTrue
			MetaphoneMetric.compare("merci", "mercy").get must beTrue
		}
		"return false with phonetically dissimilar arguments" in {
			MetaphoneMetric.compare("dumb", "gum").get must beFalse
			MetaphoneMetric.compare("smith", "kiss").get must beFalse
			MetaphoneMetric.compare("merci", "burpy").get must beFalse
		}
	}
}
