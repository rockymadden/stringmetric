package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiLetterOnlyStringCleanerSpec extends ScalaTest {
	private final val Cleaner = new StringCleanerDelegate with AsciiLetterOnlyStringCleaner

	"AsciiLetterOnlyStringCleaner" should provide {
		"overloaded clean method" when passed {
			"String with mixed characters" should returns {
				"String with non-letters removed" in {
					Cleaner.clean("!@#$%^&*()abc") should equal ("abc")
					Cleaner.clean("!@#$%^&*()abc123") should equal ("abc")
				}
			}
			"character array with mixed characters" should returns {
				"character array with non-letters removed" in {
					Cleaner.clean("!@#$%^&*()abc".toCharArray) should equal ("abc".toCharArray)
					Cleaner.clean("!@#$%^&*()abc123".toCharArray) should equal ("abc".toCharArray)
				}
			}
		}
	}
}