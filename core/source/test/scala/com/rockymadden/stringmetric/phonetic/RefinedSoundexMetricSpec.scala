package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedSoundexMetricSpec extends ScalaTest { "RefinedSoundexMetric" should provide {
	"compare method" when passed {
		"empty arguments" should returns {
			"None" in {
				RefinedSoundexMetric.compare("", "").isDefined should be (false)
				RefinedSoundexMetric.compare("abc", "").isDefined should be (false)
				RefinedSoundexMetric.compare("", "xyz").isDefined should be (false)
			}
		}
		"non-phonetic arguments" should returns {
			"None" in {
				RefinedSoundexMetric.compare("123", "123").isDefined should be (false)
				RefinedSoundexMetric.compare("123", "").isDefined should be (false)
				RefinedSoundexMetric.compare("", "123").isDefined should be (false)
			}
		}
		"phonetically similar arguments" should returns {
			"Boolean indicating true" in {
				RefinedSoundexMetric.compare("robert", "rupert").get should be (true)
			}
		}
		"phonetically dissimilar arguments" should returns {
			"Boolean indicating false" in {
				RefinedSoundexMetric.compare("robert", "rubin").get should be (false)
			}
		}
	}
}}
