package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class StringCleanerDelegateSpec extends ScalaTest {
	private final val Cleaner = new StringCleanerDelegate

	"StringCleanerDelegate" should provide {
		"overloaded clean method" when passed {
			"String" should returns {
				"the same String" in {
					Cleaner.clean("Hello World") should equal ("Hello World")
				}
			}
			"character array" should returns {
				"the same character array" in {
					Cleaner.clean("Hello World".toCharArray) should equal ("Hello World".toCharArray)
				}
			}
		}
	}
}