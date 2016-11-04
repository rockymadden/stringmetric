package com.rockymadden.stringmetric

object StringTokenizerSpec extends org.specs2.mutable.Specification {
	"NGramTokenizer tokenize()" should {
		"return None with empty argument" in {
			NGramTokenizer(1).tokenize("").isDefined must beEqualTo(false)
		}
		"return None with invalid n argument" in {
			NGramTokenizer(0).tokenize("").isDefined must beEqualTo(false)
			NGramTokenizer(-1).tokenize("").isDefined must beEqualTo(false)
		}
		"return Array[String] with valid argument" in {
			NGramTokenizer(1).tokenize("abcdefghijklmnopqrstuvwxyz").get must beEqualTo(
				Array(
					"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
					"s", "t", "u", "v", "w", "x", "y", "z"
				)
			)
			NGramTokenizer(2).tokenize("abcdefghijklmnopqrstuvwxyz").get must beEqualTo(
				Array(
					"ab", "bc", "cd", "de", "ef", "fg", "gh", "hi", "ij", "jk", "kl", "lm", "mn", "no", "op",
					"pq", "qr", "rs", "st", "tu", "uv", "vw", "wx", "xy", "yz"
				)
			)
			NGramTokenizer(3).tokenize("abcdefghijklmnopqrstuvwxyz").get must beEqualTo(
				Array(
					"abc", "bcd", "cde", "def", "efg", "fgh", "ghi", "hij", "ijk", "jkl", "klm", "lmn", "mno",
					"nop", "opq", "pqr", "qrs", "rst", "stu", "tuv", "uvw", "vwx", "wxy", "xyz"
				)
			)
		}
	}
}
