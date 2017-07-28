package com.rockymadden.stringmetric.cli.similarity

object hammingmetricSpec extends org.specs2.mutable.Specification {
	"hammingmetric main()" should {
		"print if they are a match with valid dashless arguments" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(hammingmetric.main(Array("--unitTest", "--debug", "abc", "abc")))
			out.toString must beEqualTo("0\n")
			out.reset()

			Console.withOut(out)(hammingmetric.main(Array("--unitTest", "--debug", "abc", "xyz")))
			out.toString must beEqualTo("3\n")
		}
		"throw IllegalArgumentException with no dashless arguments" in {
			hammingmetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
