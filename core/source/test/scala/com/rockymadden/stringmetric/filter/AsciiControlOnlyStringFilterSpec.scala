package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiControlOnlyStringFilterSpec extends ScalaTest {
	private[this] val Filter = new StringFilterDelegate with AsciiControlOnlyStringFilter

	"AsciiControlOnlyStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-controls removed" in {
					Filter.filter("!@#$%	^&*()abc") should equal ("	")
					Filter.filter("	^&*()abc") should equal ("	")
					Filter.filter("%^&*()abc	") should equal ("	")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-controls removed" in {
					Filter.filter("!@#$%	^&*()abc".toCharArray) should equal ("	".toCharArray)
					Filter.filter("	^&*()abc".toCharArray) should equal ("	".toCharArray)
					Filter.filter("%^&*()abc	".toCharArray) should equal ("	".toCharArray)
				}
			}
		}
	}
}