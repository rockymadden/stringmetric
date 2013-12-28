package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.Metric.StringMetricLike

case object LevenshteinMetric extends StringMetricLike[Int] {
	import com.rockymadden.stringmetric.CompareTuple

	override def compare(a: Array[Char], b: Array[Char]): Option[Int] =
		if (a.length == 0 || b.length == 0) None
		else if (a.sameElements(b)) Some(0)
		else Some(levenshtein(a, b))

	override def compare(a: String, b: String): Option[Int] = compare(a.toCharArray, b.toCharArray)

	private def levenshtein(ct: CompareTuple[Char]) = {
		val m = Array.fill[Int](ct._1.length + 1, ct._2.length + 1)(-1)

		def distance(t: (Int, Int)): Int = {
			t match {
				case (r, 0) => r
				case (0, c) => c
				case (r, c) if m(r)(c) != -1 => m(r)(c)
				case (r, c) => {
					val min =
						if (ct._1(r - 1) == ct._2(c - 1)) distance(r - 1, c - 1)
						else math.min(
							math.min(
								distance(r - 1, c) + 1, // Delete (left).
								distance(r, c - 1) + 1 // Insert (up).
							),
							distance(r - 1, c - 1) + 1 // Substitute (left-up).
						)

					m(r)(c) = min
					min
				}
			}
		}

		distance(ct._1.length, ct._2.length)
	}
}
