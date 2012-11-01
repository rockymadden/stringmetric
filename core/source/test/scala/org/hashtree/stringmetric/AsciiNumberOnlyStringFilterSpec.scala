package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiNumberOnlyStringFilterSpec extends ScalaTest {
	private final val Filter = new StringFilterDelegate with AsciiNumberOnlyStringFilter

	"AsciiNumberOnlyStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc123") should equal ("123")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc123".toCharArray) should equal ("123".toCharArray)
				}
			}
		}
	}
}