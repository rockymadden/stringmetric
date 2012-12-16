package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiLetterStringFilterSpec extends ScalaTest {
	private[this] val Filter = new StringFilterDelegate with AsciiLetterStringFilter

	"AsciiLetterStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with letters" should returns {
				"String with letters removed" in {
					Filter.filter("	Hello123World!") should equal ("	123!")
				}
			}
			"character array with letters" should returns {
				"character array with letters removed" in {
					Filter.filter("	Hello123World!".toCharArray) should equal ("	123!".toCharArray)
				}
			}
		}
	}
}