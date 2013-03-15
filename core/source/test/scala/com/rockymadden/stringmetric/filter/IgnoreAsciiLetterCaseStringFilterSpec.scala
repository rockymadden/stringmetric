package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class IgnoreAsciiLetterCaseStringFilterSpec extends ScalaTest {
	import IgnoreAsciiLetterCaseStringFilterSpec.Filter

	"IgnoreAsciiLetterCaseStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed case" should returns {
				"String with the same case" in {
					Filter.filter("HelloWorld") should (equal ("helloworld") or equal ("HELLOWORLD"))
					Filter.filter("Hello World") should (equal ("hello world") or equal ("HELLO WORLD"))
					Filter.filter("H e l l o W o r l d") should
						(equal ("h e l l o w o r l d") or equal ("H E L L O W O R L D"))
					Filter.filter("H  e  l  l  o  W  o  r  l  d") should
						(equal ("h  e  l  l  o  w  o  r  l  d") or equal ("H  E  L  L  O  W  O  R  L  D"))
				}
			}
			"character array with mixed case" should returns {
				"character array with the same case" in {
					Filter.filter("HelloWorld".toCharArray) should
						(equal ("helloworld".toCharArray) or equal ("HELLOWORLD".toCharArray))
					Filter.filter("Hello World".toCharArray) should
						(equal ("hello world".toCharArray) or equal ("HELLO WORLD".toCharArray))
					Filter.filter("H e l l o W o r l d".toCharArray) should
						(equal ("h e l l o w o r l d".toCharArray) or equal ("H E L L O W O R L D".toCharArray))
					Filter.filter("H  e  l  l  o  W  o  r  l  d".toCharArray) should
						(equal ("h  e  l  l  o  w  o  r  l  d".toCharArray) or equal ("H  E  L  L  O  W  O  R  L  D".toCharArray))
				}
			}
		}
	}
}

object IgnoreAsciiLetterCaseStringFilterSpec {
	private final val Filter = new StringFilterDelegate with IgnoreAsciiLetterCaseStringFilter
}
