package com.rockymadden.stringmetric.cli.phonetic

object refinednysiismetricSpec extends org.specs2.mutable.Specification {
	"refinednysiismetric main()" should {
		"print if they are a match with valid dashless arguments" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(refinednysiismetric.main(Array("--unitTest", "--debug", "abc", "abc")))
			out.toString must beEqualTo("true\n")
			out.reset()

			Console.withOut(out)(refinednysiismetric.main(Array("--unitTest", "--debug", "abc", "xyz")))
			out.toString must beEqualTo("false\n")
			out.reset()

			Console.withOut(out)(refinednysiismetric.main(Array("--unitTest", "--debug", "1", "1")))
			out.toString must beEqualTo("not comparable\n")
		}
		"throw IllegalArgumentException no dashless arguments" in {
			refinednysiismetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
