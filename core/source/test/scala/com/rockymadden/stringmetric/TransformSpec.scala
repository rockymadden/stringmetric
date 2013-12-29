package com.rockymadden.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class TransformSpec extends ScalaTest { "StringTransform" should provide {
	import com.rockymadden.stringmetric.Transform._

	"filterAlpha()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterAlpha("aBc123" + 0x250.toChar) should be ("aBc")
			}
		}
	}
	"filterNotAlpha()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotAlpha("aBc123" + 0x250.toChar) should be ("123" + 0x250.toChar)
			}
		}
	}
	"filterAlphaNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterAlphaNumeric("aBc123" + 0x250.toChar) should be ("aBc123")
			}
		}
	}
	"filterNotAlphaNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotAlphaNumeric("aBc123" + 0x250.toChar) should be ("" + 0x250.toChar)
			}
		}
	}
	"filterAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterAscii("aBc" + 0x80.toChar) should be ("aBc")
			}
		}
	}
	"filterNotAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotAscii("aBc" + 0x100.toChar) should be ("" + 0x100.toChar)
			}
		}
	}
	"filterExtendedAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterExtendedAscii("aBc" + 0x100.toChar) should be ("aBc")
			}
		}
	}
	"filterNotExtendedAscii()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotExtendedAscii("aBc" + 0x250.toChar) should be ("" + 0x250.toChar)
			}
		}
	}
	"filterLatin()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterLatin("aBc" + 0x250.toChar) should be ("aBc")
			}
		}
	}
	"filterNotLatin()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotLatin("aBc" + 0x300.toChar) should be ("" + 0x300.toChar)
			}
		}
	}
	"filterLowerCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterLowerCase("aBc123" + 0x250.toChar) should be ("ac")
			}
		}
	}
	"filterNotLowerCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotLowerCase("aBc123" + 0x250.toChar) should be ("B123" + 0x250.toChar)
			}
		}
	}
	"filterNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNumeric("aBc123" + 0x250.toChar) should be ("123")
			}
		}
	}
	"filterNotNumeric()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotNumeric("aBc123" + 0x250.toChar) should be ("aBc" + 0x250.toChar)
			}
		}
	}
	"filterUpperCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterUpperCase("aBc123" + 0x250.toChar) should be ("B")
			}
		}
	}
	"filterNotUpperCase()" when passed {
		"String" should returns {
			"transformed String" in {
				StringTransform.filterNotUpperCase("aBc123" + 0x250.toChar) should be ("ac123" + 0x250.toChar)
			}
		}
	}
}}
