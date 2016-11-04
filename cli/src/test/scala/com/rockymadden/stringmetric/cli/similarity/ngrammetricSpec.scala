package com.rockymadden.stringmetric.cli.similarity

object ngrammetricSpec extends org.specs2.mutable.Specification {
	"ngrammetric main()" should {
		"print if they are a match with valid dashless arguments and valid n argument" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(ngrammetric.main(Array("--unitTest", "--debug", "--n=1", "abc", "abc")))
			out.toString must beEqualTo("1.0\n")
			out.reset()

			Console.withOut(out)(ngrammetric.main(Array("--unitTest", "--debug", "--n=1", "abc", "xyz")))
			out.toString must beEqualTo("0.0\n")
		}
		"throw IllegalArgumentException with valid dashless arguments but invalid n argument" in {
			ngrammetric.main(Array("--unitTest", "abc", "abc")) must throwA[IllegalArgumentException]
		}
		"throw IllegalArgumentException with no dashless arguments" in {
			ngrammetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
