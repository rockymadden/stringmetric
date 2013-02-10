package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.StringFilterLike

/** Ensures ASCII letters do not matter. */
trait AsciiLetterStringFilter extends StringFilterLike {
	abstract override def filter(charArray: Array[Char]): Array[Char] =
		super.filter(charArray.filter(c => !((c >= 65 && c <= 90 ) || (c >= 97 && c <= 122))))

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}
