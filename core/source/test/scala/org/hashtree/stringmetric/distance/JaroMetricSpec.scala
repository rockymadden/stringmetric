package org.hashtree.stringmetric.distance

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaroMetricSpec extends ScalaTest {
	"JaroMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Float indicating distance" in {
					JaroMetric.compare("abc", "abc").get should be (1.0f)
					JaroMetric.compare("abc", "xyz").get should be (0.0f)
					JaroMetric.compare("abc", "").isDefined should be (false)
					JaroMetric.compare("", "xyz").isDefined should be (false)
					JaroMetric.compare("", "").isDefined should be (false)
					JaroMetric.compare("a", "a").get should be (1.0f)

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

					JaroMetric.compare("m a r t h a", "m a r h t a").get should be (0.9444444f)
					JaroMetric.compare("d w a y n e", "d u a n e").get should be (0.82222223f)
					JaroMetric.compare("d i x o n", "d i c k s o n x").get should be (0.76666665f)
					JaroMetric.compare("a b c v w x y z", "c a b v w x y z").get should be (0.9583333f)
					JaroMetric.compare("j o n e s", "j o h n s o n").get should be (0.79047614f)
					JaroMetric.compare("h e n k a", "h e n k a n").get should be (0.9444444f)
					JaroMetric.compare("f v i e", "t e n").get should be (0.0f)

					JaroMetric.compare("z a c e p h r o n", "z a c e f r o n").get should be >
						JaroMetric.compare("z a c e p h r o n", "k a i e p h r o n").get
					JaroMetric.compare("b r i t t n e y s p e a r s", "b r i t n e y s p e a r s").get should be >
						JaroMetric.compare("b r i t t n e y s p e a r s", "b r i t t n e y s t a r t z m a n").get
				}
			}
		}
	}
}