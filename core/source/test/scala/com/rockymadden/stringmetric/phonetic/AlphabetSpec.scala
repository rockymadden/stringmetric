package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import com.rockymadden.stringmetric.phonetic.Alphabet._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AlphabetSpec extends ScalaTest {
	"Alphabet" should provide {
		"an overloaded is method which accepts a Char" when passed {
			"non-alphabet argument" should returns {
				"false" in {
					'0' is Alpha should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					'a' is Alpha should be (true)
					'A' is Alpha should be (true)
				}
			}
			"non-vowel argument" should returns {
				"false" in {
					'y' is Vowel should be (false)
				}
			}
			"vowel argument" should returns {
				"true" in {
					'a' is Vowel should be (true)
					'A' is Vowel should be (true)
				}
			}
		}
		"an overloaded is method which accepts an Array[Char]" when passed {
			"empty argument" should returns {
				"false" in {
					Array.empty[Char] is Alpha should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					"hi!".toCharArray is Alpha should be (false)
					"helloworld!".toCharArray is Alpha should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					"hi".toCharArray is Alpha should be (true)
					"helloworld".toCharArray is Alpha should be (true)
					"HI".toCharArray is Alpha should be (true)
					"HELLOWORLD".toCharArray is Alpha should be (true)
				}
			}
			"non-vowel argument" should returns {
				"false" in {
					"y".toCharArray is Vowel should be (false)
				}
			}
			"vowel argument" should returns {
				"true" in {
					"a".toCharArray is Vowel should be (true)
					"A".toCharArray is Vowel should be (true)
				}
			}
		}
		"an overloaded is method which accepts a String" when passed {
			"empty argument" should returns {
				"false" in {
					"" is Alpha should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					"helloworld!" is Alpha should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					"helloworld" is Alpha should be (true)
					"HELLOWORLD" is Alpha should be (true)
				}
			}
			"non-vowel argument" should returns {
				"false" in {
					"y" is Vowel should be (false)
				}
			}
			"vowel argument" should returns {
				"true" in {
					"a" is Vowel should be (true)
					"A" is Vowel should be (true)
				}
			}
		}
		"an overloaded startsWith method which accepts an Array[Char]" when passed {
			"empty argument" should returns {
				"false" in {
					Array.empty[Char] is Alpha should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					"1abc".toCharArray is Alpha should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					"abc".toCharArray is Alpha should be (true)
				}
			}
		}
		"an overloaded startsWith method which accepts a String" when passed {
			"empty argument" should returns {
				"false" in {
					"" is Alpha should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					"1abc" is Alpha should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					"abc" is Alpha should be (true)
				}
			}
		}
	}
}
