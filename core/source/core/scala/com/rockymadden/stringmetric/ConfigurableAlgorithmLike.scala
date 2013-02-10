package com.rockymadden.stringmetric

trait ConfigurableAlgorithmLike[T, R, O] {
	def compute(t: T)(implicit o: O): Option[R]
}
