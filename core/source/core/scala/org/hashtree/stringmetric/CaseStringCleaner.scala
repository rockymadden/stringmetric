package org.hashtree.stringmetric

/** A decorator [[org.hashtree.stringmetric.StringCleaner]]. Ensures the input case-sensitivity does not matter. */
trait CaseStringCleaner extends StringCleaner {
	abstract override def clean(charArray: Array[Char]): Array[Char] = {
		super.clean(
			charArray.map { c =>
				if (c >= 65 && c <= 90) (c + 32).toChar else c
			}
		)
	}

	abstract override def clean(string: String): String = super.clean(string.toLowerCase)
}