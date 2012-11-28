package org.hashtree.stringmetric.filter

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiSymbolOnlyStringFilterSpec extends ScalaTest {
	private[this] val Filter = new StringFilterDelegate with AsciiSymbolOnlyStringFilter

	"AsciiSymbolOnlyStringFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-symbols removed" in {
					Filter.filter("!@#$%^&*()abc123") should equal ("!@#$%^&*()")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-symbols removed" in {
					Filter.filter("!@#$%^&*()abc123".toCharArray) should equal ("!@#$%^&*()".toCharArray)
				}
			}
		}
	}
}