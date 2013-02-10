package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.StringFilterLike

/** Ensures ASCII symbols do not matter. */
trait AsciiSymbolStringFilter extends StringFilterLike {
	abstract override def filter(charArray: Array[Char]): Array[Char] =
		super.filter(
			charArray.filter(c =>
				!((c >= 32 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126))
			)
		)

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}
