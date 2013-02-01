package com.rockymadden.stringmetric

/** Trait for all filterable and configurable [[com.rockymadden.stringmetric.StringAlgorithm]]. */
trait FilterableConfigurableStringAlgorithm[O] extends StringAlgorithm {
	def compute(string: String)(o: O)(implicit stringFilter: StringFilter): Option[ComputeReturn]

	def compute(charArray: Array[Char])(o: O)(implicit stringFilter: StringFilter): Option[Array[_]]
}
