package com.rockymadden.stringmetric

object Metric {
	trait MetricLike[A, B] {
		def compare(a: A, b: A): Option[B]
	}


	trait StringMetricLike[A] extends MetricLike[Array[Char], A] {
		def compare(a: String, b: String): Option[A]
	}
}
