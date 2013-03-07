package com.rockymadden.stringmetric

trait Filter[T] extends Filterable[T] {
	override def filter(t: T): T = t
}
