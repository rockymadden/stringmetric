package com.rockymadden.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class TransformSpec extends ScalaTest { "StringTransform" should provide {
	import com.rockymadden.stringmetric.Transform._

	"filterAlpha()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterAlpha(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal ("aBc".toCharArray)
			}
		}
	}
	"filterNotAlpha()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotAlpha(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal (
					("123" + 0x250.toChar).toCharArray
				)
			}
		}
	}
	"filterAlphaNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterAlphaNumeric(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal ("aBc123".toCharArray)
			}
		}
	}
	"filterNotAlphaNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotAlphaNumeric(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal (
					("" + 0x250.toChar).toCharArray
				)
			}
		}
	}
	"filterAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterAscii(
					("aBc" + 0x80.toChar).toCharArray
				) should equal ("aBc".toCharArray)
			}
		}
	}
	"filterNotAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotAscii(
					("aBc" + 0x100.toChar).toCharArray
				) should equal (
					("" + 0x100.toChar).toCharArray
				)
			}
		}
	}
	"filterExtendedAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterExtendedAscii(
					("aBc" + 0x100.toChar).toCharArray
				) should equal ("aBc".toCharArray)
			}
		}
	}
	"filterNotExtendedAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotExtendedAscii(
					("aBc" + 0x250.toChar).toCharArray
				) should equal (
					("" + 0x250.toChar).toCharArray
				)
			}
		}
	}
	"filterLatin()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterLatin(
					("aBc" + 0x250.toChar).toCharArray
				) should equal ("aBc".toCharArray)
			}
		}
	}
	"filterNotLatin()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotLatin(
					("aBc" + 0x300.toChar).toCharArray
				) should equal (
					("" + 0x300.toChar).toCharArray
				)
			}
		}
	}
	"filterLowerCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterLowerCase(
					"aBc123" + 0x250.toChar
				) should equal ("ac".toCharArray)
			}
		}
	}
	"filterNotLowerCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotLowerCase(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal (
					("B123" + 0x250.toChar).toCharArray
				)
			}
		}
	}
	"filterNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNumeric(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal ("123".toCharArray)
			}
		}
	}
	"filterNotNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotNumeric(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal (
					("aBc" + 0x250.toChar).toCharArray
				)
			}
		}
	}
	"filterUpperCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterUpperCase(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal ("B".toCharArray)
			}
		}
	}
	"filterNotUpperCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotUpperCase(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal (
					("ac123" + 0x250.toChar).toCharArray
				)
			}
		}
	}
	"ignoreAlphaCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.ignoreAlphaCase(
					("aBc123" + 0x250.toChar).toCharArray
				) should equal (
					("abc123" + 0x250.toChar).toCharArray
				)
			}
		}
	}
}}
