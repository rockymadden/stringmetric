package com.rockymadden.stringmetric.cli.phonetic

object metaphonemetricSpec extends org.specs2.mutable.Specification {
	"metaphonemetric main()" should {
		"print if they are a match with valid dashless arguments" in {
			val out = new java.io.ByteArrayOutputStream()

			Console.withOut(out)(metaphonemetric.main(Array("--unitTest", "--debug", "abc", "abc")))
			out.toString must beEqualTo("true\n")
			out.reset()

			Console.withOut(out)(metaphonemetric.main(Array("--unitTest", "--debug", "abc", "xyz")))
			out.toString must beEqualTo("false\n")
			out.reset()

			Console.withOut(out)(metaphonemetric.main(Array("--unitTest", "--debug", "1", "1")))
			out.toString must beEqualTo("not comparable\n")
		}
		"throw IllegalArgumentException with no dashless arguments" in {
			metaphonemetric.main(Array("--unitTest", "--debug")) must throwA[IllegalArgumentException]
		}
	}
}
