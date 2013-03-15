package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiSpaceStringFilterSpec extends ScalaTest {
	import AsciiSpaceStringFilterSpec.Filter

	"AsciiSpaceStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with spaces" should returns {
				"String with spaces removed" in {
					Filter.filter("HelloWorld") should equal ("HelloWorld")
					Filter.filter(" HelloWorld ") should equal ("HelloWorld")
					Filter.filter("Hello World") should equal ("HelloWorld")
					Filter.filter("H e l l o W o r l d") should equal ("HelloWorld")
					Filter.filter("H  e  l  l  o  W  o  r  l  d") should equal ("HelloWorld")
				}
			}
			"character array with spaces" should returns {
				"character array with spaces removed" in {
					Filter.filter("HelloWorld".toCharArray) should equal ("HelloWorld".toCharArray)
					Filter.filter(" HelloWorld ".toCharArray) should equal ("HelloWorld".toCharArray)
					Filter.filter("Hello World".toCharArray) should equal ("HelloWorld".toCharArray)
					Filter.filter("H e l l o W o r l d".toCharArray) should equal ("HelloWorld".toCharArray)
					Filter.filter("H  e  l  l  o  W  o  r  l  d".toCharArray) should equal ("HelloWorld".toCharArray)
				}
			}
		}
	}
}

object AsciiSpaceStringFilterSpec {
	private final val Filter = new StringFilterDelegate with AsciiSpaceStringFilter
}
