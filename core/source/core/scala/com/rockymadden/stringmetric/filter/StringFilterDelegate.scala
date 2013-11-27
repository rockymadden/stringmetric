package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.StringFilter

class StringFilterDelegate extends StringFilter {
	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}
