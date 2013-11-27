package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class soundexalgorithmSpec extends ScalaTest {
	"soundexalgorithm" should provide {
		"main method" when passed {
			"valid dashless argument" should executes {
				"print phonetic representation" in {
					val out = new java.io.ByteArrayOutputStream()

					Console.withOut(out)(
						soundexalgorithm.main(Array("--unitTest", "--debug", "abc"))
					)

					out.toString should equal ("a120\n")
					out.reset()

					Console.withOut(out)(
						soundexalgorithm.main(Array("--unitTest", "--debug", "1"))
					)

					out.toString should equal ("not computable\n")
					out.reset()
				}
			}
			"no dashless argument" should throws {
				"IllegalArgumentException" in {
					evaluating {
						soundexalgorithm.main(Array("--unitTest", "--debug"))
					} should produce [IllegalArgumentException]
				}
			}
		}
	}
}
