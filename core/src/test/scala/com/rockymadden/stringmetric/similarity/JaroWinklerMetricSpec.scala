package com.rockymadden.stringmetric.similarity

object JaroWinklerMetricSpec extends org.specs2.mutable.Specification {
	"JaroWinklerMetric compare()" should {
		"return None with empty arguments" in {
			JaroWinklerMetric.compare("", "").isDefined must beFalse
			JaroWinklerMetric.compare("abc", "").isDefined must beFalse
			JaroWinklerMetric.compare("", "xyz").isDefined must beFalse
		}
		"return 1 with equal arguments" in {
			JaroWinklerMetric.compare("a", "a").get must beEqualTo(1)
			JaroWinklerMetric.compare("abc", "abc").get must beEqualTo(1)
			JaroWinklerMetric.compare("123", "123").get must beEqualTo(1)
		}
		"return 0 with unequal arguments" in {
			JaroWinklerMetric.compare("abc", "xyz").get must beEqualTo(0)
			JaroWinklerMetric.compare("123", "456").get must beEqualTo(0)
		}
		"return distance with valid arguments" in {
			JaroWinklerMetric.compare("aa", "a").get must beEqualTo(0.8500000000000001)
			JaroWinklerMetric.compare("a", "aa").get must beEqualTo(0.8500000000000001)
			JaroWinklerMetric.compare("veryveryverylong", "v").get must beEqualTo(0.71875)
			JaroWinklerMetric.compare("v", "veryveryverylong").get must beEqualTo(0.71875)
			JaroWinklerMetric.compare("martha", "marhta").get must beEqualTo(0.9611111111111111)
			JaroWinklerMetric.compare("dwayne", "duane").get must beEqualTo(0.8400000000000001)
			JaroWinklerMetric.compare("dixon", "dicksonx").get must beEqualTo(0.8133333333333332)
			JaroWinklerMetric.compare("abcvwxyz", "cabvwxyz").get must beEqualTo(0.9583333333333334)
			JaroWinklerMetric.compare("jones", "johnson").get must beEqualTo(0.8323809523809523)
			JaroWinklerMetric.compare("henka", "henkan").get must beEqualTo(0.9666666666666667)
			JaroWinklerMetric.compare("fvie", "ten").get must beEqualTo(0)

			JaroWinklerMetric.compare("zac ephron", "zac efron").get must
				beGreaterThan(JaroWinklerMetric.compare("zac ephron", "kai ephron").get)
			JaroWinklerMetric.compare("brittney spears", "britney spears").get must
				beGreaterThan(JaroWinklerMetric.compare("brittney spears", "brittney startzman").get)
		}
	}
}
