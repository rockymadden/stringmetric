package com.rockymadden.stringmetric

object TransformSpec extends org.specs2.mutable.SpecificationWithJUnit {
	import Transform._

	"StringTransform filterAlpha()" should {
		"return transformed" in {
			StringTransform.filterAlpha(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"StringTransform filterNotAlpha()" should {
		"return transformed" in {
			StringTransform.filterNotAlpha(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("123" + 0x250.toChar).toCharArray
			)
		}
	}

	"StringTransform filterAlphaNumeric()" should {
		"return transformed" in {
			StringTransform.filterAlphaNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("aBc123".toCharArray)
		}
	}

	"StringTransform filterNotAlphaNumeric()" should {
		"return transformed" in {
			StringTransform.filterNotAlphaNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("" + 0x250.toChar).toCharArray
			)
		}
	}

	"StringTransform filterAscii()" should {
		"return transformed" in {
			StringTransform.filterAscii(
				("aBc" + 0x80.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"StringTransform filterNotAscii()" should {
		"return transformed" in {
			StringTransform.filterNotAscii(
				("aBc" + 0x100.toChar).toCharArray
			) must beEqualTo(
				("" + 0x100.toChar).toCharArray
			)
		}
	}

	"StringTransform filterExtendedAscii()" should {
		"return transformed" in {
			StringTransform.filterExtendedAscii(
				("aBc" + 0x100.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"StringTransform filterNotExtendedAscii()" should {
		"return transformed" in {
			StringTransform.filterNotExtendedAscii(
				("aBc" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("" + 0x250.toChar).toCharArray
			)
		}
	}

	"StringTransform filterLatin()" should {
		"return transformed" in {
			StringTransform.filterLatin(
				("aBc" + 0x250.toChar).toCharArray
			) must beEqualTo("aBc".toCharArray)
		}
	}

	"StringTransform filterNotLatin()" should {
		"return transformed" in {
			StringTransform.filterNotLatin(
				("aBc" + 0x300.toChar).toCharArray
			) must beEqualTo(
				("" + 0x300.toChar).toCharArray
			)
		}
	}

	"StringTransform filterLowerCase()" should {
		"return transformed" in {
			StringTransform.filterLowerCase(
				"aBc123" + 0x250.toChar
			) must beEqualTo("ac".toCharArray)
		}
	}

	"StringTransform filterNotLowerCase()" should {
		"return transformed" in {
			StringTransform.filterNotLowerCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("B123" + 0x250.toChar).toCharArray
			)
		}
	}

	"StringTransform filterNumeric()" should {
		"return transformed" in {
			StringTransform.filterNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("123".toCharArray)
		}
	}

	"StringTransform filterNotNumeric()" should {
		"return transformed" in {
			StringTransform.filterNotNumeric(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("aBc" + 0x250.toChar).toCharArray
			)
		}
	}

	"StringTransform filterUpperCase()" should {
		"return transformed" in {
			StringTransform.filterUpperCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo("B".toCharArray)
		}
	}

	"StringTransform filterNotUpperCase()" should {
		"return transformed" in {
			StringTransform.filterNotUpperCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("ac123" + 0x250.toChar).toCharArray
			)
		}
	}

	"StringTransform ignoreAlphaCase()" should {
		"return transformed" in {
			StringTransform.ignoreAlphaCase(
				("aBc123" + 0x250.toChar).toCharArray
			) must beEqualTo(
				("abc123" + 0x250.toChar).toCharArray
			)
		}
	}
}
