package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.StringFilterLike

/** Ensures only ASCII numbers matter. */
trait AsciiNumberOnlyStringFilter extends StringFilterLike {
	abstract override def filter(charArray: Array[Char]): Array[Char] =
		super.filter(charArray.filter(c => (c >= 48 && c <= 57 )))

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}
