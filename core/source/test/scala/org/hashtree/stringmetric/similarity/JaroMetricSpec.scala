package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaroMetricSpec extends ScalaTest {
	"JaroMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					JaroMetric.compare("", "").isDefined should be (false)
					JaroMetric.compare("abc", "").isDefined should be (false)
					JaroMetric.compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					JaroMetric.compare("a", "a").get should be (1)
					JaroMetric.compare("abc", "abc").get should be (1)
					JaroMetric.compare("123", "123").get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					JaroMetric.compare("abc", "xyz").get should be (0)
					JaroMetric.compare("123", "456").get should be (0)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					JaroMetric.compare("aa", "a").get should be (0.8333333333333334)
					JaroMetric.compare("a", "aa").get should be (0.8333333333333334)
					JaroMetric.compare("veryveryverylong", "v").get should be (0.6875)
					JaroMetric.compare("v", "veryveryverylong").get should be (0.6875)
					JaroMetric.compare("martha", "marhta").get should be (0.9444444444444445)
					JaroMetric.compare("dwayne", "duane").get should be (0.8222222222222223)
					JaroMetric.compare("dixon", "dicksonx").get should be (0.7666666666666666)
					JaroMetric.compare("abcvwxyz", "cabvwxyz").get should be (0.9583333333333334)
					JaroMetric.compare("jones", "johnson").get should be (0.7904761904761904)
					JaroMetric.compare("henka", "henkan").get should be (0.9444444444444445)
					JaroMetric.compare("fvie", "ten").get should be (0)

					JaroMetric.compare("zac ephron", "zac efron").get should be >
						JaroMetric.compare("zac ephron", "kai ephron").get
					JaroMetric.compare("brittney spears", "britney spears").get should be >
						JaroMetric.compare("brittney spears", "brittney startzman").get
				}
			}
		}
	}
}