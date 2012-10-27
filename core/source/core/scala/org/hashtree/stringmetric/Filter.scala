package org.hashtree.stringmetric

/** Marks those which leverage traits of a filter. */
trait Filter[T] {
	def filter(t: T): T
}