package com.rockymadden.stringmetric

trait ConfigurableAlgorithm[T, R, O] {
	def compute(t: T)(implicit o: O): Option[R]
}
