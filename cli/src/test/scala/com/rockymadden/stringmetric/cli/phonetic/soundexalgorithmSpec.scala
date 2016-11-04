package com.rockymadden.stringmetric.cli.phonetic

object soundexalgorithmSpec extends org.specs2.mutable.Specification {
	"soundexalgorithm main()" should {
		"print phonetic representation with valid dashless argument" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(soundexalgorithm.main(Array("--unitTest", "--debug", "abc")))
			out.toString must beEqualTo("a120\n")
			out.reset()

			Console.withOut(out)(soundexalgorithm.main(Array("--unitTest", "--debug", "1")))
			out.toString must beEqualTo("not computable\n")
		}
		"throw IllegalArgumentException no dashless argument" in {
			soundexalgorithm.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
