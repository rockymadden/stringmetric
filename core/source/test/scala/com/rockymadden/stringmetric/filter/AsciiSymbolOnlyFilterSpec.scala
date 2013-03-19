package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiSymbolOnlyFilterSpec extends ScalaTest {
	import AsciiSymbolOnlyFilterSpec.Filter

	"AsciiSymbolOnlyFilter" should provide {
		"overloaded filter method" when passed {
			"String with mixed characters" should returns {
				"String with non-symbols removed" in {
					Filter.filter("!@#$%^&*()abc123") should equal ("!@#$%^&*()")
					Filter.filter("abc123!@#$%^&*()") should equal ("!@#$%^&*()")
					Filter.filter("!@#$%abc123^&*()") should equal ("!@#$%^&*()")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-symbols removed" in {
					Filter.filter("!@#$%^&*()abc123".toCharArray) should equal ("!@#$%^&*()".toCharArray)
					Filter.filter("abc123!@#$%^&*()".toCharArray) should equal ("!@#$%^&*()".toCharArray)
					Filter.filter("!@#$%abc123^&*()".toCharArray) should equal ("!@#$%^&*()".toCharArray)
				}
			}
		}
	}
}

object AsciiSymbolOnlyFilterSpec {
	private final val Filter = new StringFilterDelegate with AsciiSymbolOnlyFilter
}
