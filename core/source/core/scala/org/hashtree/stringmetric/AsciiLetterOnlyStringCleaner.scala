package org.hashtree.stringmetric

/** A decorator [[org.hashtree.stringmetric.StringCleaner]]. Ensures only ASCII letters matter. */
trait AsciiLetterOnlyStringCleaner extends StringCleaner {
	abstract override def clean(charArray: Array[Char]): Array[Char] = {
		super.clean(
			charArray.filter { c =>
				(c >= 65 && c <= 90 ) || (c >= 97 && c <= 122)
			}
		)
	}

	abstract override def clean(string: String): String = clean(string.toCharArray).mkString
}