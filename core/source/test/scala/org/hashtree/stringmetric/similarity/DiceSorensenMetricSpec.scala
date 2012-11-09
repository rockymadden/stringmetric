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
					DiceSorensenMetric.compare("", "").isDefined should be (false)
					DiceSorensenMetric.compare("abc", "").isDefined should be (false)
					DiceSorensenMetric.compare("", "xyz").isDefined should be (false)
				}
			}
			"equal arguments" should returns {
				"1" in {
					DiceSorensenMetric.compare("abc", "abc").get should be (1)
				}
			}
			"unequal arguments" should returns {
				"0" in {
					DiceSorensenMetric.compare("abc", "xyz").get should be (0)
				}
			}
			"invalid arguments" should returns {
				"Double indicating distance" in {
					DiceSorensenMetric.compare("n", "naght").get should be (0)
					DiceSorensenMetric.compare("night", "n").get should be (0)
				}
			}
			"valid arguments" should returns {
				"Double indicating distance" in {
					DiceSorensenMetric.compare("night", "nacht").get should be (0.25)
					DiceSorensenMetric.compare("night", "naght").get should be (0.5)
					DiceSorensenMetric.compare("context", "contact").get should be (0.5)
				}
			}
		}
	}
}