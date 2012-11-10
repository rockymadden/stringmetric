package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.FilterableMetric]]. */
trait FilterableStringMetric extends FilterableMetric[String, StringFilter] with StringMetric {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[CompareReturn]
}