package com.rockymadden.stringmetric.cli

object PackageSpec extends org.specs2.mutable.Specification {
	"OptionMap apply()" should {
		"return populated Map with single valid double dashed option" in {
			val opts = OptionMap("--help")

			(opts('help): String) must beEqualTo("")
		}
		"return populated Map with multiple valid double dashed opts" in {
			val opts = OptionMap("--help", "--test=test")

			(opts('help): String) must beEqualTo("")
			(opts('test): String) must beEqualTo("test")
		}
		"return empty Map with invalid double dashed opts" in {
			val opts = OptionMap("--help#", "--test%=test")

			opts.keysIterator.length must beEqualTo(0)
		}
		"return populated Map with single valid single dashed option" in {
			val opts = OptionMap("-h")

			(opts('h): String) must beEqualTo("")
		}
		"return populated Map multiple valid single dashed opts" in {
			val opts = OptionMap("-h", "-i")

			(opts('h): String) must beEqualTo("")
			(opts('i): String) must beEqualTo("")
		}
		"return empty Map with invalid single dashed opts" in {
			val opts = OptionMap("-h-i", "-i#gloo")

			opts.keysIterator.length must beEqualTo(0)
		}
		"return single key populated Map with single nameless option" in {
			val opts = OptionMap("filename0")

			(opts('dashless): String).count(_ == ' ') must beEqualTo(0)
		}
		"return single key populated Map with multiple single nameless opts" in {
			val opts = OptionMap("filename0", "filename1", "filename2")

			(opts('dashless): String).count(_ == ' ') must beEqualTo(2)
		}
		"return populated Map with mixed opts" in {
			val opts = OptionMap("-q", "--help", "--test=test", "-go", "filename0", "filename1", "filename2")

			(opts('q): String) must beEqualTo("")
			(opts('help): String) must beEqualTo("")
			(opts('test): String) must beEqualTo("test")
			(opts('go): String) must beEqualTo("")
			(opts('dashless): String).count(_ == ' ') must beEqualTo(2)
		}
	}
}
