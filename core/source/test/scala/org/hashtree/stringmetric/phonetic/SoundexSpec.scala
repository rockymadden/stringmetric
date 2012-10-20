package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexSpec extends ScalaTest {
	"Soundex" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					Soundex.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					Soundex.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					Soundex.compute("abc").get should equal ("a120")
					Soundex.compute("xyz").get should equal ("x200")
					Soundex.compute("robert").get should equal ("r163")
					Soundex.compute("rupert").get should equal ("r163")
					Soundex.compute("rubin").get should equal ("r150")
					Soundex.compute("ashcraft").get should equal ("a261")
					Soundex.compute("tymczak").get should equal ("t522")
					Soundex.compute("pfister").get should equal ("p236")
					Soundex.compute("euler").get should equal ("e460")
					Soundex.compute("gauss").get should equal ("g200")
					Soundex.compute("hilbert").get should equal ("h416")
					Soundex.compute("knuth").get should equal ("k530")
					Soundex.compute("lloyd").get should equal ("l300")
					Soundex.compute("lukasiewicz").get should equal ("l222")
					Soundex.compute("ashcroft").get should equal ("a261")
					Soundex.compute("tymczak").get should equal ("t522")
					Soundex.compute("pfister").get should equal ("p236")
					Soundex.compute("ellery").get should equal ("e460")
					Soundex.compute("ghosh").get should equal ("g200")
					Soundex.compute("heilbronn").get should equal ("h416")
					Soundex.compute("kant").get should equal ("k530")
					Soundex.compute("ladd").get should equal ("l300")
					Soundex.compute("lissajous").get should equal ("l222")
				}
			}
		}
	}
}