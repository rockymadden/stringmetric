package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class MetaphoneMetricSpec extends ScalaTest {
	"MetaphoneMetric" should provide {
		"compare method" when passed {
			"empty arguments" should returns {
				"None" in {
					MetaphoneMetric.compare("", "").isDefined should be (false)
					MetaphoneMetric.compare("abc", "").isDefined should be (false)
					MetaphoneMetric.compare("", "xyz").isDefined should be (false)
				}
			}
			"non-phonetic arguments" should returns {
				"None" in {
					MetaphoneMetric.compare("123", "123").isDefined should be (false)
					MetaphoneMetric.compare("123", "").isDefined should be (false)
					MetaphoneMetric.compare("", "123").isDefined should be (false)
				}
			}
			"phonetically similar arguments" should returns {
				"Boolean indicating true" in {
					MetaphoneMetric.compare("dumb", "dum").get should be (true)
					MetaphoneMetric.compare("smith", "smeth").get should be (true)
					MetaphoneMetric.compare("merci", "mercy").get should be (true)
				}
			}
			"phonetically dissimilar arguments" should returns {
				"Boolean indicating false" in {
					MetaphoneMetric.compare("dumb", "gum").get should be (false)
					MetaphoneMetric.compare("smith", "kiss").get should be (false)
					MetaphoneMetric.compare("merci", "burpy").get should be (false)
				}
			}
		}
	}
}
