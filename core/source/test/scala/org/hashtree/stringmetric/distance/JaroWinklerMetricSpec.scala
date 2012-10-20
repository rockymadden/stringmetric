package org.hashtree.stringmetric.distance

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaroWinklerMetricSpec extends ScalaTest {
	"JaroWinklerMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					JaroWinklerMetric.compare("", "").isDefined should be (false)
					JaroWinklerMetric.compare("abc", "").isDefined should be (false)
					JaroWinklerMetric.compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					JaroWinklerMetric.compare("a", "a").get should be (1.0f)
					JaroWinklerMetric.compare("abc", "abc").get should be (1.0f)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					JaroWinklerMetric.compare("abc", "xyz").get should be (0.0f)
				}
			}
			"valid arguments" should returns {
				"Float indicating distance" in {
					JaroWinklerMetric.compare("aa", "a").get should be (0.84999996f)
					JaroWinklerMetric.compare("a", "aa").get should be (0.84999996f)
					JaroWinklerMetric.compare("veryveryverylong", "v").get should be (0.71875f)
					JaroWinklerMetric.compare("v", "veryveryverylong").get should be (0.71875f)
					JaroWinklerMetric.compare("martha", "marhta").get should be (0.96111107f)
					JaroWinklerMetric.compare("dwayne", "duane").get should be (0.84000003f)
					JaroWinklerMetric.compare("dixon", "dicksonx").get should be (0.81333333f)
					JaroWinklerMetric.compare("abcvwxyz", "cabvwxyz").get should be (0.9583333f)
					JaroWinklerMetric.compare("jones", "johnson").get should be (0.8323809f)
					JaroWinklerMetric.compare("henka", "henkan").get should be (0.96666664f)
					JaroWinklerMetric.compare("fvie", "ten").get should be (0.0f)

					JaroWinklerMetric.compare("zac ephron", "zac efron").get should be >
						JaroWinklerMetric.compare("zac ephron", "kai ephron").get
					JaroWinklerMetric.compare("brittney spears", "britney spears").get should be >
						JaroWinklerMetric.compare("brittney spears", "brittney startzman").get
				}
			}
		}
	}
}