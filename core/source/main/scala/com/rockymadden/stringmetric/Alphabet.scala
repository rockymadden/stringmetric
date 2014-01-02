package com.rockymadden.stringmetric

import scala.collection.immutable.Set

object Alphabet {
	sealed abstract class AlphabetSet(val chars: Set[Char]) {
		def isSuperset(a: Char): Boolean = chars.contains(a)

		def isSuperset(a: Array[Char]): Boolean = a.length > 0 && a.takeWhile(chars.contains).length == a.length

		def isSuperset(a: String): Boolean = isSuperset(a.toCharArray)
	}


	case object LowercaseConsonant extends AlphabetSet(
		Set('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x' ,'z')
	)

	case object UppercaseConsonant extends AlphabetSet(
		Set('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X' ,'Z')
	)

	case object Consonant extends AlphabetSet(LowercaseConsonant.chars ++ UppercaseConsonant.chars)

	case object LowercaseVowel extends AlphabetSet(Set('a', 'e', 'i', 'o', 'u'))

	case object UppercaseVowel extends AlphabetSet(Set('A', 'E', 'I', 'O', 'U'))

	case object Vowel extends AlphabetSet(LowercaseVowel.chars ++ UppercaseVowel.chars)

	case object LowercaseY extends AlphabetSet(Set('y'))

	case object UppercaseY extends AlphabetSet(Set('Y'))

	case object Y extends AlphabetSet(LowercaseY.chars ++ UppercaseY.chars)

	case object LowercaseAlpha extends AlphabetSet(LowercaseConsonant.chars ++ LowercaseVowel.chars ++ LowercaseY.chars)

	case object UppercaseAlpha extends AlphabetSet(UppercaseConsonant.chars ++ UppercaseVowel.chars ++ UppercaseY.chars)

	case object Alpha extends AlphabetSet(LowercaseAlpha.chars ++ UppercaseAlpha.chars)
}
