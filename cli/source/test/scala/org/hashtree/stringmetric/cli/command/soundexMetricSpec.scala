package org.hashtree.stringmetric.cli.command

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class soundexMetricSpec extends ScalaTest {
	"soundexMetric" should provide {
		"main method" when passed {
			"valid dashless arguments" should executes {
				"print if they are a match" in {
					val out = new java.io.ByteArrayOutputStream()

					Console.withOut(out)(
						soundexMetric.main(Array("--unitTest", "--debug", "aBc", "abc"))
					)

					out.toString should equal ("true\n")
					out.reset()

					Console.withOut(out)(
						soundexMetric.main(Array("--unitTest", "--debug", "aBc", "xyz"))
					)

					out.toString should equal ("false\n")
					out.reset()
				}
			}
			"no dashless arguments" should throws {
				"IllegalArgumentException" in {
					evaluating {
						soundexMetric.main(Array("--unitTest", "--debug"))
					} should produce [IllegalArgumentException]
				}
			}
		}
	}
}