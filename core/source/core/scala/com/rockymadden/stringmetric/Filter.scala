package com.rockymadden.stringmetric

/** Trait for all filters. */
trait Filter[T] {
	def filter(t: T): T
}
