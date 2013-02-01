package com.rockymadden.stringmetric

/** Trait for all filterable and configurable [[com.rockymadden.stringmetric.Metric]]. */
trait FilterableConfigurableMetric[T, O, F <: Filter[T]] extends Metric[T] {
	def compare(t1: T, t2: T)(o: O)(implicit f: F): Option[CompareReturn]
}
