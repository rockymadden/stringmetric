package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NGramAlgorithmSpec extends ScalaTest {
	import NGramAlgorithmSpec.Algorithm

	"NGramAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					Algorithm.compute("")(1).isDefined should be (false)
				}
			}
			"invalid n argument" should throws {
				"IllegalArgumentException" in {
					evaluating {
						Algorithm.compute("")(0).isDefined should be (false)
					} should produce [IllegalArgumentException]

					evaluating {
						Algorithm.compute("")(-1).isDefined should be (false)
					} should produce [IllegalArgumentException]
				}
			}
			"valid argument" should returns {
				"Array[String]" in {
					Algorithm.compute("abcdefghijklmnopqrstuvwxyz")(1).get should equal (
						Array(
							"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
							"s", "t", "u", "v", "w", "x", "y", "z"
						)
					)
					Algorithm.compute("abcdefghijklmnopqrstuvwxyz")(2).get should equal (
						Array(
							"ab", "bc", "cd", "de", "ef", "fg", "gh", "hi", "ij", "jk", "kl", "lm", "mn", "no", "op",
							"pq", "qr", "rs", "st", "tu", "uv", "vw", "wx", "xy", "yz"
						)
					)
					Algorithm.compute("abcdefghijklmnopqrstuvwxyz")(3).get should equal (
						Array(
							"abc", "bcd", "cde", "def", "efg", "fgh", "ghi", "hij", "ijk", "jkl", "klm", "lmn", "mno",
							"nop", "opq", "pqr", "qrs", "rst", "stu", "tuv", "uvw", "vwx", "wxy", "xyz"
						)
					)
				}
			}
		}
	}
	"NGramAlgorithm companion object" should provide {
		"pass-through compute method" should returns {
			"same value as class" in {
				NGramAlgorithm.compute("abcdefghijklmnopqrstuvwxyz")(1).get should equal (
					Array(
						"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
						"s", "t", "u", "v", "w", "x", "y", "z"
					)
				)
			}
		}
	}
}

object NGramAlgorithmSpec {
	private final val Algorithm = NGramAlgorithm()
}
