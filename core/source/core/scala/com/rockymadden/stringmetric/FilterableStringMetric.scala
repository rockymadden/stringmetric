package com.rockymadden.stringmetric

/** Trait for all filterable [[com.rockymadden.stringmetric.StringMetric]]. */
trait FilterableStringMetric extends StringMetric {
	def compare(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[CompareReturn]

	def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn]
}
