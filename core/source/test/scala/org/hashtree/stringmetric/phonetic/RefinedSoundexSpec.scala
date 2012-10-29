package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedSoundexSpec extends ScalaTest {
	"RefinedSoundex" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					RefinedSoundex.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					RefinedSoundex.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					RefinedSoundex.compute("x123").get should equal ("x5")

					RefinedSoundex.compute("braz").get should equal ("b1905")
					RefinedSoundex.compute("broz").get should equal ("b1905")
					RefinedSoundex.compute("caren").get should equal ("c30908")
					RefinedSoundex.compute("carren").get should equal ("c30908")
					RefinedSoundex.compute("coram").get should equal ("c30908")
					RefinedSoundex.compute("corran").get should equal ("c30908")
					RefinedSoundex.compute("curreen").get should equal ("c30908")
					RefinedSoundex.compute("curwen").get should equal ("c30908")
					RefinedSoundex.compute("hairs").get should equal ("h093")
					RefinedSoundex.compute("hark").get should equal ("h093")
					RefinedSoundex.compute("hars").get should equal ("h093")
					RefinedSoundex.compute("hayers").get should equal ("h093")
					RefinedSoundex.compute("heers").get should equal ("h093")
					RefinedSoundex.compute("hiers").get should equal ("h093")
					RefinedSoundex.compute("lambard").get should equal ("l7081096")
					RefinedSoundex.compute("lambart").get should equal ("l7081096")
					RefinedSoundex.compute("lambert").get should equal ("l7081096")
					RefinedSoundex.compute("lambird").get should equal ("l7081096")
					RefinedSoundex.compute("lampaert").get should equal ("l7081096")
					RefinedSoundex.compute("lampart").get should equal ("l7081096")
					RefinedSoundex.compute("lamport").get should equal ("l7081096")
					RefinedSoundex.compute("limbert").get should equal ("l7081096")
					RefinedSoundex.compute("lombard").get should equal ("l7081096")
					RefinedSoundex.compute("nolton").get should equal ("n807608")
					RefinedSoundex.compute("noulton").get should equal ("n807608")
				}
			}
		}
	}
}