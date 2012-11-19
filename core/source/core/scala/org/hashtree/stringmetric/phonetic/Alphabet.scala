package org.hashtree.stringmetric.phonetic

object Alphabet {
	final val SometimesVowels: Set[Char] = Set('a', 'e', 'i', 'o', 'u', 'y')
	final val Vowels: Set[Char] = Set('a', 'e', 'i', 'o', 'u')

	def isSometimesVowel(c: Char) = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u' || c == 'y')

	def isVowel(c: Char) = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u')
}