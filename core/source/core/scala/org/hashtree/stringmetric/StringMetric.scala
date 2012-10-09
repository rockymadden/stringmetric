package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Metric]]. */
trait StringMetric extends Metric[String, StringCleaner] {
	def compare(ca1: Array[Char], ca2: Array[Char])(implicit stringCleaner: StringCleaner): AnyVal
}