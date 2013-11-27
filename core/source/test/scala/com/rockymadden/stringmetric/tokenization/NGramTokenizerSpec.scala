package com.rockymadden.stringmetric.tokenization

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NGramTokenizerSpec extends ScalaTest {
	import NGramTokenizerSpec.Tokenizer

	"NGramTokenizer" should provide {
		"tokenize method" when passed {
			"empty argument" should returns {
				"None" in {
					Tokenizer.tokenize("")(1).isDefined should be (false)
				}
			}
			"invalid n argument" should throws {
				"IllegalArgumentException" in {
					evaluating {
						Tokenizer.tokenize("")(0).isDefined should be (false)
					} should produce [IllegalArgumentException]

					evaluating {
						Tokenizer.tokenize("")(-1).isDefined should be (false)
					} should produce [IllegalArgumentException]
				}
			}
			"valid argument" should returns {
				"Array[String]" in {
					Tokenizer.tokenize("abcdefghijklmnopqrstuvwxyz")(1).get should equal (
						Array(
							"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
							"s", "t", "u", "v", "w", "x", "y", "z"
						)
					)
					Tokenizer.tokenize("abcdefghijklmnopqrstuvwxyz")(2).get should equal (
						Array(
							"ab", "bc", "cd", "de", "ef", "fg", "gh", "hi", "ij", "jk", "kl", "lm", "mn", "no", "op",
							"pq", "qr", "rs", "st", "tu", "uv", "vw", "wx", "xy", "yz"
						)
					)
					Tokenizer.tokenize("abcdefghijklmnopqrstuvwxyz")(3).get should equal (
						Array(
							"abc", "bcd", "cde", "def", "efg", "fgh", "ghi", "hij", "ijk", "jkl", "klm", "lmn", "mno",
							"nop", "opq", "pqr", "qrs", "rst", "stu", "tuv", "uvw", "vwx", "wxy", "xyz"
						)
					)
				}
			}
		}
	}
	"NGramTokenizer companion object" should provide {
		"pass-through tokenize method" should returns {
			"same value as class" in {
				NGramTokenizer.tokenize("abcdefghijklmnopqrstuvwxyz")(1).get should equal (
					Array(
						"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
						"s", "t", "u", "v", "w", "x", "y", "z"
					)
				)
			}
		}
	}
}

object NGramTokenizerSpec {
	private final val Tokenizer = NGramTokenizer()
}
