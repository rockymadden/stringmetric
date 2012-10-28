package org.hashtree.stringmetric

/** Marks those which leverage traits of a stand alone algorithm. */
trait Algorithm[T, F <: Filter[T]] {
	def compute(t: T)(implicit f: F): Option[T]
}