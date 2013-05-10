package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class hammingmetricSpec extends ScalaTest {
	"hammingmetric" should provide {
		"main method" when passed {
			"valid dashless arguments" should executes {
				"print if they are a match" in {
					val out = new java.io.ByteArrayOutputStream()

					Console.withOut(out)(
						hammingmetric.main(Array("--unitTest", "--debug", "abc", "abc"))
					)

					out.toString should equal ("0\n")
					out.reset()

					Console.withOut(out)(
						hammingmetric.main(Array("--unitTest", "--debug", "abc", "xyz"))
					)

					out.toString should equal ("3\n")
					out.reset()
				}
			}
			"no dashless arguments" should throws {
				"IllegalArgumentException" in {
					evaluating {
						hammingmetric.main(Array("--unitTest", "--debug"))
					} should produce [IllegalArgumentException]
				}
			}
		}
	}
}
