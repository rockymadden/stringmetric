package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.filter.AsciiNumberFilter
import com.rockymadden.stringmetric.phonetic.MetaphoneAlgorithm
import com.rockymadden.stringmetric.similarity.DiceSorensenMetric
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class FilterDecoratedSpec extends ScalaTest {
	import FilterDecoratedSpec.{ Algorithm, Metric }

	"Filter decorated metrics" should provide {
		"compare method" when passed {
			"filterable arguments" should returns {
				"filtered results" in {
					Metric.compare("123", "456")(1).isDefined should be (false)
					Metric.compare("ni123ght", "na456cht")(1).get should be (0.6)
				}
			}
		}
	}
	"Filter decorated algorithms" should provide {
		"compute method" when passed {
			"filterable argument" should returns {
				"filtered results" in {
					Algorithm.compute("456").isDefined should be (false)
					Algorithm.compute("du123mb456").get should equal ("tm")
				}
			}
		}
	}
}

object FilterDecoratedSpec {
	private final val Algorithm = new MetaphoneAlgorithm with AsciiNumberFilter
	private final val Metric = new DiceSorensenMetric with AsciiNumberFilter
}
