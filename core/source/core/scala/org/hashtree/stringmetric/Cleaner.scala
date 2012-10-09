package org.hashtree.stringmetric

/** Marks those which leverage traits of a cleaner. */
trait Cleaner[T] {
	def clean(t: T): T
}