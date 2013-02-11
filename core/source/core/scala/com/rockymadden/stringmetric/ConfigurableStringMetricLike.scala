package com.rockymadden.stringmetric

trait ConfigurableStringMetricLike[R, O] extends ConfigurableMetricLike[String, R, O] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit o: O): Option[R]
}
