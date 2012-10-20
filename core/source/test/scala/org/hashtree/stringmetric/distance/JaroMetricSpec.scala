package org.hashtree.stringmetric.distance

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
					JaroMetric.compare("a", "a").get should be (1.0f)
					JaroMetric.compare("abc", "abc").get should be (1.0f)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					JaroMetric.compare("abc", "xyz").get should be (0.0f)
				}
			}
			"valid arguments" should returns {
				"Float indicating distance" in {
					JaroMetric.compare("aa", "a").get should be (0.8333333f)
					JaroMetric.compare("a", "aa").get should be (0.8333333f)
					JaroMetric.compare("veryveryverylong", "v").get should be (0.6875f)
					JaroMetric.compare("v", "veryveryverylong").get should be (0.6875f)
					JaroMetric.compare("martha", "marhta").get should be (0.9444444f)
					JaroMetric.compare("dwayne", "duane").get should be (0.82222223f)
					JaroMetric.compare("dixon", "dicksonx").get should be (0.76666665f)
					JaroMetric.compare("abcvwxyz", "cabvwxyz").get should be (0.9583333f)
					JaroMetric.compare("jones", "johnson").get should be (0.79047614f)
					JaroMetric.compare("henka", "henkan").get should be (0.9444444f)
					JaroMetric.compare("fvie", "ten").get should be (0.0f)

					JaroMetric.compare("zac ephron", "zac efron").get should be >
						JaroMetric.compare("zac ephron", "kai ephron").get
					JaroMetric.compare("brittney spears", "britney spears").get should be >
						JaroMetric.compare("brittney spears", "brittney startzman").get
				}
			}
		}
	}
}