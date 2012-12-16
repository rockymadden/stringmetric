package com.rockymadden.stringmetric

/** Marks those which leverage traits of a standalone algorithm. */
trait Algorithm[T] {
	type ComputeReturn <: AnyRef
}