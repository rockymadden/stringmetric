package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based Metric. */
trait StringMetric extends Metric[String] {
	def compare(ca1: Array[Char], ca2: Array[Char]): AnyVal
}