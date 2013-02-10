package com.rockymadden.stringmetric

trait ConfigurableStringMetricLike[R, O] extends ConfigurableMetricLike[String, R, O] { this: StringFilterLike =>
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit o: O): Option[R]

	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}
