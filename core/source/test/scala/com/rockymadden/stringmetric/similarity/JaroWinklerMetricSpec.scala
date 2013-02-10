package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaroWinklerMetricSpec extends ScalaTest {
	import JaroWinklerMetricSpec._

	"JaroWinklerMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					Metric.compare("", "").isDefined should be (false)
					Metric.compare("abc", "").isDefined should be (false)
					Metric.compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					Metric.compare("a", "a").get should be (1)
					Metric.compare("abc", "abc").get should be (1)
					Metric.compare("123", "123").get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					Metric.compare("abc", "xyz").get should be (0)
					Metric.compare("123", "456").get should be (0)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					Metric.compare("aa", "a").get should be (0.8500000000000001)
					Metric.compare("a", "aa").get should be (0.8500000000000001)
					Metric.compare("veryveryverylong", "v").get should be (0.71875)
					Metric.compare("v", "veryveryverylong").get should be (0.71875)
					Metric.compare("martha", "marhta").get should be (0.9611111111111111)
					Metric.compare("dwayne", "duane").get should be (0.8400000000000001)
					Metric.compare("dixon", "dicksonx").get should be (0.8133333333333332)
					Metric.compare("abcvwxyz", "cabvwxyz").get should be (0.9583333333333334)
					Metric.compare("jones", "johnson").get should be (0.8323809523809523)
					Metric.compare("henka", "henkan").get should be (0.9666666666666667)
					Metric.compare("fvie", "ten").get should be (0)

					Metric.compare("zac ephron", "zac efron").get should be >
						Metric.compare("zac ephron", "kai ephron").get
					Metric.compare("brittney spears", "britney spears").get should be >
						Metric.compare("brittney spears", "brittney startzman").get
				}
			}
		}
	}
}

object JaroWinklerMetricSpec {
	private final val Metric = new JaroWinklerMetric
}
