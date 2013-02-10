package com.rockymadden.stringmetric

trait FilterLike[T] {
	def filter(t: T): T
}
