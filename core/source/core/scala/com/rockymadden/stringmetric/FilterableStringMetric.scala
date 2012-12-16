package com.rockymadden.stringmetric

/** Marks those which leverage traits of a string based [[com.rockymadden.stringmetric.FilterableMetric]]. */
trait FilterableStringMetric extends FilterableMetric[String, StringFilter] with StringMetric {
	def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn]
}