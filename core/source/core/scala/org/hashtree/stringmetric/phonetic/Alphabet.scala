package org.hashtree.stringmetric.phonetic

import scala.annotation.tailrec

object Alphabet {
	def is(char: Char): Boolean = (char >= 65 && char <= 90) || (char >= 97 && char <= 122)

	def is(charArray: Array[Char]): Boolean = charArray.length > 0 && !charArray.find(!is(_)).isDefined

	def is(string: String): Boolean = is(string.toCharArray)

	def isSometimesVowel(char: Char): Boolean = char == 'y' || char == 'Y' || isVowel(char)

	def isVowel(char: Char): Boolean = (
		char == 'a' || char == 'e' || char == 'i' || char == 'o' || char =='u'
		|| char == 'A' || char == 'E' || char == 'I' || char == 'O' || char =='U'
	)

	def startsWith(charArray: Array[Char]): Boolean =
		if (charArray.length == 0) false
		else is(charArray.head)

	def startsWith(string: String): Boolean =
		if (string.length == 0) false
		else is(string.charAt(0))
}