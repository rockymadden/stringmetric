package com.rockymadden.stringmetric

object Metric {
	trait Metric[A, B] {
		def compare(a: A, b: A): Option[B]
	}


	trait StringMetric[A] extends Metric[Array[Char], A] {
		def compare(a: String, b: String): Option[A]
	}
}
