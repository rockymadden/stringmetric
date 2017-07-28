package com.rockymadden.stringmetric.cli.phonetic

object refinednysiisalgorithmSpec extends org.specs2.mutable.Specification {
	"refinednysiisalgorithm main()" should {
		"print phonetic representation with valid dashless argument" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(refinednysiisalgorithm.main(Array("--unitTest", "--debug", "abc")))
			out.toString must beEqualTo("abc\n")
			out.reset()

			Console.withOut(out)(refinednysiisalgorithm.main(Array("--unitTest", "--debug", "1")))
			out.toString must beEqualTo("not computable\n")
		}
		"throw IllegalArgumentException with no dashless argument" in {
			refinednysiisalgorithm.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
