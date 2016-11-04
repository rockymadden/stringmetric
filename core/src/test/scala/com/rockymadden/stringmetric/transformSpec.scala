package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.transform._

object transformSpec extends org.specs2.mutable.Specification {
	"filterAlpha()" should {
		"return transformed" in {
			filterAlpha(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"filterNotAlpha()" should {
		"return transformed" in {
			filterNotAlpha(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("123" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterAlphaNumeric()" should {
		"return transformed" in {
			filterAlphaNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("aBc123".toCharArray)
		}
	}

	"filterNotAlphaNumeric()" should {
		"return transformed" in {
			filterNotAlphaNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterAscii()" should {
		"return transformed" in {
			filterAscii(
				("aBc" + 0x80.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"filterNotAscii()" should {
		"return transformed" in {
			filterNotAscii(
				("aBc" + 0x100.toChar).toCharArray
			) must beEqualTo(
				("" + 0x100.toChar).toCharArray
			)
		}
	}

	"filterExtendedAscii()" should {
		"return transformed" in {
			filterExtendedAscii(
				("aBc" + 0x100.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"filterNotExtendedAscii()" should {
		"return transformed" in {
			filterNotExtendedAscii(
				("aBc" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterLatin()" should {
		"return transformed" in {
			filterLatin(
				("aBc" + 0x250.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"filterNotLatin()" should {
		"return transformed" in {
			filterNotLatin(
				("aBc" + 0x300.toChar).toCharArray
			) must beEqualTo(
				("" + 0x300.toChar).toCharArray
			)
		}
	}

	"filterLowerCase()" should {
		"return transformed" in {
			filterLowerCase(
				"aBc123" + 0x250.toChar
			) must beEqualTo("ac".toCharArray)
		}
	}

	"filterNotLowerCase()" should {
		"return transformed" in {
			filterNotLowerCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("B123" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterNumeric()" should {
		"return transformed" in {
			filterNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("123".toCharArray)
		}
	}

	"filterNotNumeric()" should {
		"return transformed" in {
			filterNotNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("aBc" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterUpperCase()" should {
		"return transformed" in {
			filterUpperCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("B".toCharArray)
		}
	}

	"filterNotUpperCase()" should {
		"return transformed" in {
			filterNotUpperCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("ac123" + 0x250.toChar).toCharArray
			)
		}
	}

	"ignoreAlphaCase()" should {
		"return transformed" in {
			ignoreAlphaCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("abc123" + 0x250.toChar).toCharArray
			)
		}
	}
}
