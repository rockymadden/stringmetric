package com.rockymadden.stringmetric

trait Filter[A] extends Filterable[A] {
	override def filter(a: A): A = a
}
