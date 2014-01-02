package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.Metric.StringMetric

/**
 * An implementation of the Jaro-Winkler metric. One differing detail in this implementation is that if a character is
 * matched in string2, it cannot be matched upon again. This results in a more penalized distance in these scenarios
 * (e.g. comparing henka and henkan distance is 0.9666 versus the typical 0.9722).
 */
case object JaroWinklerMetric extends StringMetric[Double] {
	override def compare(a: Array[Char], b: Array[Char]): Option[Double] =
		JaroMetric.compare(a, b).map {
			case 0d => 0d
			case 1d => 1d
			case jaro => {
				val prefix = a.zip(b).takeWhile(t => t._1 == t._2)

				jaro + ((if (prefix.length <= 4) prefix.length else 4) * 0.1d * (1 - jaro))
			}
		}

	override def compare(a: String, b: String): Option[Double] = compare(a.toCharArray, b.toCharArray)
}
