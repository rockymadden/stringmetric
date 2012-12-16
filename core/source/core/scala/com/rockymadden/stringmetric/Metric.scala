package com.rockymadden.stringmetric

/** Marks those which leverage traits of a metric. */
trait Metric[T] {
	type CompareReturn <: AnyVal
}