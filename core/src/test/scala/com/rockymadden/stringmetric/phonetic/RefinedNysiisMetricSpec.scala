package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedNysiisMetricSpec extends ScalaTest { "RefinedNysiisMetric" should provide {
	"compare method" when passed {
		"empty arguments" should returns {
			"None" in {
				RefinedNysiisMetric.compare("", "").isDefined should be (false)
				RefinedNysiisMetric.compare("abc", "").isDefined should be (false)
				RefinedNysiisMetric.compare("", "xyz").isDefined should be (false)
			}
		}
		"non-phonetic arguments" should returns {
			"None" in {
				RefinedNysiisMetric.compare("123", "123").isDefined should be (false)
				RefinedNysiisMetric.compare("123", "").isDefined should be (false)
				RefinedNysiisMetric.compare("", "123").isDefined should be (false)
			}
		}
		"phonetically similar arguments" should returns {
			"Boolean indicating true" in {
				RefinedNysiisMetric.compare("ham", "hum").get should be (true)
			}
		}
		"phonetically dissimilar arguments" should returns {
			"Boolean indicating false" in {
				RefinedNysiisMetric.compare("dumb", "gum").get should be (false)
			}
		}
	}
}}
