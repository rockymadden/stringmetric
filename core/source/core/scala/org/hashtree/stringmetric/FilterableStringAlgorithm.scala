package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.FilterableAlgorithm]]. */
trait FilterableStringAlgorithm extends FilterableAlgorithm[String, StringFilter] with StringAlgorithm {
	def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[_]]
}