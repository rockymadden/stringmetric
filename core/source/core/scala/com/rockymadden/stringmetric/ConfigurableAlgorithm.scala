package com.rockymadden.stringmetric

trait ConfigurableAlgorithm[T, O, R] {
	def compute(t: T)(implicit o: O): Option[R]
}
