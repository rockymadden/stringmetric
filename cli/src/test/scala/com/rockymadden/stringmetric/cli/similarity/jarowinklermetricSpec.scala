package com.rockymadden.stringmetric.cli.similarity

object jarowinklermetricSpec extends org.specs2.mutable.Specification {
	"jarowinklermetric main()" should {
		"print the distance with valid dashless arguments" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(jarowinklermetric.main(Array("--unitTest", "--debug", "abc", "abc")))
			out.toString must beEqualTo("1.0\n")
			out.reset()

			Console.withOut(out)(jarowinklermetric.main(Array("--unitTest", "--debug", "abc", "xyz")))
			out.toString must beEqualTo("0.0\n")
		}
		"throw IllegalArgumentException with no dashless arguments" in {
			jarowinklermetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
