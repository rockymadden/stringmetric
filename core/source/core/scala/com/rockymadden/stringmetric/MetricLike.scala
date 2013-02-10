package com.rockymadden.stringmetric

trait MetricLike[T, R] {
	def compare(t1: T, t2: T): Option[R]
}
