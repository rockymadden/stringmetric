package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class overlapmetricSpec extends ScalaTest { "overlapmetric" should provide {
	"main method" when passed {
		"valid dashless arguments" should executes {
			"print if they are a match" in {
				val out = new java.io.ByteArrayOutputStream()

				Console.withOut(out)(
					overlapmetric.main(Array("--unitTest", "--debug", "--n=2", "abc", "abc"))
				)

				out.toString should equal ("1.0\n")
				out.reset()

				Console.withOut(out)(
					overlapmetric.main(Array("--unitTest", "--debug", "--n=2", "abc", "xyz"))
				)

				out.toString should equal ("0.0\n")
				out.reset()
			}
		}
		"no dashless arguments" should throws {
			"IllegalArgumentException" in {
				evaluating {
					overlapmetric.main(Array("--unitTest", "--debug"))
				} should produce [IllegalArgumentException]
			}
		}
	}
}}
