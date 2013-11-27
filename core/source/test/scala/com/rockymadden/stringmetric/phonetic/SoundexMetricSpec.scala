package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexMetricSpec extends ScalaTest {
	import SoundexMetricSpec.Metric

	"SoundexMetric" should provide {
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
	"SoundexMetric companion object" should provide {
		"pass-through compare method" should returns {
			"same value as class" in {
				SoundexMetric.compare("robert", "rubin").get should be (false)
			}
		}
	}
}

object SoundexMetricSpec {
	final private val Metric = SoundexMetric()
}
