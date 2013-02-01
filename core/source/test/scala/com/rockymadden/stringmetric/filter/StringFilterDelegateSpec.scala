package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class StringFilterDelegateSpec extends ScalaTest {
	import StringFilterDelegateSpec.Filter

	"StringFilterDelegate" should provide {
		"overloaded filter method" when passed {
			"String" should returns {
				"the same String" in {
					Filter.filter("Hello World") should equal ("Hello World")
					Filter.filter("	Hello! World]") should equal ("	Hello! World]")
				}
			}
			"character array" should returns {
				"the same character array" in {
					Filter.filter("Hello World".toCharArray) should equal ("Hello World".toCharArray)
					Filter.filter("	Hello! World]".toCharArray) should equal ("	Hello! World]".toCharArray)
				}
			}
		}
	}
}

object StringFilterDelegateSpec {
	private final val Filter = new StringFilterDelegate
}
