package com.rockymadden.stringmetric.phonetic

import scala.collection.immutable.Set
import scala.language.implicitConversions

sealed abstract class Alphabet {
	val Chars: Set[Char]

	def isSuperset(char: Char): Boolean = Chars.contains(char)

	def isSuperset(charArray: Array[Char]): Boolean =
		charArray.length > 0 && charArray.takeWhile(Chars.contains(_)).length == charArray.length

	def isSuperset(string: String): Boolean = isSuperset(string.toCharArray)

	def startsWith(char: Char): Boolean = Chars.contains(char)

	def startsWith(charArray: Array[Char]): Boolean = charArray.length > 0 && Chars.contains(charArray.head)

	def startsWith(string: String): Boolean = startsWith(string.toCharArray)
}

case object LowercaseConsonant extends Alphabet {
	override final val Chars =
		Set('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x' ,'z')
}
case object UppercaseConsonant extends Alphabet {
	override final val Chars =
		Set('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X' ,'Z')
}
case object Consonant extends Alphabet {
	override final val Chars = LowercaseConsonant.Chars ++ UppercaseConsonant.Chars
}
case object LowercaseVowel extends Alphabet {
	override final val Chars = Set('a', 'e', 'i', 'o', 'u')
}
case object UppercaseVowel extends Alphabet {
	override final val Chars = Set('A', 'E', 'I', 'O', 'U')
}
case object Vowel extends Alphabet {
	override final val Chars = LowercaseVowel.Chars ++ UppercaseVowel.Chars
}
case object LowercaseY extends Alphabet {
	override final val Chars = Set('y')
}
case object UppercaseY extends Alphabet {
	override final val Chars = Set('Y')
}
case object Y extends Alphabet {
	override final val Chars = LowercaseY.Chars ++ UppercaseY.Chars
}
case object LowercaseAlpha extends Alphabet {
	override final val Chars = LowercaseConsonant.Chars ++ LowercaseVowel.Chars ++ LowercaseY.Chars
}
case object UppercaseAlpha extends Alphabet {
	override final val Chars = UppercaseConsonant.Chars ++ UppercaseVowel.Chars ++ UppercaseY.Chars
}
case object Alpha extends Alphabet {
	override final val Chars = LowercaseAlpha.Chars ++ UppercaseAlpha.Chars
}
