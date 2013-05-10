package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class ngrammetricSpec extends ScalaTest {
	"ngrammetric" should provide {
		"main method" when passed {
			"valid dashless arguments and valid n argument" should executes {
				"print if they are a match" in {
					val out = new java.io.ByteArrayOutputStream()

					Console.withOut(out)(
						ngrammetric.main(
							Array(
								"--unitTest",
								"--debug",
								"--n=1",
								"abc",
								"abc"
							)
						)
					)

					out.toString should equal ("1.0\n")
					out.reset()

					Console.withOut(out)(
						ngrammetric.main(
							Array(
								"--unitTest",
								"--debug",
								"--n=1",
								"abc",
								"xyz"
							)
						)
					)

					out.toString should equal ("0.0\n")
					out.reset()
				}
			}
			"valid dashless arguments and invalid n argument" should throws {
				"IllegalArgumentException" in {
					evaluating {
						ngrammetric.main(
							Array(
								"--unitTest",
								"abc",
								"abc"
							)
						)
					} should produce [IllegalArgumentException]
				}
			}
			"no dashless arguments" should throws {
				"IllegalArgumentException" in {
					evaluating {
						ngrammetric.main(Array("--unitTest", "--debug"))
					} should produce [IllegalArgumentException]
				}
			}
		}
	}
}
