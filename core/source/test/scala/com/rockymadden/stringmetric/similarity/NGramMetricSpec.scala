package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NGramMetricSpec extends ScalaTest {
	import NGramMetricSpec.Metric

	"NGramMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					Metric.compare("", "")(1).isDefined should be (false)
					Metric.compare("abc", "")(1).isDefined should be (false)
					Metric.compare("", "xyz")(1).isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					Metric.compare("abc", "abc")(1).get should be (1)
					Metric.compare("abc", "abc")(2).get should be (1)
					Metric.compare("abc", "abc")(3).get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					Metric.compare("abc", "xyz")(1).get should be (0)
					Metric.compare("abc", "xyz")(2).get should be (0)
					Metric.compare("abc", "xyz")(3).get should be (0)
				}
			}
			"invalid arguments" should returns {
				"None" in {
					Metric.compare("n", "naght")(2).isDefined should be (false)
					Metric.compare("night", "n")(2).isDefined should be (false)
					Metric.compare("ni", "naght")(3).isDefined should be (false)
					Metric.compare("night", "na")(3).isDefined should be (false)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					Metric.compare("night", "nacht")(1).get should be (0.6)
					Metric.compare("night", "naght")(1).get should be (0.8)
					Metric.compare("context", "contact")(1).get should be (0.7142857142857143)

					Metric.compare("night", "nacht")(2).get should be (0.25)
					Metric.compare("night", "naght")(2).get should be (0.5)
					Metric.compare("context", "contact")(2).get should be (0.5)
					Metric.compare("contextcontext", "contact")(2).get should be (0.23076923076923078)
					Metric.compare("context", "contactcontact")(2).get should be (0.23076923076923078)
					Metric.compare("ht", "nacht")(2).get should be (0.25)
					Metric.compare("xp", "nacht")(2).get should be (0)
					Metric.compare("ht", "hththt")(2).get should be (0.2)

					Metric.compare("night", "nacht")(3).get should be (0)
					Metric.compare("night", "naght")(3).get should be (0.3333333333333333)
					Metric.compare("context", "contact")(3).get should be (0.4)
				}
			}
		}
	}
}

object NGramMetricSpec {
	private final val Metric = NGramMetric()
}
