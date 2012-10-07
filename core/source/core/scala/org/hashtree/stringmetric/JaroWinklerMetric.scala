package org.hashtree.stringmetric

import scala.collection.mutable.ArrayBuffer
import scala.math
import scala.util.control.Breaks.{ break, breakable }

/**
 * An implementation of the Jaro-Winkler string metric. One differing detail in this implementation is that if a
 * character is matched in string2, it cannot be matched upon again. This results in a more penalized distance in these
 * scenarios (e.g. comparing henka and henkan distance is 0.9666 versus the typical 0.9722).
 */
object JaroWinklerMetric extends StringMetric {
	override def compare(string1: String, string2: String): Float = {
		val ca1 = string1.replaceAllLiterally(" ", "").toLowerCase.toCharArray
		val ca2 = string2.replaceAllLiterally(" ", "").toLowerCase.toCharArray
		val prefix = ca1.zip(ca2).takeWhile(t => t._1 == t._2).map(_._1)
		val jaro = JaroMetric.compare(string1, string2)

		jaro + ((if (prefix.length <= 4) prefix.length else 4) * (0.1f * (1 - jaro)))
	}
}