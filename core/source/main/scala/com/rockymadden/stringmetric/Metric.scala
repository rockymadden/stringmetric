package com.rockymadden.stringmetric

trait Metric[A, B, C] {
	def compare(a1: A, a2: A)(implicit b: B): Option[C]
}
