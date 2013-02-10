package com.rockymadden.stringmetric

trait AlgorithmLike[T, R] {
	def compute(t: T): Option[R]
}
