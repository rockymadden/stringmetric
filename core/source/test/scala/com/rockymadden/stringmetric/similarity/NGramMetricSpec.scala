package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NGramMetricSpec extends ScalaTest {
	"NGramMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					NGramMetric.compare("", "")(1).isDefined should be (false)
					NGramMetric.compare("abc", "")(1).isDefined should be (false)
					NGramMetric.compare("", "xyz")(1).isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					NGramMetric.compare("abc", "abc")(1).get should be (1)
					NGramMetric.compare("abc", "abc")(2).get should be (1)
					NGramMetric.compare("abc", "abc")(3).get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					NGramMetric.compare("abc", "xyz")(1).get should be (0)
					NGramMetric.compare("abc", "xyz")(2).get should be (0)
					NGramMetric.compare("abc", "xyz")(3).get should be (0)
				}
			}
			"invalid arguments" should returns {
				"None" in {
					NGramMetric.compare("n", "naght")(2).isDefined should be (false)
					NGramMetric.compare("night", "n")(2).isDefined should be (false)
					NGramMetric.compare("ni", "naght")(3).isDefined should be (false)
					NGramMetric.compare("night", "na")(3).isDefined should be (false)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					NGramMetric.compare("night", "nacht")(1).get should be (0.6)
					NGramMetric.compare("night", "naght")(1).get should be (0.8)
					NGramMetric.compare("context", "contact")(1).get should be (0.7142857142857143)

					NGramMetric.compare("night", "nacht")(2).get should be (0.25)
					NGramMetric.compare("night", "naght")(2).get should be (0.5)
					NGramMetric.compare("context", "contact")(2).get should be (0.5)
					NGramMetric.compare("contextcontext", "contact")(2).get should be (0.23076923076923078)
					NGramMetric.compare("context", "contactcontact")(2).get should be (0.23076923076923078)
					NGramMetric.compare("ht", "nacht")(2).get should be (0.25)
					NGramMetric.compare("xp", "nacht")(2).get should be (0)
					NGramMetric.compare("ht", "hththt")(2).get should be (0.2)

					NGramMetric.compare("night", "nacht")(3).get should be (0)
					NGramMetric.compare("night", "naght")(3).get should be (0.3333333333333333)
					NGramMetric.compare("context", "contact")(3).get should be (0.4)
				}
			}
		}
	}
}