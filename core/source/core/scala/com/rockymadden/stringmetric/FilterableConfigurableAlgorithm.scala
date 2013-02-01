package com.rockymadden.stringmetric

/** Trait for all filterable and configurable [[com.rockymadden.stringmetric.Algorithm]]. */
trait FilterableConfigurableAlgorithm[T, O, F <: Filter[T]] extends Algorithm[T] {
	def compute(t: T)(o: O)(implicit f: F): Option[ComputeReturn]
}
