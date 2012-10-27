package org.hashtree.stringmetric

/** A decorator [[org.hashtree.stringmetric.StringFilter]]. Ensures the input spacing does not matter. */
trait SpaceStringFilter extends StringFilter {
	abstract override def filter(charArray: Array[Char]): Array[Char] = super.filter(charArray.filter(_ != ' '))

	abstract override def filter(string: String): String = super.filter(string.replaceAllLiterally(" ", ""))
}