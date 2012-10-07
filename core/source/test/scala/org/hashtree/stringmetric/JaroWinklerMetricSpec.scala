package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaroWinklerMetricSpec extends ScalaTest {
	"JaroWinklerMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Float indicating distance" in {
					JaroWinklerMetric.compare("abc", "abc") should be (1.0f)
					JaroWinklerMetric.compare("abc", "xyz") should be (0.0f)
					JaroWinklerMetric.compare("abc", "") should be (0.0f)
					JaroWinklerMetric.compare("", "xyz") should be (0.0f)
					JaroWinklerMetric.compare("", "") should be (0.0f)
					JaroWinklerMetric.compare("a", "a") should be (1.0f)

					JaroWinklerMetric.compare("aa", "a") should be (0.84999996f)
					JaroWinklerMetric.compare("a", "aa") should be (0.84999996f)

					JaroWinklerMetric.compare("veryveryverylong", "v") should be (0.71875f)
					JaroWinklerMetric.compare("v", "veryveryverylong") should be (0.71875f)

					JaroWinklerMetric.compare("martha", "marhta") should be (0.96111107f)
					JaroWinklerMetric.compare("dwayne", "duane") should be (0.84000003f)
					JaroWinklerMetric.compare("dixon", "dicksonx") should be (0.81333333f)
					JaroWinklerMetric.compare("abcvwxyz", "cabvwxyz") should be (0.9583333f)
					JaroWinklerMetric.compare("jones", "johnson") should be (0.8323809f)
					JaroWinklerMetric.compare("henka", "henkan") should be (0.96666664f)
					JaroWinklerMetric.compare("fvie", "ten") should be (0.0f)

					JaroWinklerMetric.compare("zac ephron", "zac efron") should be >
						JaroWinklerMetric.compare("zac ephron", "kai ephron")
					JaroWinklerMetric.compare("brittney spears", "britney spears") should be >
						JaroWinklerMetric.compare("brittney spears", "brittney startzman")

					JaroWinklerMetric.compare("m a r t h a", "m a r h t a") should be (0.96111107f)
					JaroWinklerMetric.compare("d w a y n e", "d u a n e") should be (0.84000003f)
					JaroWinklerMetric.compare("d i x o n", "d i c k s o n x") should be (0.81333333f)
					JaroWinklerMetric.compare("a b c v w x y z", "c a b v w x y z") should be (0.9583333f)
					JaroWinklerMetric.compare("j o n e s", "j o h n s o n") should be (0.8323809f)
					JaroWinklerMetric.compare("h e n k a", "h e n k a n") should be (0.96666664f)
					JaroWinklerMetric.compare("f v i e", "t e n") should be (0.0f)

					JaroWinklerMetric.compare("z a c e p h r o n", "z a c e f r o n") should be >
						JaroWinklerMetric.compare("z a c e p h r o n", "k a i e p h r o n")
					JaroWinklerMetric.compare("b r i t t n e y s p e a r s", "b r i t n e y s p e a r s") should be >
						JaroWinklerMetric.compare("b r i t t n e y s p e a r s", "b r i t t n e y s t a r t z m a n")
				}
			}
		}
	}
}