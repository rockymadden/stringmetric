package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class StringFilterDelegateSpec extends ScalaTest {
	private final val Filter = new StringFilterDelegate

	"StringFilterDelegate" should provide {
		"overloaded filter method" when passed {
			"String" should returns {
				"the same String" in {
					Filter.filter("Hello World") should equal ("Hello World")
				}
			}
			"character array" should returns {
				"the same character array" in {
					Filter.filter("Hello World".toCharArray) should equal ("Hello World".toCharArray)
				}
			}
		}
	}
}