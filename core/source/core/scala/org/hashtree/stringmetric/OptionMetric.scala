package org.hashtree.stringmetric

/** Marks those which leverage traits of an option metric. */
trait OptionMetric[T, O, F <: Filter[T]] {
	def compare(t1: T, t2: T)(o: O)(implicit f: F): Option[AnyVal]
}