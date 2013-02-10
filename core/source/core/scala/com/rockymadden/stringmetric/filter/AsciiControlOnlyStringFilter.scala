package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.StringFilterLike

/** Ensures only ASCII control characters matter. */
trait AsciiControlOnlyStringFilter extends StringFilterLike {
	abstract override def filter(charArray: Array[Char]): Array[Char] =
		super.filter(charArray.filter(c => (c <= 31 || c == 127)))

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}
