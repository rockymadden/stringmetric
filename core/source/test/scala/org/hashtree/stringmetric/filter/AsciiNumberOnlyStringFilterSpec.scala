package org.hashtree.stringmetric.filter

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiNumberOnlyStringFilterSpec extends ScalaTest {
	private[this] val Filter = new StringFilterDelegate with AsciiNumberOnlyStringFilter

	"AsciiNumberOnlyStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc123") should equal ("123")
					Filter.filter("123!@#$%^&*()abc") should equal ("123")
					Filter.filter("!@#$%^123&*()abc") should equal ("123")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc123".toCharArray) should equal ("123".toCharArray)
					Filter.filter("123!@#$%^&*()abc".toCharArray) should equal ("123".toCharArray)
					Filter.filter("!@#$%^123&*()abc".toCharArray) should equal ("123".toCharArray)
				}
			}
		}
	}
}