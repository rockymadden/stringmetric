package com.rockymadden.stringmetric

import scala.collection.immutable.Set

object Alphabet {
	sealed abstract class Alphabet(val chars: Set[Char]) {
		def isSuperset(a: Char): Boolean = chars.contains(a)

		def isSuperset(a: Array[Char]): Boolean = a.length > 0 && a.takeWhile(chars.contains).length == a.length

		def isSuperset(a: String): Boolean = isSuperset(a.toCharArray)
	}


	case object LowercaseConsonant extends Alphabet(
		Set('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x' ,'z')
	)

	case object UppercaseConsonant extends Alphabet(
		Set('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X' ,'Z')
	)

	case object Consonant extends Alphabet(LowercaseConsonant.chars ++ UppercaseConsonant.chars)

	case object LowercaseVowel extends Alphabet(Set('a', 'e', 'i', 'o', 'u'))

	case object UppercaseVowel extends Alphabet(Set('A', 'E', 'I', 'O', 'U'))

	case object Vowel extends Alphabet(LowercaseVowel.chars ++ UppercaseVowel.chars)

	case object LowercaseY extends Alphabet(Set('y'))

	case object UppercaseY extends Alphabet(Set('Y'))

	case object Y extends Alphabet(LowercaseY.chars ++ UppercaseY.chars)

	case object LowercaseAlpha extends Alphabet(LowercaseConsonant.chars ++ LowercaseVowel.chars ++ LowercaseY.chars)

	case object UppercaseAlpha extends Alphabet(UppercaseConsonant.chars ++ UppercaseVowel.chars ++ UppercaseY.chars)

	case object Alpha extends Alphabet(LowercaseAlpha.chars ++ UppercaseAlpha.chars)
}
