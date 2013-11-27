package com.rockymadden.stringmetric

trait Filterable[A] {
	def filter(a: A): A
}
