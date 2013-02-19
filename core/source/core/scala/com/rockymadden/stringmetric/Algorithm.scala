package com.rockymadden.stringmetric

trait Algorithm[T, R] {
	def compute(t: T): Option[R]
}
