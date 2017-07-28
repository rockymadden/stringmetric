package com.rockymadden.stringmetric.cli.similarity

object ratcliffobershelpmetricSpec extends org.specs2.mutable.Specification {
	"ratcliffobershelpmetric main()" should {
		"print if they are a match with valid dashless arguments" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(ratcliffobershelpmetric.main(Array("--unitTest", "--debug", "abc", "abc")))
			out.toString must beEqualTo("1.0\n")
			out.reset()

			Console.withOut(out)(ratcliffobershelpmetric.main(Array("--unitTest", "--debug", "abc", "xyz")))
			out.toString must beEqualTo("0.0\n")
		}
		"throw IllegalArgumentException with no dashless arguments" in {
			ratcliffobershelpmetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
