package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Algorithm]]. */
trait StringAlgorithm extends Algorithm[String, StringCleaner] {
	def compute(ca: Array[Char])(implicit stringCleaner: StringCleaner): Option[Array[Char]]
}