package com.rockymadden.stringmetric

trait StringMetricLike[R] extends MetricLike[String, R] {
	def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[R]
}
