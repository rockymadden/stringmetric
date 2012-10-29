package org.hashtree.stringmetric.cli.command

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class refinedSoundexMetricSpec extends ScalaTest {
	"refinedSoundexMetric" should provide {
		"main method" when passed {
			"valid dashless arguments" should executes {
				"print if they are a match" in {
					val out = new java.io.ByteArrayOutputStream()

					Console.withOut(out)(
						refinedSoundexMetric.main(Array("--unitTest", "--debug", "aBc", "abc"))
					)

					out.toString should equal ("true\n")
					out.reset()

					Console.withOut(out)(
						refinedSoundexMetric.main(Array("--unitTest", "--debug", "aBc", "xyz"))
					)

					out.toString should equal ("false\n")
					out.reset()

					Console.withOut(out)(
						refinedSoundexMetric.main(Array("--unitTest", "--debug", "1", "1"))
					)

					out.toString should equal ("not comparable\n")
					out.reset()
				}
			}
			"no dashless arguments" should throws {
				"IllegalArgumentException" in {
					evaluating {
						refinedSoundexMetric.main(Array("--unitTest", "--debug"))
					} should produce [IllegalArgumentException]
				}
			}
		}
	}
}