package com.rockymadden.stringmetric.cli.similarity

object weightedlevenshteinmetricSpec extends org.specs2.mutable.Specification {
	"weightedlevenshteinmetric main()" should {
		"print if they are a match with valid dashless arguments and valid weight arguments" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(weightedlevenshteinmetric.main(
				Array(
					"--unitTest",
					"--debug",
					"--deleteWeight=1",
					"--insertWeight=1",
					"--substituteWeight=1",
					"abc",
					"abc"
				)
			))
			out.toString must beEqualTo("0.0\n")
			out.reset()

			Console.withOut(out)(weightedlevenshteinmetric.main(
				Array(
					"--unitTest",
					"--debug",
					"--deleteWeight=2",
					"--insertWeight=2",
					"--substituteWeight=1",
					"abc",
					"xyz"
				)
			))
			out.toString must beEqualTo("3.0\n")
			out.reset()

			Console.withOut(out)(weightedlevenshteinmetric.main(
				Array(
					"--unitTest",
					"--debug",
					"--deleteWeight=2",
					"--insertWeight=1",
					"--substituteWeight=2",
					"xyz",
					"xyzxyz"
				)
			))
			out.toString must beEqualTo("3.0\n")
			out.reset()

			Console.withOut(out)(weightedlevenshteinmetric.main(
				Array(
					"--unitTest",
					"--debug",
					"--deleteWeight=1",
					"--insertWeight=2",
					"--substituteWeight=2",
					"xyzxyz",
					"xyz"
				)
			))
			out.toString must beEqualTo("3.0\n")
		}
		"throw IllegalArgumentException with valid dashless arguments but invalid weight arguments" in {
			weightedlevenshteinmetric.main(
				Array(
					"--unitTest",
					"--debug",
					"--deleteWeight=1",
					"--substituteWeight=1",
					"abc",
					"abc"
				)
			) must throwA[IllegalArgumentException]

			weightedlevenshteinmetric.main(
				Array(
					"--unitTest",
					"--debug",
					"--deleteWeight=1",
					"--insertWeight=q",
					"--substituteWeight=1",
					"abc",
					"abc"
				)
			) must throwA[IllegalArgumentException]
		}
		"throw IllegalArgumentException with no dashless arguments" in {
			weightedlevenshteinmetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
