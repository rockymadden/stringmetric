package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Algorithm]]. */
trait StringAlgorithm extends Algorithm[String, StringFilter] {
	def compute(ca: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]]
}