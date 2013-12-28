package com.rockymadden.stringmetric

import scala.collection.immutable.Set

object Alphabet {
	sealed abstract class AlphabetLike(protected[Alphabet] val chars: Set[Char]) {
		def isSuperset(a: Char): Boolean = chars.contains(a)

		def isSuperset(a: Array[Char]): Boolean = a.length > 0 && a.takeWhile(chars.contains).length == a.length

		def isSuperset(a: String): Boolean = isSuperset(a.toCharArray)
	}


	case object LowercaseConsonant extends AlphabetLike(
		Set('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x' ,'z')
	)

	case object UppercaseConsonant extends AlphabetLike(
		Set('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X' ,'Z')
	)

	case object Consonant extends AlphabetLike(LowercaseConsonant.chars ++ UppercaseConsonant.chars)

	case object LowercaseVowel extends AlphabetLike(Set('a', 'e', 'i', 'o', 'u'))

	case object UppercaseVowel extends AlphabetLike(Set('A', 'E', 'I', 'O', 'U'))

	case object Vowel extends AlphabetLike(LowercaseVowel.chars ++ UppercaseVowel.chars)

	case object LowercaseY extends AlphabetLike(Set('y'))

	case object UppercaseY extends AlphabetLike(Set('Y'))

	case object Y extends AlphabetLike(LowercaseY.chars ++ UppercaseY.chars)

	case object LowercaseAlpha extends AlphabetLike(LowercaseConsonant.chars ++ LowercaseVowel.chars ++ LowercaseY.chars)

	case object UppercaseAlpha extends AlphabetLike(UppercaseConsonant.chars ++ UppercaseVowel.chars ++ UppercaseY.chars)

	case object Alpha extends AlphabetLike(LowercaseAlpha.chars ++ UppercaseAlpha.chars)
}
