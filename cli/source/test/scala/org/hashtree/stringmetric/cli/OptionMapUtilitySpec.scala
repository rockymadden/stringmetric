package org.hashtree.stringmetric.cli

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class OptionMapUtilitySpec extends ScalaTest {
	"OptionMapUtility" should provide {
		"overloaded toOptionMap method" when passed {
			"Array with a single valid double dashed option" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(Array("--help"))

					options('help) should equal ("")
				}
			}
			"List with a single valid double dashed option" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(List("--help"))

					options('help) should equal ("")
				}
			}
			"Array with a multiple valid double dashed options" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(Array("--help", "--test=test"))

					options('help) should equal ("")
					options('test) should equal ("test")
				}
			}
			"List with a multiple valid double dashed options" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(List("--help", "--test=test"))

					options('help) should equal ("")
					options('test) should equal ("test")
				}
			}
			"Array with invalid double dashed options" should returns {
				"empty Map" in {
					val options = OptionMapUtility.toOptionMap(Array("--help#", "--test%=test"))

					options.keysIterator.length should be (0)
				}
			}
			"List with invalid double dashed options" should returns {
				"empty Map" in {
					val options = OptionMapUtility.toOptionMap(List("--help#", "--test%=test"))

					options.keysIterator.length should be (0)
				}
			}
			"Array with a single valid single dashed option" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(Array("-h"))

					options('h) should equal ("")
				}
			}
			"List with a single valid single dashed option" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(List("-h"))

					options('h) should equal ("")
				}
			}
			"Array with multiple valid single dashed options" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(Array("-h", "-i"))

					options('h) should equal ("")
					options('i) should equal ("")
				}
			}
			"List with multiple valid single dashed options" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(List("-h", "-i"))

					options('h) should equal ("")
					options('i) should equal ("")
				}
			}
			"Array with an invalid single dashed options" should returns {
				"empty Map" in {
					val options = OptionMapUtility.toOptionMap(Array("-h-i", "-i#gloo"))

					options.keysIterator.length should be (0)
				}
			}
			"List with an invalid single dashed options" should returns {
				"empty Map" in {
					val options = OptionMapUtility.toOptionMap(List("-h-i", "-i#gloo"))

					options.keysIterator.length should be (0)
				}
			}
			"Array with a single nameless option" should returns {
				"single key populated Map" in {
					val options = OptionMapUtility.toOptionMap(Array("filename0"))

					options('dashless).count(_ == ' ') should be (0)
				}
			}
			"List with a single nameless option" should returns {
				"single key populated Map" in {
					val options = OptionMapUtility.toOptionMap(List("filename0"))

					options('dashless).count(_ == ' ') should be (0)
				}
			}
			"Array with multiple single nameless options" should returns {
				"single key populated Map" in {
					val options = OptionMapUtility.toOptionMap(Array("filename0", "filename1", "filename2"))

					options('dashless).count(_ == ' ') should be (2)
				}
			}
			"List with multiple single nameless options" should returns {
				"single key populated Map" in {
					val options = OptionMapUtility.toOptionMap(List("filename0", "filename1", "filename2"))

					options('dashless).count(_ == ' ') should be (2)
				}
			}
			"Array with mixed options" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(Array("-q", "--help", "--test=test", "-go", "filename0", "filename1", "filename2"))

					options('q) should equal ("")
					options('help) should equal ("")
					options('test) should equal ("test")
					options('go) should equal ("")
					options('dashless).count(_ == ' ') should be (2)
				}
			}
			"List with mixed options" should returns {
				"populated Map" in {
					val options = OptionMapUtility.toOptionMap(List("-q", "--help", "--test=test", "-go", "filename0", "filename1", "filename2"))

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