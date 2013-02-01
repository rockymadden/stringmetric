package com.rockymadden.stringmetric

/** Trait for all filterable [[com.rockymadden.stringmetric.Algorithm]]. */
trait FilterableAlgorithm[T, F <: Filter[T]] extends Algorithm[T] {
	def compute(t: T)(implicit f: F): Option[ComputeReturn]
}
