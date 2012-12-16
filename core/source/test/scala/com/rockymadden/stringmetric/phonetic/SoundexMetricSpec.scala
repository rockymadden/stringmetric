package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexMetricSpec extends ScalaTest {
	"SoundexMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					SoundexMetric.compare("", "").isDefined should be (false)
					SoundexMetric.compare("abc", "").isDefined should be (false)
					SoundexMetric.compare("", "xyz").isDefined should be (false)
				}
			}
			"non-phonetic arguments" should returns {
				"None" in {
					SoundexMetric.compare("123", "123").isDefined should be (false)
					SoundexMetric.compare("123", "").isDefined should be (false)
					SoundexMetric.compare("", "123").isDefined should be (false)
				}
			}
			"phonetically similar arguments" should returns {
				"Boolean indicating true" in {
					SoundexMetric.compare("robert", "rupert").get should be (true)
				}
			}
			"phonetically dissimilar arguments" should returns {
				"Boolean indicating false" in {
					SoundexMetric.compare("robert", "rubin").get should be (false)
				}
			}
		}
	}
}