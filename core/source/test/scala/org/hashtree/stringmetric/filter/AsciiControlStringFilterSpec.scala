package org.hashtree.stringmetric.filter

import org.hashtree.stringmetric.ScalaTest
import org.hashtree.stringmetric.StringFilterDelegate
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiControlStringFilterSpec extends ScalaTest {
	private final val Filter = new StringFilterDelegate with AsciiControlStringFilter

	"AsciiControlStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with controls" should returns {
				"String with controls removed" in {
					Filter.filter("	HelloWorld") should equal ("HelloWorld")
				}
			}
			"character array with controls" should returns {
				"character array with controls removed" in {
					Filter.filter("	HelloWorld".toCharArray) should equal ("HelloWorld".toCharArray)
				}
			}
		}
	}
}