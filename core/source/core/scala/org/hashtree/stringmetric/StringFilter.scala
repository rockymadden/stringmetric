package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Filter]]. */
trait StringFilter extends Filter[String] {
	def filter(charArray: Array[Char]): Array[Char]
}