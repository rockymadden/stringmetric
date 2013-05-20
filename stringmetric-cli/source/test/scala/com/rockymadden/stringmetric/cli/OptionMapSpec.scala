package com.rockymadden.stringmetric.cli

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class OptionMapSpec extends ScalaTest {
	"OptionMap" should provide {
		"apply method" when passed {
			"single valid double dashed option" should returns {
				"populated Map" in {
					val opts: OptionMap = Array("--help")

					(opts('help): String) should equal ("")
				}
			}
			"multiple valid double dashed opts" should returns {
				"populated Map" in {
					val opts: OptionMap = Array("--help", "--test=test")

					(opts('help): String) should equal ("")
					(opts('test): String) should equal ("test")
				}
			}
			"invalid double dashed opts" should returns {
				"empty Map" in {
					val opts: OptionMap = Array("--help#", "--test%=test")

					opts.keysIterator.length should be (0)
				}
			}
			"single valid single dashed option" should returns {
				"populated Map" in {
					val opts: OptionMap = Array("-h")

					(opts('h): String) should equal ("")
				}
			}
			"multiple valid single dashed opts" should returns {
				"populated Map" in {
					val opts: OptionMap = Array("-h", "-i")

					(opts('h): String) should equal ("")
					(opts('i): String) should equal ("")
				}
			}
			"invalid single dashed opts" should returns {
				"empty Map" in {
					val opts: OptionMap = Array("-h-i", "-i#gloo")

					opts.keysIterator.length should be (0)
				}
			}
			"single nameless option" should returns {
				"single key populated Map" in {
					val opts: OptionMap = Array("filename0")

					(opts('dashless): String).count(_ == ' ') should be (0)
				}
			}
			"multiple single nameless opts" should returns {
				"single key populated Map" in {
					val opts: OptionMap = Array("filename0", "filename1", "filename2")

					(opts('dashless): String).count(_ == ' ') should be (2)
				}
			}
			"mixed opts" should returns {
				"populated Map" in {
					val opts: OptionMap = Array(
						"-q", "--help", "--test=test", "-go", "filename0", "filename1", "filename2"
					)

					(opts('q): String) should equal ("")
					(opts('help): String) should equal ("")
					(opts('test): String) should equal ("test")
					(opts('go): String) should equal ("")
					(opts('dashless): String).count(_ == ' ') should be (2)
				}
			}
		}
	}
}
