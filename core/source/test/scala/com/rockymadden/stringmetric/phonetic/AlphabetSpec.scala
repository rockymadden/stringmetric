package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AlphabetSpec extends ScalaTest {
	"Alphabet" should provide {
		"an overloaded is method which accepts a Char" when passed {
			"non-alphabet argument" should returns {
				"false" in {
					Alphabet.is('0') should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					Alphabet.is('a') should be (true)
					Alphabet.is('A') should be (true)
				}
			}
		}
		"an overloaded is method which accepts an Array[Char]" when passed {
			"empty argument" should returns {
				"false" in {
					Alphabet.is(Array.empty[Char]) should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					Alphabet.is("hi!".toCharArray) should be (false)
					Alphabet.is("helloworld!".toCharArray) should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					Alphabet.is("hi".toCharArray) should be (true)
					Alphabet.is("helloworld".toCharArray) should be (true)
					Alphabet.is("HI".toCharArray) should be (true)
					Alphabet.is("HELLOWORLD".toCharArray) should be (true)
				}
			}
		}
		"an overloaded is method which accepts a String" when passed {
			"empty argument" should returns {
				"false" in {
					Alphabet.is("") should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					Alphabet.is("helloworld!") should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					Alphabet.is("helloworld") should be (true)
					Alphabet.is("HELLOWORLD") should be (true)
				}
			}
		}
		"isSometimesVowel method" when passed {
			"non-vowel argument" should returns {
				"false" in {
					Alphabet.isSometimesVowel('z') should be (false)
				}
			}
			"vowel argument" should returns {
				"true" in {
					Alphabet.isSometimesVowel('a') should be (true)
					Alphabet.isSometimesVowel('A') should be (true)
					Alphabet.isSometimesVowel('y') should be (true)
					Alphabet.isSometimesVowel('Y') should be (true)
				}
			}
		}
		"isVowel method" when passed {
			"non-vowel argument" should returns {
				"false" in {
					Alphabet.isVowel('y') should be (false)
				}
			}
			"vowel argument" should returns {
				"true" in {
					Alphabet.isVowel('a') should be (true)
					Alphabet.isVowel('A') should be (true)
				}
			}
		}
		"an overloaded startsWith method which accepts an Array[Char]" when passed {
			"empty argument" should returns {
				"false" in {
					Alphabet.startsWith(Array.empty[Char]) should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					Alphabet.startsWith("1abc".toCharArray) should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					Alphabet.startsWith("abc".toCharArray) should be (true)
				}
			}
		}
		"an overloaded startsWith method which accepts a String" when passed {
			"empty argument" should returns {
				"false" in {
					Alphabet.startsWith("") should be (false)
				}
			}
			"non-alphabet argument" should returns {
				"false" in {
					Alphabet.startsWith("1abc") should be (false)
				}
			}
			"alphabet argument" should returns {
				"true" in {
					Alphabet.startsWith("abc") should be (true)
				}
			}
		}
	}
}