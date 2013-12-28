package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.Metric.StringMetricLike

case object HammingMetric extends StringMetricLike[Int] {
	import com.rockymadden.stringmetric.CompareTuple

	override def compare(a: Array[Char], b: Array[Char]): Option[Int] =
		if (a.length == 0 || b.length == 0 || a.length != b.length) None
		else if (a.sameElements(b)) Some(0)
		else Some(hamming(a, b))

	override def compare(a: String, b: String): Option[Int] = compare(a.toCharArray, b.toCharArray)

	private val hamming: (CompareTuple[Char] => Int) = (ct) =>
		if (ct._1.length == 0) 0
		else ct._1.zip(ct._2).count(t => t._1 != t._2)
}
