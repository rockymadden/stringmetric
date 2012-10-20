package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexMetricSpec extends ScalaTest {
	"SoundexMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Boolean indicating matches" in {
					SoundexMetric.compare("abc", "abc").get should be (true) // a120 vs. a120
					SoundexMetric.compare("a", "a").get should be (true) // a000 vs. a000
					SoundexMetric.compare("abc", "xyz").get should be (false) // a120 vs. x200
					SoundexMetric.compare("", "").isDefined should be (false)
					SoundexMetric.compare("123", "123").isDefined should be (false)
					SoundexMetric.compare("1", "1").isDefined should be (false)

					SoundexMetric.compare("Robert", "Rupert").get should be (true) // r163 vs. r163
					SoundexMetric.compare("Robert", "Rubin").get should be (false) // r163 vs. r150

					SoundexMetric.compare("Ashcraft", "Ashcroft").get should be (true) // a261 vs. a261
					SoundexMetric.compare("Tymczak", "Tymczak").get should be (true) // t522 vs. t522
					SoundexMetric.compare("Pfister", "Pfister").get should be (true) // p236 vs. p236
					SoundexMetric.compare("Euler", "Ellery").get should be (true) // e460 vs. e460
					SoundexMetric.compare("Gauss", "Ghosh").get should be (true) // g200 vs. g200
					SoundexMetric.compare("Hilbert", "Heilbronn").get should be (true) // h416 vs. h416
					SoundexMetric.compare("Knuth", "Kant").get should be (true) // k530 vs. k530
					SoundexMetric.compare("Lloyd", "Ladd").get should be (true) // l300 vs. l300
					SoundexMetric.compare("Lukasiewicz", "Lissajous").get should be (true) // l222 vs. l222
				}
			}
		}
	}
}