package org.hashtree.stringmetric.filter

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiSymbolStringFilterSpec extends ScalaTest {
	private[this] val Filter = new StringFilterDelegate with AsciiSymbolStringFilter

	"AsciiSymbolStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with symbols" should returns {
				"String with symbols removed" in {
					Filter.filter("[HelloWorld]") should equal ("HelloWorld")
				}
			}
			"character array with symbols" should returns {
				"character array with symbols removed" in {
					Filter.filter("[HelloWorld]".toCharArray) should equal ("HelloWorld".toCharArray)
				}
			}
		}
	}
}