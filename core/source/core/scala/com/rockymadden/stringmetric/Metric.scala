package com.rockymadden.stringmetric

/** Trait for all metrics. */
trait Metric[T] {
	type CompareReturn <: AnyVal
}
