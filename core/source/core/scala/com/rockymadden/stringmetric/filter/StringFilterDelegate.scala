package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.StringFilterLike

class StringFilterDelegate extends StringFilterLike {
	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}
