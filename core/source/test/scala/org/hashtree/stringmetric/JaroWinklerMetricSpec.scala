package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaroWinklerMetricSpec extends ScalaTest {
	implicit val stringMetric = new StringCleanerDelegate with CaseStringCleaner with SpaceStringCleaner

	"JaroWinklerMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Float indicating distance" in {
					JaroWinklerMetric.compare("abc", "abc").get should be (1.0f)
					JaroWinklerMetric.compare("abc", "xyz").get should be (0.0f)
					JaroWinklerMetric.compare("abc", "").isDefined should be (false)
					JaroWinklerMetric.compare("", "xyz").isDefined should be (false)
					JaroWinklerMetric.compare("", "").isDefined should be (false)
					JaroWinklerMetric.compare("a", "a").get should be (1.0f)

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

					JaroWinklerMetric.compare("m a r t h a", "m a r h t a").get should be (0.96111107f)
					JaroWinklerMetric.compare("d w a y n e", "d u a n e").get should be (0.84000003f)
					JaroWinklerMetric.compare("d i x o n", "d i c k s o n x").get should be (0.81333333f)
					JaroWinklerMetric.compare("a b c v w x y z", "c a b v w x y z").get should be (0.9583333f)
					JaroWinklerMetric.compare("j o n e s", "j o h n s o n").get should be (0.8323809f)
					JaroWinklerMetric.compare("h e n k a", "h e n k a n").get should be (0.96666664f)
					JaroWinklerMetric.compare("f v i e", "t e n").get should be (0.0f)

					JaroWinklerMetric.compare("z a c e p h r o n", "z a c e f r o n").get should be >
						JaroWinklerMetric.compare("z a c e p h r o n", "k a i e p h r o n").get
					JaroWinklerMetric.compare("b r i t t n e y s p e a r s", "b r i t n e y s p e a r s").get should be >
						JaroWinklerMetric.compare("b r i t t n e y s p e a r s", "b r i t t n e y s t a r t z m a n").get
				}
			}
		}
	}
}