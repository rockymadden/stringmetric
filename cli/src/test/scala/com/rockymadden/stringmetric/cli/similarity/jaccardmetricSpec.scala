package com.rockymadden.stringmetric.cli.similarity

object jaccardmetricSpec extends org.specs2.mutable.Specification {
	"jaccardmetric main()" should {
		"print if they are a match with valid dashless arguments" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(jaccardmetric.main(Array("--unitTest", "--debug", "--n=2", "abc", "abc")))
			out.toString must beEqualTo("1.0\n")
			out.reset()

			Console.withOut(out)(jaccardmetric.main(Array("--unitTest", "--debug", "--n=2", "abc", "xyz")))
			out.toString must beEqualTo("0.0\n")
		}
		"throw IllegalArgumentException with no dashless arguments" in {
			jaccardmetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
