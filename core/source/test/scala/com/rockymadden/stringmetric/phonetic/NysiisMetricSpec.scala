package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NysiisMetricSpec extends ScalaTest {
	import NysiisMetricSpec.Metric

	"NysiisMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					Metric.compare("", "").isDefined should be (false)
					Metric.compare("abc", "").isDefined should be (false)
					Metric.compare("", "xyz").isDefined should be (false)
				}
			}
			"non-phonetic arguments" should returns {
				"None" in {
					Metric.compare("123", "123").isDefined should be (false)
					Metric.compare("123", "").isDefined should be (false)
					Metric.compare("", "123").isDefined should be (false)
				}
			}
			"phonetically similar arguments" should returns {
				"Boolean indicating true" in {
					Metric.compare("ham", "hum").get should be (true)
				}
			}
			"phonetically dissimilar arguments" should returns {
				"Boolean indicating false" in {
					Metric.compare("dumb", "gum").get should be (false)
				}
			}
		}
	}
	"NysiisMetric companion object" should provide {
		"pass-through compare method" should returns {
			"same value as class" in {
				NysiisMetric.compare("dumb", "gum").get should be (false)
			}
		}
	}
}

object NysiisMetricSpec {
	final private val Metric = NysiisMetric()
}
