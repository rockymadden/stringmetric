package org.hashtree.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexMetricSpec extends ScalaTest {
	"SoundexMetric" should provide {
		"compare method" when passed {
			"valid arguments" should returns {
				"Boolean indicating matches" in {
					SoundexMetric.compare("abc", "abc") should be (true) // a120 vs. a120
					SoundexMetric.compare("a", "a") should be (true) // a000 vs. a000
					SoundexMetric.compare("abc", "xyz") should be (false) // a120 vs. x200
					SoundexMetric.compare("", "") should be (false)
					SoundexMetric.compare("123", "123") should be (false)
					SoundexMetric.compare("1", "1") should be (false)

					SoundexMetric.compare("Robert", "Rupert") should be (true) // r163 vs. r163
					SoundexMetric.compare("Robert", "Rubin") should be (false) // r163 vs. r150

					SoundexMetric.compare("Ashcraft", "Ashcroft") should be (true) // a261 vs. a261
					SoundexMetric.compare("Tymczak", "Tymczak") should be (true) // t522 vs. t522
					SoundexMetric.compare("Pfister", "Pfister") should be (true) // p236 vs. p236
					SoundexMetric.compare("Euler", "Ellery") should be (true) // e460 vs. e460
					SoundexMetric.compare("Gauss", "Ghosh") should be (true) // g200 vs. g200
					SoundexMetric.compare("Hilbert", "Heilbronn") should be (true) // h416 vs. h416
					SoundexMetric.compare("Knuth", "Kant") should be (true) // k530 vs. k530
					SoundexMetric.compare("Lloyd", "Ladd") should be (true) // l300 vs. l300
					SoundexMetric.compare("Lukasiewicz", "Lissajous") should be (true) // l222 vs. l222
				}
			}
		}
	}
}