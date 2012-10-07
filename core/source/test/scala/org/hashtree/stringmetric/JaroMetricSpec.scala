package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaroMetricSpec extends ScalaTest {
	"JaroMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Float indicating distance" in {
					JaroMetric.compare("abc", "abc") should be (1.0f)
					JaroMetric.compare("abc", "xyz") should be (0.0f)
					JaroMetric.compare("abc", "") should be (0.0f)
					JaroMetric.compare("", "xyz") should be (0.0f)
					JaroMetric.compare("", "") should be (0.0f)
					JaroMetric.compare("a", "a") should be (1.0f)

					JaroMetric.compare("aa", "a") should be (0.8333333f)
					JaroMetric.compare("a", "aa") should be (0.8333333f)

					JaroMetric.compare("veryveryverylong", "v") should be (0.6875f)
					JaroMetric.compare("v", "veryveryverylong") should be (0.6875f)

					JaroMetric.compare("martha", "marhta") should be (0.9444444f)
					JaroMetric.compare("dwayne", "duane") should be (0.82222223f)
					JaroMetric.compare("dixon", "dicksonx") should be (0.76666665f)
					JaroMetric.compare("abcvwxyz", "cabvwxyz") should be (0.9583333f)
					JaroMetric.compare("jones", "johnson") should be (0.79047614f)
					JaroMetric.compare("henka", "henkan") should be (0.9444444f)
					JaroMetric.compare("fvie", "ten") should be (0.0f)

					JaroMetric.compare("zac ephron", "zac efron") should be >
						JaroMetric.compare("zac ephron", "kai ephron")
					JaroMetric.compare("brittney spears", "britney spears") should be >
						JaroMetric.compare("brittney spears", "brittney startzman")

					JaroMetric.compare("m a r t h a", "m a r h t a") should be (0.9444444f)
					JaroMetric.compare("d w a y n e", "d u a n e") should be (0.82222223f)
					JaroMetric.compare("d i x o n", "d i c k s o n x") should be (0.76666665f)
					JaroMetric.compare("a b c v w x y z", "c a b v w x y z") should be (0.9583333f)
					JaroMetric.compare("j o n e s", "j o h n s o n") should be (0.79047614f)
					JaroMetric.compare("h e n k a", "h e n k a n") should be (0.9444444f)
					JaroMetric.compare("f v i e", "t e n") should be (0.0f)

					JaroMetric.compare("z a c e p h r o n", "z a c e f r o n") should be >
						JaroMetric.compare("z a c e p h r o n", "k a i e p h r o n")
					JaroMetric.compare("b r i t t n e y s p e a r s", "b r i t n e y s p e a r s") should be >
						JaroMetric.compare("b r i t t n e y s p e a r s", "b r i t t n e y s t a r t z m a n")
				}
			}
		}
	}
}