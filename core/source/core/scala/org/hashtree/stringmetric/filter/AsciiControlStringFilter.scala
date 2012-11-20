package org.hashtree.stringmetric.filter

import org.hashtree.stringmetric.StringFilter

/** A decorator [[org.hashtree.stringmetric.StringFilter]]. Ensures ASCII controls do not matter. */
trait AsciiControlStringFilter extends StringFilter {
	abstract override def filter(charArray: Array[Char]): Array[Char] =
		super.filter(
			charArray.filter(c => !(c <= 31 || c == 127))
		)

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}