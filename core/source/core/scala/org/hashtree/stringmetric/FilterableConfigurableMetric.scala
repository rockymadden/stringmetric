package org.hashtree.stringmetric

/** Marks those which leverage traits of a filterable and configurable [[org.hashtree.stringmetric.Metric]]. */
trait FilterableConfigurableMetric[T, O, F <: Filter[T]] extends Metric[T] {
	def compare(t1: T, t2: T)(o: O)(implicit f: F): Option[CompareReturn]
}