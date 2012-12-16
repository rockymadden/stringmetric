package com.rockymadden.stringmetric

/** Marks those which leverage traits of a filterable [[com.rockymadden.stringmetric.Algorithm]]. */
trait FilterableAlgorithm[T, F <: Filter[T]] extends Algorithm[T] {
	def compute(t: T)(implicit f: F): Option[ComputeReturn]
}