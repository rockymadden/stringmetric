package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.transform._

object transformSpec extends org.specs2.mutable.SpecificationWithJUnit {
	"filterAlpha()" should {
		"return transformed" in {
			filterAlpha(
				("aBc123zZ" + 0x5B.toChar + 0x7B.toChar).toCharArray
			) must beEqualTo("aBczZ".toCharArray)
		}
	}

	"filterNotAlpha()" should {
		"return transformed" in {
			filterNotAlpha(
				("aBc123zZ" + 0x5B.toChar + 0x7B.toChar).toCharArray
			) must beEqualTo(
				("123" + 0x5B.toChar + 0x7B.toChar).toCharArray
			)
		}
	}

	"filterAlphaNumeric()" should {
		"return transformed" in {
			filterAlphaNumeric(
				("aBc123zZ9" + 0x3A.toChar + 0x5B.toChar + 0x7B.toChar).toCharArray
			) must beEqualTo("aBc123zZ9".toCharArray)
		}
	}

	"filterNotAlphaNumeric()" should {
		"return transformed" in {
			filterNotAlphaNumeric(
				("aBc123zZ9" + 0x3A.toChar + 0x5B.toChar + 0x7B.toChar).toCharArray
			) must beEqualTo(
				("" + 0x3A.toChar + 0x5B.toChar + 0x7B.toChar).toCharArray
			)
		}
	}

	"filterAscii()" should {
		"return transformed" in {
			filterAscii(
				("aBc" + 0x7F.toChar + 0x100.toChar).toCharArray
			) must beEqualTo(("aBc" + 0x7F.toChar).toCharArray)
		}
	}

	"filterNotAscii()" should {
		"return transformed" in {
			filterNotAscii(
				("aBc" + 0x7F.toChar + 0x100.toChar).toCharArray
			) must beEqualTo(
				("" + 0x100.toChar).toCharArray
			)
		}
	}

	"filterExtendedAscii()" should {
		"return transformed" in {
			filterExtendedAscii(
				("aBc" + 0x7F.toChar + 0x100.toChar).toCharArray
			) must beEqualTo(("aBc" + 0x7F.toChar).toCharArray)
		}
	}

	"filterNotExtendedAscii()" should {
		"return transformed" in {
			filterNotExtendedAscii(
				("aBc" + 0x7F.toChar + 0x250.toChar).toCharArray
			) must beEqualTo(
				("" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterLatin()" should {
		"return transformed" in {
			filterLatin(
				("aBc" + 0x24F.toChar + 0x250.toChar).toCharArray
			) must beEqualTo(("aBc" + 0x24F.toChar).toCharArray)
		}
	}

	"filterNotLatin()" should {
		"return transformed" in {
			filterNotLatin(
				("aBc" + 0x24F.toChar + 0x300.toChar).toCharArray
			) must beEqualTo(
				("" + 0x300.toChar).toCharArray
			)
		}
	}

	"filterLowerCase()" should {
		"return transformed" in {
			filterLowerCase(
				"aBc123z" + 0x250.toChar
			) must beEqualTo("acz".toCharArray)
		}
	}

	"filterNotLowerCase()" should {
		"return transformed" in {
			filterNotLowerCase(
				("aBc123z" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("B123" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterNumeric()" should {
		"return transformed" in {
			filterNumeric(
				("aBc1239" + 0x250.toChar).toCharArray
			) must beEqualTo("1239".toCharArray)
		}
	}

	"filterNotNumeric()" should {
		"return transformed" in {
			filterNotNumeric(
				("aBc1239" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("aBc" + 0x250.toChar).toCharArray
			)
		}
	}

	"filterUpperCase()" should {
		"return transformed" in {
			filterUpperCase(
				("aBc123Z" + 0x250.toChar).toCharArray
			) must beEqualTo("BZ".toCharArray)
		}
	}

	"filterNotUpperCase()" should {
		"return transformed" in {
			filterNotUpperCase(
				("aBc123Z" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("ac123" + 0x250.toChar).toCharArray
			)
		}
	}

	"ignoreAlphaCase()" should {
		"return transformed" in {
			ignoreAlphaCase(
				("aBc123zZ" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("abc123zz" + 0x250.toChar).toCharArray
			)
		}
	}
}
