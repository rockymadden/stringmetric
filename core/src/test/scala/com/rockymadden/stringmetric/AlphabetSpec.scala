package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.Alphabet._


object AlphabetSpec extends org.specs2.mutable.Specification {
	"AlphabetSet isSuperset()" should {
		"return false with non-alphabet argument" in {
			Alpha isSuperset '0' must beFalse
			Alpha isSuperset Array.empty[Char] must beFalse
			Alpha isSuperset "helloworld!".toCharArray must beFalse
			Alpha isSuperset "" must beFalse
			Alpha isSuperset "helloworld!" must beFalse
		}
		"return true with alphabet argument" in {
			Alpha isSuperset 'a' must beTrue
			Alpha isSuperset 'A' must beTrue
			Alpha isSuperset "helloworld".toCharArray must beTrue
			Alpha isSuperset "HELLOWORLD".toCharArray must beTrue
			Alpha isSuperset "helloworld" must beTrue
			Alpha isSuperset "HELLOWORLD" must beTrue
		}
		"return false with non-vowel argument" in {
			Vowel isSuperset 'y' must beFalse
			Vowel isSuperset "y".toCharArray must beFalse
			Vowel isSuperset "y" must beFalse
		}
		"return true with vowel argument" in {
			Vowel isSuperset 'a' must beTrue
			Vowel isSuperset 'A' must beTrue
			Vowel isSuperset "a".toCharArray must beTrue
			Vowel isSuperset "A".toCharArray must beTrue
			Vowel isSuperset "a" must beTrue
			Vowel isSuperset "A" must beTrue
		}
	}
}
