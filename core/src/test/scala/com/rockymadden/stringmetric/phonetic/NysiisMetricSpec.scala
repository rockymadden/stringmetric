package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NysiisMetricSpec extends ScalaTest {
	"NysiisMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					NysiisMetric.compare("", "").isDefined should be (false)
					NysiisMetric.compare("abc", "").isDefined should be (false)
					NysiisMetric.compare("", "xyz").isDefined should be (false)
				}
			}
			"non-phonetic arguments" should returns {
				"None" in {
					NysiisMetric.compare("123", "123").isDefined should be (false)
					NysiisMetric.compare("123", "").isDefined should be (false)
					NysiisMetric.compare("", "123").isDefined should be (false)
				}
			}
			"phonetically similar arguments" should returns {
				"Boolean indicating true" in {
					NysiisMetric.compare("ham", "hum").get should be (true)
				}
			}
			"phonetically dissimilar arguments" should returns {
				"Boolean indicating false" in {
					NysiisMetric.compare("dumb", "gum").get should be (false)
				}
			}
		}
	}
}
