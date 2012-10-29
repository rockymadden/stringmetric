package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedSoundexAlgorithmSpec extends ScalaTest {
	"RefinedSoundexAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					RefinedSoundexAlgorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					RefinedSoundexAlgorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					RefinedSoundexAlgorithm.compute("x123").get should equal ("x5")

					RefinedSoundexAlgorithm.compute("braz").get should equal ("b1905")
					RefinedSoundexAlgorithm.compute("broz").get should equal ("b1905")
					RefinedSoundexAlgorithm.compute("caren").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("carren").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("coram").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("corran").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("curreen").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("curwen").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("hairs").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hark").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hars").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hayers").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("heers").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hiers").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("lambard").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lambart").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lambert").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lambird").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lampaert").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lampart").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lamport").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("limbert").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lombard").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("nolton").get should equal ("n807608")
					RefinedSoundexAlgorithm.compute("noulton").get should equal ("n807608")
				}
			}
		}
	}
}