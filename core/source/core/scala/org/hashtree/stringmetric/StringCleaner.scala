package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Cleaner]]. */
trait StringCleaner extends Cleaner[String] {
	def clean(charArray: Array[Char]): Array[Char]
}