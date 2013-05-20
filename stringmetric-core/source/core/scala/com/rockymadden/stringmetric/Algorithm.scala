package com.rockymadden.stringmetric

trait Algorithm[A, B, C] {
	def compute(a: A)(implicit b: B): Option[C]
}
