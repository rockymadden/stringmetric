package org.hashtree.stringmetric

/** Marks those which leverage traits of a filterable and configurable [[org.hashtree.stringmetric.Algorithm]]. */
trait FilterableConfigurableAlgorithm[T, O, F <: Filter[T]] extends Algorithm[T] {
	def compute(t: T)(o: O)(implicit f: F): Option[AnyRef]
}