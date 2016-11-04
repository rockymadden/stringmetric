package com.rockymadden.stringmetric.cli.phonetic

object nysiisalgorithmSpec extends org.specs2.mutable.Specification {
	"nysiisalgorithm main()" should {
		"print phonetic representation with valid dashless argument" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(nysiisalgorithm.main(Array("--unitTest", "--debug", "abc")))
			out.toString must beEqualTo("abc\n")
			out.reset()

			Console.withOut(out)(nysiisalgorithm.main(Array("--unitTest", "--debug", "1")))
			out.toString must beEqualTo("not computable\n")
		}
		"throw IllegalArgumentException with no dashless argument" in {
			nysiisalgorithm.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
