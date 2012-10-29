package org.hashtree.stringmetric.cli.command

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class soundexAlgorithmSpec extends ScalaTest {
	"soundexAlgorithm" should provide {
		"main method" when passed {
			"valid dashless argument" should executes {
				"print phonetic representation" in {
					val out = new java.io.ByteArrayOutputStream()

					Console.withOut(out)(
						soundexAlgorithm.main(Array("--unitTest", "--debug", "aBc"))
					)

					out.toString should equal ("a120\n")
					out.reset()

					Console.withOut(out)(
						soundexAlgorithm.main(Array("--unitTest", "--debug", "1"))
					)

					out.toString should equal ("not computable\n")
					out.reset()
				}
			}
			"no dashless argument" should throws {
				"IllegalArgumentException" in {
					evaluating {
						soundexAlgorithm.main(Array("--unitTest", "--debug"))
					} should produce [IllegalArgumentException]
				}
			}
		}
	}
}