package com.rockymadden.stringmetric

trait Metric[T, O, R] {
	def compare(t1: T, t2: T)(implicit o: O): Option[R]
}
