package com.rockymadden.stringmetric

trait Algorithm[A] {
	def compute(a: A): Option[A]
}
