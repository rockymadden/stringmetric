package com.rockymadden.stringmetric

import scala.collection.immutable.Set

sealed trait Alphabet {
	val chars: Set[Char]

	def isSuperset(a: Char): Boolean = chars.contains(a)

	def isSuperset(a: Array[Char]): Boolean = a.length > 0 && a.takeWhile(chars.contains).length == a.length

	def isSuperset(a: String): Boolean = isSuperset(a.toCharArray)
}

object Alphabet {
	case object LowercaseConsonant extends Alphabet {
		val chars =
			Set('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z')
	}

	case object UppercaseConsonant extends Alphabet {
		val chars =
			Set('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z')
	}

	case object Consonant extends Alphabet {
		val chars = LowercaseConsonant.chars ++ UppercaseConsonant.chars
	}

	case object LowercaseVowel extends Alphabet {
		val chars = Set('a', 'e', 'i', 'o', 'u')
	}

	case object UppercaseVowel extends Alphabet {
		val chars = Set('A', 'E', 'I', 'O', 'U')
	}

	case object Vowel extends Alphabet {
		val chars = LowercaseVowel.chars ++ UppercaseVowel.chars
	}

	case object LowercaseY extends Alphabet {
		val chars = Set('y')
	}

	case object UppercaseY extends Alphabet {
		val chars = Set('Y')
	}

	case object Y extends Alphabet {
		val chars = LowercaseY.chars ++ UppercaseY.chars
	}

	case object LowercaseAlpha extends Alphabet {
		val chars = LowercaseConsonant.chars ++ LowercaseVowel.chars ++ LowercaseY.chars
	}

	case object UppercaseAlpha extends Alphabet {
		val chars = UppercaseConsonant.chars ++ UppercaseVowel.chars ++ UppercaseY.chars
	}

	case object Alpha extends Alphabet {
		val chars = LowercaseAlpha.chars ++ UppercaseAlpha.chars
	}
}
