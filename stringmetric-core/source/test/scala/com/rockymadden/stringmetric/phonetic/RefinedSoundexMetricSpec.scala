package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedSoundexMetricSpec extends ScalaTest {
	import RefinedSoundexMetricSpec.Metric

	"RefinedSoundexMetric" should provide {
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
					Metric.compare("robert", "rupert").get should be (true)
				}
			}
			"phonetically dissimilar arguments" should returns {
				"Boolean indicating false" in {
					Metric.compare("robert", "rubin").get should be (false)
				}
			}
		}
	}
	"RefinedSoundexMetric companion object" should provide {
		"pass-through compare method" should returns {
			"same value as class" in {
				RefinedSoundexMetric.compare("robert", "rubin").get should be (false)
			}
		}
	}
}

object RefinedSoundexMetricSpec {
	final private val Metric = RefinedSoundexMetric()
}
