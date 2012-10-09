package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SpaceStringCleanerSpec extends ScalaTest {
	private final val Cleaner = new StringCleanerDelegate with SpaceStringCleaner

	"SpaceStringCleaner" should provide {
		"overloaded clean method" when passed {
			"String with spaces" should returns {
				"String with spaces removed" in {
					Cleaner.clean("HelloWorld") should equal ("HelloWorld")
					Cleaner.clean(" HelloWorld ") should equal ("HelloWorld")
					Cleaner.clean("Hello World") should equal ("HelloWorld")
					Cleaner.clean("H e l l o W o r l d") should equal ("HelloWorld")
					Cleaner.clean("H  e  l  l  o  W  o  r  l  d") should equal ("HelloWorld")
				}
			}
			"character array with spaces" should returns {
				"character array with spaces removed" in {
					Cleaner.clean("HelloWorld".toCharArray) should equal ("HelloWorld".toCharArray)
					Cleaner.clean(" HelloWorld ".toCharArray) should equal ("HelloWorld".toCharArray)
					Cleaner.clean("Hello World".toCharArray) should equal ("HelloWorld".toCharArray)
					Cleaner.clean("H e l l o W o r l d".toCharArray) should equal ("HelloWorld".toCharArray)
					Cleaner.clean("H  e  l  l  o  W  o  r  l  d".toCharArray) should equal ("HelloWorld".toCharArray)
				}
			}
		}
	}
}