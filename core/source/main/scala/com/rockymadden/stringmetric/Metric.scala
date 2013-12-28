package com.rockymadden.stringmetric

object Metric {
	trait MetricLike[A, B] {
		def compare(a1: A, a2: A): Option[B]
	}


	trait StringMetricLike[A] extends MetricLike[Array[Char], A] {
		def compare(string1: String, string2: String): Option[A]
	}
}
