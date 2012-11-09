package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class DiceSorensenMetricSpec extends ScalaTest {
	"DiceSorensenMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					DiceSorensenMetric.compare("", "")(1).isDefined should be (false)
					DiceSorensenMetric.compare("abc", "")(1).isDefined should be (false)
					DiceSorensenMetric.compare("", "xyz")(1).isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					DiceSorensenMetric.compare("abc", "abc")(1).get should be (1)
					DiceSorensenMetric.compare("abc", "abc")(2).get should be (1)
					DiceSorensenMetric.compare("abc", "abc")(3).get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					DiceSorensenMetric.compare("abc", "xyz")(1).get should be (0)
					DiceSorensenMetric.compare("abc", "xyz")(2).get should be (0)
					DiceSorensenMetric.compare("abc", "xyz")(3).get should be (0)
				}
			}
			"invalid arguments" should returns {
				"Double indicating distance" in {
					DiceSorensenMetric.compare("n", "naght")(2).get should be (0)
					DiceSorensenMetric.compare("night", "n")(2).get should be (0)
					DiceSorensenMetric.compare("ni", "naght")(3).get should be (0)
					DiceSorensenMetric.compare("night", "na")(3).get should be (0)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					DiceSorensenMetric.compare("night", "nacht")(1).get should be (0.6)
					DiceSorensenMetric.compare("night", "naght")(1).get should be (0.8)
					DiceSorensenMetric.compare("context", "contact")(1).get should be (0.7142857142857143)

					DiceSorensenMetric.compare("night", "nacht")(2).get should be (0.25)
					DiceSorensenMetric.compare("night", "naght")(2).get should be (0.5)
					DiceSorensenMetric.compare("context", "contact")(2).get should be (0.5)
					DiceSorensenMetric.compare("contextcontext", "contact")(2).get should be (0.3157894736842105)
					DiceSorensenMetric.compare("context", "contactcontact")(2).get should be (0.3157894736842105)
					DiceSorensenMetric.compare("ht", "nacht")(2).get should be (0.4)
					DiceSorensenMetric.compare("xp", "nacht")(2).get should be (0)
					DiceSorensenMetric.compare("ht", "hththt")(2).get should be (0.3333333333333333)

					DiceSorensenMetric.compare("night", "nacht")(3).get should be (0)
					DiceSorensenMetric.compare("night", "naght")(3).get should be (0.3333333333333333)
					DiceSorensenMetric.compare("context", "contact")(3).get should be (0.4)
				}
			}
		}
	}
}