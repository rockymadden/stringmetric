package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiSymbolFilterSpec extends ScalaTest {
	import AsciiSymbolFilterSpec.Filter

	"AsciiSymbolFilter" should provide {
		"overloaded filter method" when passed {
			"String with symbols" should returns {
				"String with symbols removed" in {
					Filter.filter("[HelloWorld]") should equal ("HelloWorld")
					Filter.filter("Hello!World") should equal ("HelloWorld")
				}
			}
			"character array with symbols" should returns {
				"character array with symbols removed" in {
					Filter.filter("[HelloWorld]".toCharArray) should equal ("HelloWorld".toCharArray)
					Filter.filter("Hello!World".toCharArray) should equal ("HelloWorld".toCharArray)
				}
			}
		}
	}
}

object AsciiSymbolFilterSpec {
	private final val Filter = new StringFilterDelegate with AsciiSymbolFilter
}
