package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiLetterNumberOnlyStringFilterSpec extends ScalaTest {
	private final val Filter = new StringFilterDelegate with AsciiLetterNumberOnlyStringFilter

	"AsciiLetterNumberOnlyStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-letters and non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc") should equal ("abc")
					Filter.filter("!@#$%^&*()abc123") should equal ("abc123")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-letters and non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc".toCharArray) should equal ("abc".toCharArray)
					Filter.filter("!@#$%^&*()abc123".toCharArray) should equal ("abc123".toCharArray)
				}
			}
		}
	}
}