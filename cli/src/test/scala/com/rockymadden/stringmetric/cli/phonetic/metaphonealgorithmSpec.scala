package com.rockymadden.stringmetric.cli.phonetic

object metaphonealgorithmSpec extends org.specs2.mutable.Specification {
	"metaphonealgorithm main()" should {
		"print phonetic representation with valid dashless argument" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(metaphonealgorithm.main(Array("--unitTest", "--debug", "abc")))
			out.toString must beEqualTo("abk\n")
			out.reset()

			Console.withOut(out)(metaphonealgorithm.main(Array("--unitTest", "--debug", "1")))
			out.toString must beEqualTo("not computable\n")
		}
		"throw IllegalArgumentException with no dashless argument" in {
			metaphonealgorithm.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
