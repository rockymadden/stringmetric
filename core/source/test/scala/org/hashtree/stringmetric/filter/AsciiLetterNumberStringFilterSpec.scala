package org.hashtree.stringmetric.filter

import org.hashtree.stringmetric.ScalaTest
import org.hashtree.stringmetric.StringFilterDelegate
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiLetterNumberStringFilterSpec extends ScalaTest {
	private final val Filter = new StringFilterDelegate with AsciiLetterNumberStringFilter

	"AsciiLetterNumberStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with letters and numbers" should returns {
				"String with letters and numbers removed" in {
					Filter.filter("	Hello123World!") should equal ("	!")
				}
			}
			"character array with letters and numbers" should returns {
				"character array with letters and numbers removed" in {
					Filter.filter("	Hello123World!".toCharArray) should equal ("	!".toCharArray)
				}
			}
		}
	}
}