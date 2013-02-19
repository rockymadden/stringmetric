package com.rockymadden.stringmetric

trait ConfigurableMetric[T, R, O] {
	def compare(t1: T, t2: T)(implicit o: O): Option[R]
}
