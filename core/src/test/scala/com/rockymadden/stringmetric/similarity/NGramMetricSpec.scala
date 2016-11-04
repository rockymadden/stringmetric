package com.rockymadden.stringmetric.similarity

object NGramMetricSpec extends org.specs2.mutable.Specification {
	"NGramMetric compare()" should {
		"return None with empty arguments" in {
			NGramMetric(1).compare("", "").isDefined must beFalse
			NGramMetric(1).compare("abc", "").isDefined must beFalse
			NGramMetric(1).compare("", "xyz").isDefined must beFalse
		}
		"return 1 with equal arguments" in {
			NGramMetric(1).compare("abc", "abc").get must beEqualTo(1)
			NGramMetric(2).compare("abc", "abc").get must beEqualTo(1)
			NGramMetric(3).compare("abc", "abc").get must beEqualTo(1)
		}
		"return 0 with unequal arguments" in {
			NGramMetric(1).compare("abc", "xyz").get must beEqualTo(0)
			NGramMetric(2).compare("abc", "xyz").get must beEqualTo(0)
			NGramMetric(3).compare("abc", "xyz").get must beEqualTo(0)
		}
		"return None with invalid arguments" in {
			NGramMetric(2).compare("n", "naght").isDefined must beFalse
			NGramMetric(2).compare("night", "n").isDefined must beFalse
			NGramMetric(3).compare("ni", "naght").isDefined must beFalse
			NGramMetric(3).compare("night", "na").isDefined must beFalse
		}
		"return distance with valid arguments" in {
			NGramMetric(1).compare("night", "nacht").get must beEqualTo(0.6)
			NGramMetric(1).compare("night", "naght").get must beEqualTo(0.8)
			NGramMetric(1).compare("context", "contact").get must beEqualTo(0.7142857142857143)

			NGramMetric(2).compare("night", "nacht").get must beEqualTo(0.25)
			NGramMetric(2).compare("night", "naght").get must beEqualTo(0.5)
			NGramMetric(2).compare("context", "contact").get must beEqualTo(0.5)
			NGramMetric(2).compare("contextcontext", "contact").get must beEqualTo(0.23076923076923078)
			NGramMetric(2).compare("context", "contactcontact").get must beEqualTo(0.23076923076923078)
			NGramMetric(2).compare("ht", "nacht").get must beEqualTo(0.25)
			NGramMetric(2).compare("xp", "nacht").get must beEqualTo(0)
			NGramMetric(2).compare("ht", "hththt").get must beEqualTo(0.2)

			NGramMetric(3).compare("night", "nacht").get must beEqualTo(0)
			NGramMetric(3).compare("night", "naght").get must beEqualTo(0.3333333333333333)
			NGramMetric(3).compare("context", "contact").get must beEqualTo(0.4)
		}
	}
}
