package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiLetterNumberOnlyFilterSpec extends ScalaTest {
	import AsciiLetterNumberOnlyFilterSpec.Filter

	"AsciiLetterNumberOnlyFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-letters and non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc") should equal ("abc")
					Filter.filter("!@#$%^&*()abc123") should equal ("abc123")
					Filter.filter("abc123!@#$%^&*()") should equal ("abc123")
					Filter.filter("!@#$%abc123^&*()") should equal ("abc123")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-letters and non-numbers removed" in {
					Filter.filter("!@#$%^&*()abc".toCharArray) should equal ("abc".toCharArray)
					Filter.filter("!@#$%^&*()abc123".toCharArray) should equal ("abc123".toCharArray)
					Filter.filter("abc123!@#$%^&*()".toCharArray) should equal ("abc123".toCharArray)
					Filter.filter("!@#$%abc123^&*()".toCharArray) should equal ("abc123".toCharArray)
				}
			}
		}
	}
}

object AsciiLetterNumberOnlyFilterSpec {
	private final val Filter = new StringFilterDelegate with AsciiLetterNumberOnlyFilter
}
