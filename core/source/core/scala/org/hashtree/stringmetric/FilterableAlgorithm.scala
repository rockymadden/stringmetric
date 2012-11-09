package org.hashtree.stringmetric

/** Marks those which leverage traits of a filterable [[org.hashtree.stringmetric.Algorithm]]. */
trait FilterableAlgorithm[T, F <: Filter[T]] extends Algorithm[T] {
	def compute(t: T)(implicit f: F): Option[AnyRef]
}