package com.rockymadden.stringmetric.similarity

object JaroMetricSpec extends org.specs2.mutable.Specification {
	"JaroMetric compare()" should {
		"return None with empty arguments" in {
			JaroMetric.compare("", "").isDefined should beFalse
			JaroMetric.compare("abc", "").isDefined should beFalse
			JaroMetric.compare("", "xyz").isDefined should beFalse
		}
		"return 1 with equal arguments" in {
			JaroMetric.compare("a", "a").get must beEqualTo(1)
			JaroMetric.compare("abc", "abc").get must beEqualTo(1)
			JaroMetric.compare("123", "123").get must beEqualTo(1)
		}
		"return with 0 with unequal arguments" in {
			JaroMetric.compare("abc", "xyz").get must beEqualTo(0)
			JaroMetric.compare("123", "456").get must beEqualTo(0)
		}
		"return distance with valid arguments" in {
			JaroMetric.compare("aa", "a").get must beEqualTo(0.8333333333333334)
			JaroMetric.compare("a", "aa").get must beEqualTo(0.8333333333333334)
			JaroMetric.compare("veryveryverylong", "v").get must beEqualTo(0.6875)
			JaroMetric.compare("v", "veryveryverylong").get must beEqualTo(0.6875)
			JaroMetric.compare("martha", "marhta").get must beEqualTo(0.9444444444444445)
			JaroMetric.compare("dwayne", "duane").get must beEqualTo(0.8222222222222223)
			JaroMetric.compare("dixon", "dicksonx").get must beEqualTo(0.7666666666666666)
			JaroMetric.compare("abcvwxyz", "cabvwxyz").get must beEqualTo(0.9583333333333334)
			JaroMetric.compare("jones", "johnson").get must beEqualTo(0.7904761904761904)
			JaroMetric.compare("henka", "henkan").get must beEqualTo(0.9444444444444445)
			JaroMetric.compare("fvie", "ten").get must beEqualTo(0)

			JaroMetric.compare("zac ephron", "zac efron").get must
				beGreaterThan(JaroMetric.compare("zac ephron", "kai ephron").get)
			JaroMetric.compare("brittney spears", "britney spears").get must
				beGreaterThan(JaroMetric.compare("brittney spears", "brittney startzman").get)
		}
	}
}
