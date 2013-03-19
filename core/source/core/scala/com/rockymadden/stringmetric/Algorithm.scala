package com.rockymadden.stringmetric

trait Algorithm[T, O, R] {
	def compute(t: T)(implicit o: O): Option[R]
}
