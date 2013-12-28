package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaccardMetricSpec extends ScalaTest {
	"JaccardMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					JaccardMetric(1).compare("", "").isDefined should be (false)
					JaccardMetric(1).compare("abc", "").isDefined should be (false)
					JaccardMetric(1).compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					JaccardMetric(1).compare("abc", "abc").get should be (1)
					JaccardMetric(2).compare("abc", "abc").get should be (1)
					JaccardMetric(3).compare("abc", "abc").get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					JaccardMetric(1).compare("abc", "xyz").get should be (0)
					JaccardMetric(2).compare("abc", "xyz").get should be (0)
					JaccardMetric(3).compare("abc", "xyz").get should be (0)
				}
			}
			"invalid arguments" should returns {
				"None" in {
					JaccardMetric(2).compare("n", "naght").isDefined should be (false)
					JaccardMetric(2).compare("night", "n").isDefined should be (false)
					JaccardMetric(3).compare("ni", "naght").isDefined should be (false)
					JaccardMetric(3).compare("night", "na").isDefined should be (false)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					JaccardMetric(1).compare("night", "nacht").get should be (0.42857142857142855)
					JaccardMetric(1).compare("night", "naght").get should be (0.6666666666666666)
					JaccardMetric(1).compare("context", "contact").get should be (0.5555555555555556)

					JaccardMetric(2).compare("night", "nacht").get should be (0.14285714285714285)
					JaccardMetric(2).compare("night", "naght").get should be (0.3333333333333333)
					JaccardMetric(2).compare("context", "contact").get should be (0.3333333333333333)
					JaccardMetric(2).compare("contextcontext", "contact").get should be (0.1875)
					JaccardMetric(2).compare("context", "contactcontact").get should be (0.1875)
					JaccardMetric(2).compare("ht", "nacht").get should be (0.25)
					JaccardMetric(2).compare("xp", "nacht").get should be (0)
					JaccardMetric(2).compare("ht", "hththt").get should be (0.2)

					JaccardMetric(3).compare("night", "nacht").get should be (0)
					JaccardMetric(3).compare("night", "naght").get should be (0.2)
					JaccardMetric(3).compare("context", "contact").get should be (0.25)
				}
			}
		}
	}
}
