package com.rockymadden.stringmetric

trait Filterable[T] {
	def filter(t: T): T
}
