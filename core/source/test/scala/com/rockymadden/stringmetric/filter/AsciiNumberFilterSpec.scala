package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiNumberFilterSpec extends ScalaTest {
	import AsciiNumberFilterSpec.Filter

	"AsciiNumberFilter" should provide {
		"overloaded filter method" when passed {
			"String with numbers" should returns {
				"String with numbers removed" in {
					Filter.filter("	Hello123World!") should equal ("	HelloWorld!")
					Filter.filter("123	HelloWorld!") should equal ("	HelloWorld!")
					Filter.filter("	HelloWorld!123") should equal ("	HelloWorld!")
				}
			}
			"character array with numbers" should returns {
				"character array with numbers removed" in {
					Filter.filter("	Hello123World!".toCharArray) should equal ("	HelloWorld!".toCharArray)
					Filter.filter("123	HelloWorld!".toCharArray) should equal ("	HelloWorld!".toCharArray)
					Filter.filter("	HelloWorld!123".toCharArray) should equal ("	HelloWorld!".toCharArray)
				}
			}
		}
	}
}

object AsciiNumberFilterSpec {
	private final val Filter = new StringFilterDelegate with AsciiNumberFilter
}
