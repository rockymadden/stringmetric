package org.hashtree.stringmetric

/** Marks those which leverage traits of a metric. */
trait Metric[T, C] {
	def compare(t1: T, t2: T)(implicit c: C): AnyVal
}