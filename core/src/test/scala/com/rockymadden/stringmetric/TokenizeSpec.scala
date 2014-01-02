package com.rockymadden.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class TokenizeSpec extends ScalaTest { "NGramTokenizer" should provide {
	import Tokenize._

	"tokenize method" when passed {
		"empty argument" should returns {
			"None" in {
				NGramTokenizer(1).tokenize("").isDefined should be (false)
			}
		}
		"invalid n argument" should returns {
			"None" in {
				NGramTokenizer(0).tokenize("").isDefined should be (false)
				NGramTokenizer(-1).tokenize("").isDefined should be (false)
			}
		}
		"valid argument" should returns {
			"Array[String]" in {
				NGramTokenizer(1).tokenize("abcdefghijklmnopqrstuvwxyz").get should equal (
					Array(
						"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
						"s", "t", "u", "v", "w", "x", "y", "z"
					)
				)
				NGramTokenizer(2).tokenize("abcdefghijklmnopqrstuvwxyz").get should equal (
					Array(
						"ab", "bc", "cd", "de", "ef", "fg", "gh", "hi", "ij", "jk", "kl", "lm", "mn", "no", "op",
						"pq", "qr", "rs", "st", "tu", "uv", "vw", "wx", "xy", "yz"
					)
				)
				NGramTokenizer(3).tokenize("abcdefghijklmnopqrstuvwxyz").get should equal (
					Array(
						"abc", "bcd", "cde", "def", "efg", "fgh", "ghi", "hij", "ijk", "jkl", "klm", "lmn", "mno",
						"nop", "opq", "pqr", "qrs", "rst", "stu", "tuv", "uvw", "vwx", "wxy", "xyz"
					)
				)
			}
		}
	}
}}
