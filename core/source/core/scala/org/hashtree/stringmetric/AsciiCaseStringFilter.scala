package org.hashtree.stringmetric

/** A decorator [[org.hashtree.stringmetric.StringFilter]]. Ensures the input case-sensitivity does not matter. */
trait AsciiCaseStringFilter extends StringFilter {
	abstract override def filter(charArray: Array[Char]): Array[Char] = {
		super.filter(
			charArray.map { c =>
				if (c >= 65 && c <= 90) (c + 32).toChar else c
			}
		)
	}

	abstract override def filter(string: String): String = super.filter(string.toLowerCase)
}