package org.hashtree.stringmetric

class StringFilterDelegate extends StringFilter {
	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}