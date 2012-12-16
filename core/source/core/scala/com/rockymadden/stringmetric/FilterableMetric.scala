package com.rockymadden.stringmetric

/** Marks those which leverage traits of a filterable [[com.rockymadden.stringmetric.Metric]]. */
trait FilterableMetric[T, F <: Filter[T]] extends Metric[T] {
	def compare(t1: T, t2: T)(implicit f: F): Option[CompareReturn]
}