package org.hashtree.stringmetric.cli

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class OptionMapSpec extends ScalaTest {
	"OptionMap" should provide {
		"apply method" when passed {
			"single valid double dashed option" should returns {
				"populated Map" in {
					val options = OptionMap("--help")

					options('help) should equal ("")
				}
			}
			"multiple valid double dashed options" should returns {
				"populated Map" in {
					val options = OptionMap("--help", "--test=test")

					options('help) should equal ("")
					options('test) should equal ("test")
				}
			}
			"invalid double dashed options" should returns {
				"empty Map" in {
					val options = OptionMap("--help#", "--test%=test")

					options.keysIterator.length should be (0)
				}
			}
			"single valid single dashed option" should returns {
				"populated Map" in {
					val options = OptionMap("-h")

					options('h) should equal ("")
				}
			}
			"multiple valid single dashed options" should returns {
				"populated Map" in {
					val options = OptionMap("-h", "-i")

					options('h) should equal ("")
					options('i) should equal ("")
				}
			}
			"invalid single dashed options" should returns {
				"empty Map" in {
					val options = OptionMap("-h-i", "-i#gloo")

					options.keysIterator.length should be (0)
				}
			}
			"single nameless option" should returns {
				"single key populated Map" in {
					val options = OptionMap("filename0")

					options('dashless).count(_ == ' ') should be (0)
				}
			}
			"multiple single nameless options" should returns {
				"single key populated Map" in {
					val options = OptionMap("filename0", "filename1", "filename2")

					options('dashless).count(_ == ' ') should be (2)
				}
			}
			"mixed options" should returns {
				"populated Map" in {
					val options = OptionMap(
						"-q", "--help", "--test=test", "-go", "filename0", "filename1", "filename2"
					)

					options('q) should equal ("")
					options('help) should equal ("")
					options('test) should equal ("test")
					options('go) should equal ("")
					options('dashless).count(_ == ' ') should be (2)
				}
			}
		}
	}
}