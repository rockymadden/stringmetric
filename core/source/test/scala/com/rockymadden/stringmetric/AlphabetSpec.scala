package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.Alphabet.{Alpha, Vowel}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AlphabetSpec extends ScalaTest { "Alphabet" should provide {
	"an overloaded isSuperset method which accepts Char" when passed {
		"non-alphabet argument" should returns {
			"false" in {
				Alpha isSuperset '0' should be (false)
			}
		}
		"alphabet argument" should returns {
			"true" in {
				Alpha isSuperset 'a' should be (true)
				Alpha isSuperset 'A' should be (true)
			}
		}
		"non-vowel argument" should returns {
			"false" in {
				Vowel isSuperset 'y' should be (false)
			}
		}
		"vowel argument" should returns {
			"true" in {
				Vowel isSuperset 'a' should be (true)
				Vowel isSuperset 'A' should be (true)
			}
		}
	}
	"an overloaded isSuperset method which accepts Array[Char]" when passed {
		"empty argument" should returns {
			"false" in {
				Alpha isSuperset Array.empty[Char] should be (false)
			}
		}
		"non-alphabet argument" should returns {
			"false" in {
				Alpha isSuperset "hi!".toCharArray should be (false)
				Alpha isSuperset "helloworld!".toCharArray should be (false)
			}
		}
		"alphabet argument" should returns {
			"true" in {
				Alpha isSuperset "hi".toCharArray should be (true)
				Alpha isSuperset "helloworld".toCharArray should be (true)
				Alpha isSuperset "HI".toCharArray should be (true)
				Alpha isSuperset "HELLOWORLD".toCharArray should be (true)
			}
		}
		"non-vowel argument" should returns {
			"false" in {
				Vowel isSuperset "y".toCharArray should be (false)
			}
		}
		"vowel argument" should returns {
			"true" in {
				Vowel isSuperset "a".toCharArray should be (true)
				Vowel isSuperset "A".toCharArray should be (true)
			}
		}
	}
	"an overloaded isSuperset method which accepts String" when passed {
		"empty argument" should returns {
			"false" in {
				Alpha isSuperset "" should be (false)
			}
		}
		"non-alphabet argument" should returns {
			"false" in {
				Alpha isSuperset "helloworld!" should be (false)
			}
		}
		"alphabet argument" should returns {
			"true" in {
				Alpha isSuperset "helloworld" should be (true)
				Alpha isSuperset "HELLOWORLD" should be (true)
			}
		}
		"non-vowel argument" should returns {
			"false" in {
				Vowel isSuperset "y" should be (false)
			}
		}
		"vowel argument" should returns {
			"true" in {
				Vowel isSuperset "a" should be (true)
				Vowel isSuperset "A" should be (true)
			}
		}
	}
}}
