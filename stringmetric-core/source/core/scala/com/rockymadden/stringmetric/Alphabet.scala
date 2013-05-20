package com.rockymadden.stringmetric

import scala.collection.immutable.Set

object Alphabet {
	protected sealed abstract class AlphabetSet {
		protected[Alphabet] val Chars: Set[Char]

		def isSuperset(char: Char): Boolean = Chars.contains(char)

		def isSuperset(charArray: Array[Char]): Boolean =
			charArray.length > 0 && charArray.takeWhile(Chars.contains(_)).length == charArray.length

		def isSuperset(string: String): Boolean = isSuperset(string.toCharArray)
	}

	case object LowercaseConsonant extends AlphabetSet {
		override protected[Alphabet] final val Chars =
			Set('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x' ,'z')
	}
	case object UppercaseConsonant extends AlphabetSet {
		override protected[Alphabet] final val Chars =
			Set('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X' ,'Z')
	}
	case object Consonant extends AlphabetSet {
		override protected[Alphabet] final val Chars = LowercaseConsonant.Chars ++ UppercaseConsonant.Chars
	}
	case object LowercaseVowel extends AlphabetSet {
		override protected[Alphabet] final val Chars = Set('a', 'e', 'i', 'o', 'u')
	}
	case object UppercaseVowel extends AlphabetSet {
		override protected[Alphabet] final val Chars = Set('A', 'E', 'I', 'O', 'U')
	}
	case object Vowel extends AlphabetSet {
		override protected[Alphabet] final val Chars = LowercaseVowel.Chars ++ UppercaseVowel.Chars
	}
	case object LowercaseY extends AlphabetSet {
		override protected[Alphabet] final val Chars = Set('y')
	}
	case object UppercaseY extends AlphabetSet {
		override protected[Alphabet] final val Chars = Set('Y')
	}
	case object Y extends AlphabetSet {
		override protected[Alphabet] final val Chars = LowercaseY.Chars ++ UppercaseY.Chars
	}
	case object LowercaseAlpha extends AlphabetSet {
		override protected[Alphabet] final val Chars = LowercaseConsonant.Chars ++ LowercaseVowel.Chars ++ LowercaseY.Chars
	}
	case object UppercaseAlpha extends AlphabetSet {
		override protected[Alphabet] final val Chars = UppercaseConsonant.Chars ++ UppercaseVowel.Chars ++ UppercaseY.Chars
	}
	case object Alpha extends AlphabetSet {
		override protected[Alphabet] final val Chars = LowercaseAlpha.Chars ++ UppercaseAlpha.Chars
	}
}
