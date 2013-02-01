package com.rockymadden.stringmetric

/** Trait for all filterable [[com.rockymadden.stringmetric.StringAlgorithm]]. */
trait FilterableStringAlgorithm extends StringAlgorithm {
	def compute(string: String)(implicit stringFilter: StringFilter): Option[ComputeReturn]

	def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[_]]
}
