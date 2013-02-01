package com.rockymadden.stringmetric

/** Trait for all string based [[com.rockymadden.stringmetric.FilterableConfigurableMetric]]. */
trait FilterableConfigurableStringMetric[O]
	extends FilterableConfigurableMetric[String, O, StringFilter] with StringMetric {

	def compare(charArray1: Array[Char], charArray2: Array[Char])(o: O)
		(implicit stringFilter: StringFilter): Option[CompareReturn]
}
