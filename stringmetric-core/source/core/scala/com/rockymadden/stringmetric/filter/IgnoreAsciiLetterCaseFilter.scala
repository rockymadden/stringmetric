package com.rockymadden.stringmetric.filter

import com.rockymadden.stringmetric.StringFilter

/** Ensures ASCII letter case-sensitivity does not matter. */
trait IgnoreAsciiLetterCaseFilter extends StringFilter {
	abstract override def filter(charArray: Array[Char]): Array[Char] =
		super.filter(charArray.map(c => if (c >= 65 && c <= 90) (c + 32).toChar else c))

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}
