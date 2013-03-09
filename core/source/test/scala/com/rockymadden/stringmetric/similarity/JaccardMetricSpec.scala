package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class JaccardMetricSpec extends ScalaTest {
	import JaccardMetricSpec.Metric

	"JaccardMetric" should provide {
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
					Metric.compare("night", "nacht")(1).get should be (0.3)
					Metric.compare("night", "naght")(1).get should be (0.4)
					Metric.compare("context", "contact")(1).get should be (0.35714285714285715)

					Metric.compare("night", "nacht")(2).get should be (0.125)
					Metric.compare("night", "naght")(2).get should be (0.25)
					Metric.compare("context", "contact")(2).get should be (0.25)
					Metric.compare("contextcontext", "contact")(2).get should be (0.15789473684210525)
					Metric.compare("context", "contactcontact")(2).get should be (0.15789473684210525)
					Metric.compare("ht", "nacht")(2).get should be (0.2)
					Metric.compare("xp", "nacht")(2).get should be (0)
					Metric.compare("ht", "hththt")(2).get should be (0.16666666666666666)

					Metric.compare("night", "nacht")(3).get should be (0)
					Metric.compare("night", "naght")(3).get should be (0.16666666666666666)
					Metric.compare("context", "contact")(3).get should be (0.2)
				}
			}
		}
	}
	"JaccardMetric companion object" should provide {
		"pass-through compare method" should returns {
			"same value as class" in {
				JaccardMetric.compare("context", "contact")(3).get should be (0.2)
			}
		}
	}
}

object JaccardMetricSpec {
	private final val Metric = JaccardMetric()
}


