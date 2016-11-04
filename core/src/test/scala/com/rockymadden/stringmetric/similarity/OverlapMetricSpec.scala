package com.rockymadden.stringmetric.similarity

object OverlapMetricSpec extends org.specs2.mutable.Specification {
	"OverlapMetric compare()" should {
		"return None with empty arguments" in {
			OverlapMetric(1).compare("", "").isDefined must beFalse
			OverlapMetric(1).compare("abc", "").isDefined must beFalse
			OverlapMetric(1).compare("", "xyz").isDefined must beFalse
		}
		"return 1 with equal arguments" in {
			OverlapMetric(1).compare("abc", "abc").get must beEqualTo(1)
			OverlapMetric(2).compare("abc", "abc").get must beEqualTo(1)
			OverlapMetric(3).compare("abc", "abc").get must beEqualTo(1)
		}
		"return 0 with unequal arguments" in {
			OverlapMetric(1).compare("abc", "xyz").get must beEqualTo(0)
			OverlapMetric(2).compare("abc", "xyz").get must beEqualTo(0)
			OverlapMetric(3).compare("abc", "xyz").get must beEqualTo(0)
		}
		"return None with invalid arguments" in {
			OverlapMetric(2).compare("n", "naght").isDefined must beFalse
			OverlapMetric(2).compare("night", "n").isDefined must beFalse
			OverlapMetric(3).compare("ni", "naght").isDefined must beFalse
			OverlapMetric(3).compare("night", "na").isDefined must beFalse
		}
		"return distance with valid arguments" in {
			OverlapMetric(1).compare("bob", "bobman").get must beEqualTo(1)
			OverlapMetric(1).compare("bob", "manbobman").get must beEqualTo(1)
			OverlapMetric(1).compare("night", "nacht").get must beEqualTo(0.6)
			OverlapMetric(1).compare("night", "naght").get must beEqualTo(0.8)
			OverlapMetric(1).compare("context", "contact").get must beEqualTo(0.7142857142857143)

			OverlapMetric(2).compare("night", "nacht").get must beEqualTo(0.25)
			OverlapMetric(2).compare("night", "naght").get must beEqualTo(0.5)
			OverlapMetric(2).compare("context", "contact").get must beEqualTo(0.5)
			OverlapMetric(2).compare("contextcontext", "contact").get must beEqualTo(0.5)
			OverlapMetric(2).compare("context", "contactcontact").get must beEqualTo(0.5)
			OverlapMetric(2).compare("ht", "nacht").get must beEqualTo(1)
			OverlapMetric(2).compare("xp", "nacht").get must beEqualTo(0)
			OverlapMetric(2).compare("ht", "hththt").get must beEqualTo(1)

			OverlapMetric(3).compare("night", "nacht").get must beEqualTo(0)
			OverlapMetric(3).compare("night", "naght").get must beEqualTo(0.3333333333333333)
			OverlapMetric(3).compare("context", "contact").get must beEqualTo(0.4)
		}
	}
}
