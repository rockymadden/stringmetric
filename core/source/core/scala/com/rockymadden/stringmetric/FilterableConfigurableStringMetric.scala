package com.rockymadden.stringmetric

/** Trait for all filterable and configurable [[com.rockymadden.stringmetric.StringMetric]]. */
trait FilterableConfigurableStringMetric[O] extends StringMetric {
	def compare(string1: String, string2: String)(o: O)(implicit stringFilter: StringFilter): Option[CompareReturn]

	def compare(charArray1: Array[Char], charArray2: Array[Char])(o: O)
		(implicit stringFilter: StringFilter): Option[CompareReturn]
}
