package com.rockymadden.stringmetric.similarity

object DiceSorensenMetricSpec extends org.specs2.mutable.Specification {
	"DiceSorensenMetric compare()" should {
		"return None with empty arguments" in {
			DiceSorensenMetric(1).compare("", "").isDefined must beFalse
			DiceSorensenMetric(1).compare("abc", "").isDefined must beFalse
			DiceSorensenMetric(1).compare("", "xyz").isDefined must beFalse
		}
		"return 1 with equal arguments" in {
			DiceSorensenMetric(1).compare("abc", "abc").get must beEqualTo(1)
			DiceSorensenMetric(2).compare("abc", "abc").get must beEqualTo(1)
			DiceSorensenMetric(2).compare("abc", "abc").get must beEqualTo(1)
		}
		"return 0 with unequal arguments" in {
			DiceSorensenMetric(1).compare("abc", "xyz").get must beEqualTo(0)
			DiceSorensenMetric(2).compare("abc", "xyz").get must beEqualTo(0)
			DiceSorensenMetric(3).compare("abc", "xyz").get must beEqualTo(0)
		}
		"return None with invalid arguments" in {
			DiceSorensenMetric(2).compare("n", "naght").isDefined must beFalse
			DiceSorensenMetric(2).compare("night", "n").isDefined must beFalse
			DiceSorensenMetric(3).compare("ni", "naght").isDefined must beFalse
			DiceSorensenMetric(3).compare("night", "na").isDefined must beFalse
		}
		"return distance with valid arguments" in {
			DiceSorensenMetric(1).compare("night", "nacht").get must beEqualTo(0.6)
			DiceSorensenMetric(1).compare("night", "naght").get must beEqualTo(0.8)
			DiceSorensenMetric(1).compare("context", "contact").get must beEqualTo(0.7142857142857143)

			DiceSorensenMetric(2).compare("night", "nacht").get must beEqualTo(0.25)
			DiceSorensenMetric(2).compare("night", "naght").get must beEqualTo(0.5)
			DiceSorensenMetric(2).compare("context", "contact").get must beEqualTo(0.5)
			DiceSorensenMetric(2).compare("contextcontext", "contact").get must beEqualTo(0.3157894736842105)
			DiceSorensenMetric(2).compare("context", "contactcontact").get must beEqualTo(0.3157894736842105)
			DiceSorensenMetric(2).compare("ht", "nacht").get must beEqualTo(0.4)
			DiceSorensenMetric(2).compare("xp", "nacht").get must beEqualTo(0)
			DiceSorensenMetric(2).compare("ht", "hththt").get must beEqualTo(0.3333333333333333)

			DiceSorensenMetric(3).compare("night", "nacht").get must beEqualTo(0)
			DiceSorensenMetric(3).compare("night", "naght").get must beEqualTo(0.3333333333333333)
			DiceSorensenMetric(3).compare("context", "contact").get must beEqualTo(0.4)
		}
	}
}
