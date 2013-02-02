package com.rockymadden.stringmetric.phonetic

import scala.language.implicitConversions

private[phonetic] final class Alphabet private(private[this] val self: Array[Char]) {
	def is(set: Set[Char]): Boolean = self.length > 0 && self.takeWhile(set.contains(_)).length == self.length

	def startsWith(set: Set[Char]): Boolean = self.length > 0 && set.contains(self.head)
}

private[phonetic] object Alphabet {
	final val LowercaseConsonant = Set('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x' ,'z')
	final val UppercaseConsonant = Set('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X' ,'Z')
	final val Consonant = LowercaseConsonant ++ UppercaseConsonant
	final val LowercaseVowel = Set('a', 'e', 'i', 'o', 'u')
	final val UppercaseVowel = Set('A', 'E', 'I', 'O', 'U')
	final val Vowel = LowercaseVowel ++ UppercaseVowel
	final val LowercaseY = Set('y')
	final val UppercaseY = Set('Y')
	final val Y = LowercaseY ++ UppercaseY
	final val LowercaseAlpha = LowercaseConsonant ++ LowercaseVowel ++ LowercaseY
	final val UppercaseAlpha = UppercaseConsonant ++ UppercaseVowel ++ UppercaseY
	final val Alpha = LowercaseAlpha ++ UppercaseAlpha

	implicit def CharToAlphabet(char: Char): Alphabet = apply(char)

	implicit def CharArrayToAlphabet(charArray: Array[Char]): Alphabet = apply(charArray)

	implicit def CharToAlphabet(string: String): Alphabet = apply(string)

	def apply(char: Char): Alphabet = new Alphabet(Array(char))

	def apply(charArray: Array[Char]): Alphabet = new Alphabet(charArray)

	def apply(string: String): Alphabet = new Alphabet(string.toCharArray)
}
