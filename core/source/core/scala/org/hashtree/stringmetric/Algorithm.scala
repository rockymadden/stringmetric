package org.hashtree.stringmetric

/** Marks those which leverage traits of a stand alone algorithm. */
trait Algorithm[T, C] {
	def compute(t: T)(implicit c: C): Option[T]
}