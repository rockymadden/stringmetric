package com.rockymadden.stringmetric

/** Trait for all filterable [[com.rockymadden.stringmetric.Metric]]. */
trait FilterableMetric[T, F <: Filter[T]] extends Metric[T] {
	def compare(t1: T, t2: T)(implicit f: F): Option[CompareReturn]
}
