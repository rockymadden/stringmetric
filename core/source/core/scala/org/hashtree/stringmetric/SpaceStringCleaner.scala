package org.hashtree.stringmetric

/** A decorator [[org.hashtree.stringmetric.StringCleaner]]. Ensures the input spacing does not matter. */
trait SpaceStringCleaner extends StringCleaner {
	abstract override def clean(charArray: Array[Char]): Array[Char] = {
		super.clean(charArray.filter(_ != ' '))
	}

	abstract override def clean(string: String): String = {
		super.clean(string.replaceAllLiterally(" ", ""))
	}
}