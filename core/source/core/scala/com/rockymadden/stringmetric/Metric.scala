package com.rockymadden.stringmetric

trait Metric[T, R] {
	def compare(t1: T, t2: T): Option[R]
}
