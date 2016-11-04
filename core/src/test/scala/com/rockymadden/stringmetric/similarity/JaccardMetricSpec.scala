package com.rockymadden.stringmetric.similarity

object JaccardMetricSpec extends org.specs2.mutable.Specification {
	"JaccardMetric compare()" should {
		"return None with empty arguments" in {
			JaccardMetric(1).compare("", "").isDefined must beFalse
			JaccardMetric(1).compare("abc", "").isDefined must beFalse
			JaccardMetric(1).compare("", "xyz").isDefined must beFalse
		}
		"return 1 with equal arguments" in {
			JaccardMetric(1).compare("abc", "abc").get must beEqualTo(1)
			JaccardMetric(2).compare("abc", "abc").get must beEqualTo(1)
			JaccardMetric(3).compare("abc", "abc").get must beEqualTo(1)
		}
		"return 0 with unequal arguments" in {
			JaccardMetric(1).compare("abc", "xyz").get must beEqualTo(0)
			JaccardMetric(2).compare("abc", "xyz").get must beEqualTo(0)
			JaccardMetric(3).compare("abc", "xyz").get must beEqualTo(0)
		}
		"return None with invalid arguments" in {
			JaccardMetric(2).compare("n", "naght").isDefined must beFalse
			JaccardMetric(2).compare("night", "n").isDefined must beFalse
			JaccardMetric(3).compare("ni", "naght").isDefined must beFalse
			JaccardMetric(3).compare("night", "na").isDefined must beFalse
		}
		"return distance with valid arguments" in {
			JaccardMetric(1).compare("night", "nacht").get must beEqualTo(0.42857142857142855)
			JaccardMetric(1).compare("night", "naght").get must beEqualTo(0.6666666666666666)
			JaccardMetric(1).compare("context", "contact").get must beEqualTo(0.5555555555555556)

			JaccardMetric(2).compare("night", "nacht").get must beEqualTo(0.14285714285714285)
			JaccardMetric(2).compare("night", "naght").get must beEqualTo(0.3333333333333333)
			JaccardMetric(2).compare("context", "contact").get must beEqualTo(0.3333333333333333)
			JaccardMetric(2).compare("contextcontext", "contact").get must beEqualTo(0.1875)
			JaccardMetric(2).compare("context", "contactcontact").get must beEqualTo(0.1875)
			JaccardMetric(2).compare("ht", "nacht").get must beEqualTo(0.25)
			JaccardMetric(2).compare("xp", "nacht").get must beEqualTo(0)
			JaccardMetric(2).compare("ht", "hththt").get must beEqualTo(0.2)

			JaccardMetric(3).compare("night", "nacht").get must beEqualTo(0)
			JaccardMetric(3).compare("night", "naght").get must beEqualTo(0.2)
			JaccardMetric(3).compare("context", "contact").get must beEqualTo(0.25)
		}
	}
}
