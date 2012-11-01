package org.hashtree.stringmetric

/** A decorator [[org.hashtree.stringmetric.StringFilter]]. Ensures only ASCII numbers matter. */
trait AsciiNumberOnlyStringFilter extends StringFilter {
	abstract override def filter(charArray: Array[Char]): Array[Char] =
		super.filter(
			charArray.filter { c =>
				(c >= 48 && c <= 57 )
			}
		)

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}