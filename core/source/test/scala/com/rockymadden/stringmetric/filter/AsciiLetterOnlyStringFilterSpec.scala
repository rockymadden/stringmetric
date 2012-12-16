package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiLetterOnlyStringFilterSpec extends ScalaTest {
	private[this] val Filter = new StringFilterDelegate with AsciiLetterOnlyStringFilter

	"AsciiLetterOnlyStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-letters removed" in {
					Filter.filter("!@#$%^&*()abc") should equal ("abc")
					Filter.filter("!@#$%^&*()abc123") should equal ("abc")
					Filter.filter("abc!@#$%^&*()123") should equal ("abc")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-letters removed" in {
					Filter.filter("!@#$%^&*()abc".toCharArray) should equal ("abc".toCharArray)
					Filter.filter("!@#$%^&*()abc123".toCharArray) should equal ("abc".toCharArray)
					Filter.filter("abc!@#$%^&*()123".toCharArray) should equal ("abc".toCharArray)
				}
			}
		}
	}
}