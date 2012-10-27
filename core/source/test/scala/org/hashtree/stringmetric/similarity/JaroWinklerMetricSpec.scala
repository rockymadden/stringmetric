package org.hashtree.stringmetric.similarity

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
					JaroWinklerMetric.compare("a", "a").get should be (1)
					JaroWinklerMetric.compare("abc", "abc").get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					JaroWinklerMetric.compare("abc", "xyz").get should be (0)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					JaroWinklerMetric.compare("aa", "a").get should be (0.8500000000000001)
					JaroWinklerMetric.compare("a", "aa").get should be (0.8500000000000001)
					JaroWinklerMetric.compare("veryveryverylong", "v").get should be (0.71875)
					JaroWinklerMetric.compare("v", "veryveryverylong").get should be (0.71875)
					JaroWinklerMetric.compare("martha", "marhta").get should be (0.9611111111111111)
					JaroWinklerMetric.compare("dwayne", "duane").get should be (0.8400000000000001)
					JaroWinklerMetric.compare("dixon", "dicksonx").get should be (0.8133333333333332)
					JaroWinklerMetric.compare("abcvwxyz", "cabvwxyz").get should be (0.9583333333333334)
					JaroWinklerMetric.compare("jones", "johnson").get should be (0.8323809523809523)
					JaroWinklerMetric.compare("henka", "henkan").get should be (0.9666666666666667)
					JaroWinklerMetric.compare("fvie", "ten").get should be (0)

					JaroWinklerMetric.compare("zac ephron", "zac efron").get should be >
						JaroWinklerMetric.compare("zac ephron", "kai ephron").get
					JaroWinklerMetric.compare("brittney spears", "britney spears").get should be >
						JaroWinklerMetric.compare("brittney spears", "brittney startzman").get
				}
			}
		}
	}
}