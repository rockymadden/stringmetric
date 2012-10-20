package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AsciiCaseStringCleanerSpec extends ScalaTest {
	private final val Cleaner = new StringCleanerDelegate with AsciiCaseStringCleaner

	"AsciiCaseStringCleaner" should provide {
		"overloaded clean method" when passed {
			"String with mixed case" should returns {
				"String with the same case" in {
					Cleaner.clean("HelloWorld") should (equal ("helloworld") or equal ("HELLOWORLD"))
					Cleaner.clean("Hello World") should (equal ("hello world") or equal ("HELLO WORLD"))
					Cleaner.clean("H e l l o W o r l d") should
						(equal ("h e l l o w o r l d") or equal ("H E L L O W O R L D"))
					Cleaner.clean("H  e  l  l  o  W  o  r  l  d") should
						(equal ("h  e  l  l  o  w  o  r  l  d") or equal ("H  E  L  L  O  W  O  R  L  D"))
				}
			}
			"character array with mixed case" should returns {
				"character array with the same case" in {
					Cleaner.clean("HelloWorld".toCharArray) should
						(equal ("helloworld".toCharArray) or equal ("HELLOWORLD".toCharArray))
					Cleaner.clean("Hello World".toCharArray) should
						(equal ("hello world".toCharArray) or equal ("HELLO WORLD".toCharArray))
					Cleaner.clean("H e l l o W o r l d".toCharArray) should
						(equal ("h e l l o w o r l d".toCharArray) or equal ("H E L L O W O R L D".toCharArray))
					Cleaner.clean("H  e  l  l  o  W  o  r  l  d".toCharArray) should
						(equal ("h  e  l  l  o  w  o  r  l  d".toCharArray) or equal ("H  E  L  L  O  W  O  R  L  D".toCharArray))
				}
			}
		}
	}
}