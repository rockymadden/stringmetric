package org.hashtree.stringmetric

class StringCleanerDelegate extends StringCleaner {
	override def clean(charArray: Array[Char]): Array[Char] = charArray

	override def clean(string: String): String = string
}