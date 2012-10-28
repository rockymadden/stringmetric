package org.hashtree.stringmetric

/** Marks those which leverage traits of a metric. */
trait Metric[T, F <: Filter[T]] {
	def compare(t1: T, t2: T)(implicit f: F): Option[AnyVal]
}