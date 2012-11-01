package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiNumberStringFilterSpec extends ScalaTest {
	private final val Filter = new StringFilterDelegate with AsciiNumberStringFilter

	"AsciiNumberStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with numbers" should returns {
				"String with numbers removed" in {
					Filter.filter("	Hello123World!") should equal ("	HelloWorld!")
				}
			}
			"character array with numbers" should returns {
				"character array with numbers removed" in {
					Filter.filter("	Hello123World!".toCharArray) should equal ("	HelloWorld!".toCharArray)
				}
			}
		}
	}
}