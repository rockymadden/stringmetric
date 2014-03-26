package com.rockymadden.stringmetric

trait Metric[A, B] {
	def compare(a: A, b: A): Option[B]
}
