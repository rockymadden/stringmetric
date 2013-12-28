package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class DiceSorensenMetricSpec extends ScalaTest {
	"DiceSorensenMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					DiceSorensenMetric(1).compare("", "").isDefined should be (false)
					DiceSorensenMetric(1).compare("abc", "").isDefined should be (false)
					DiceSorensenMetric(1).compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					DiceSorensenMetric(1).compare("abc", "abc").get should be (1)
					DiceSorensenMetric(2).compare("abc", "abc").get should be (1)
					DiceSorensenMetric(2).compare("abc", "abc").get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					DiceSorensenMetric(1).compare("abc", "xyz").get should be (0)
					DiceSorensenMetric(2).compare("abc", "xyz").get should be (0)
					DiceSorensenMetric(3).compare("abc", "xyz").get should be (0)
				}
			}
			"invalid arguments" should returns {
				"None" in {
					DiceSorensenMetric(2).compare("n", "naght").isDefined should be (false)
					DiceSorensenMetric(2).compare("night", "n").isDefined should be (false)
					DiceSorensenMetric(3).compare("ni", "naght").isDefined should be (false)
					DiceSorensenMetric(3).compare("night", "na").isDefined should be (false)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					DiceSorensenMetric(1).compare("night", "nacht").get should be (0.6)
					DiceSorensenMetric(1).compare("night", "naght").get should be (0.8)
					DiceSorensenMetric(1).compare("context", "contact").get should be (0.7142857142857143)

					DiceSorensenMetric(2).compare("night", "nacht").get should be (0.25)
					DiceSorensenMetric(2).compare("night", "naght").get should be (0.5)
					DiceSorensenMetric(2).compare("context", "contact").get should be (0.5)
					DiceSorensenMetric(2).compare("contextcontext", "contact").get should be (0.3157894736842105)
					DiceSorensenMetric(2).compare("context", "contactcontact").get should be (0.3157894736842105)
					DiceSorensenMetric(2).compare("ht", "nacht").get should be (0.4)
					DiceSorensenMetric(2).compare("xp", "nacht").get should be (0)
					DiceSorensenMetric(2).compare("ht", "hththt").get should be (0.3333333333333333)

					DiceSorensenMetric(3).compare("night", "nacht").get should be (0)
					DiceSorensenMetric(3).compare("night", "naght").get should be (0.3333333333333333)
					DiceSorensenMetric(3).compare("context", "contact").get should be (0.4)
				}
			}
		}
	}
}
