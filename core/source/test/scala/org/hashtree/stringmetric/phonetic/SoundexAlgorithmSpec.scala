package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexAlgorithmSpec extends ScalaTest {
	"SoundexAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					SoundexAlgorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					SoundexAlgorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					SoundexAlgorithm.compute("x123").get should equal ("x000")

					SoundexAlgorithm.compute("abc").get should equal ("a120")
					SoundexAlgorithm.compute("xyz").get should equal ("x200")

					SoundexAlgorithm.compute("robert").get should equal ("r163")
					SoundexAlgorithm.compute("rupert").get should equal ("r163")
					SoundexAlgorithm.compute("rubin").get should equal ("r150")
					SoundexAlgorithm.compute("ashcraft").get should equal ("a261")
					SoundexAlgorithm.compute("tymczak").get should equal ("t522")
					SoundexAlgorithm.compute("pfister").get should equal ("p236")
					SoundexAlgorithm.compute("euler").get should equal ("e460")
					SoundexAlgorithm.compute("gauss").get should equal ("g200")
					SoundexAlgorithm.compute("hilbert").get should equal ("h416")
					SoundexAlgorithm.compute("knuth").get should equal ("k530")
					SoundexAlgorithm.compute("lloyd").get should equal ("l300")
					SoundexAlgorithm.compute("lukasiewicz").get should equal ("l222")
					SoundexAlgorithm.compute("ashcroft").get should equal ("a261")
					SoundexAlgorithm.compute("tymczak").get should equal ("t522")
					SoundexAlgorithm.compute("pfister").get should equal ("p236")
					SoundexAlgorithm.compute("ellery").get should equal ("e460")
					SoundexAlgorithm.compute("ghosh").get should equal ("g200")
					SoundexAlgorithm.compute("heilbronn").get should equal ("h416")
					SoundexAlgorithm.compute("kant").get should equal ("k530")
					SoundexAlgorithm.compute("ladd").get should equal ("l300")
					SoundexAlgorithm.compute("lissajous").get should equal ("l222")
					SoundexAlgorithm.compute("fusedale").get should equal ("f234")
				}
			}
		}
	}
}