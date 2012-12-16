package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiControlStringFilterSpec extends ScalaTest {
	private[this] val Filter = new StringFilterDelegate with AsciiControlStringFilter

	"AsciiControlStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with controls" should returns {
				"String with controls removed" in {
					Filter.filter("	HelloWorld") should equal ("HelloWorld")
					Filter.filter("HelloWorld	") should equal ("HelloWorld")
					Filter.filter("Hello	World") should equal ("HelloWorld")
				}
			}
			"character array with controls" should returns {
				"character array with controls removed" in {
					Filter.filter("	HelloWorld".toCharArray) should equal ("HelloWorld".toCharArray)
					Filter.filter("HelloWorld	".toCharArray) should equal ("HelloWorld".toCharArray)
					Filter.filter("Hello	World".toCharArray) should equal ("HelloWorld".toCharArray)
				}
			}
		}
	}
}