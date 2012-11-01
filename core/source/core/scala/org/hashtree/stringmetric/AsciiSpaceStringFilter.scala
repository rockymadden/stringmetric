package org.hashtree.stringmetric

/** A decorator [[org.hashtree.stringmetric.StringFilter]]. Ensures ASCII spaces do not matter. */
trait AsciiSpaceStringFilter extends StringFilter {
	abstract override def filter(charArray: Array[Char]): Array[Char] = super.filter(charArray.filter(_ != ' '))

	abstract override def filter(string: String): String = filter(string.toCharArray).mkString
}