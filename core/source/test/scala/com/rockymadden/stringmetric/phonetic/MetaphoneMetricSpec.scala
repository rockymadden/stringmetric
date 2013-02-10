package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class MetaphoneMetricSpec extends ScalaTest {
	import MetaphoneMetricSpec._

	"MetaphoneMetric" should provide {
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
					Metric.compare("dumb", "dum").get should be (true)
					Metric.compare("smith", "smeth").get should be (true)
					Metric.compare("merci", "mercy").get should be (true)
				}
			}
			"phonetically dissimilar arguments" should returns {
				"Boolean indicating false" in {
					Metric.compare("dumb", "gum").get should be (false)
					Metric.compare("smith", "kiss").get should be (false)
					Metric.compare("merci", "burpy").get should be (false)
				}
			}
		}
	}
}

object MetaphoneMetricSpec {
	final private val Metric = new MetaphoneMetric
}
