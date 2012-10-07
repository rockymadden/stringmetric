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
	type CompareTuple = Tuple2[Array[Char], Array[Char]]
	type MatchTuple = CompareTuple

	override def compare(string1: String, string2: String): Float = {
		val ca1 = string1.replaceAllLiterally(" ", "").toLowerCase.toCharArray
		val ca2 = string2.replaceAllLiterally(" ", "").toLowerCase.toCharArray

		// Return 0 if either character array lacks length.
		if (ca1.length == 0 || ca2.length == 0) return 0f

		val mt = `match`(ca1, ca2)
		val ms = scoreMatches(mt._1, mt._2)
		val ts = scoreTranspositions(mt._1, mt._2)

		// Return 0 if matches score is 0.
		if (ms == 0) return 0f

		val prefix = ca1.zip(ca2).takeWhile(t => t._1 == t._2).map(_._1)
		val jaro = (
			(ms.toFloat / ca1.length) +
			(ms.toFloat / ca2.length) +
			((ms.toFloat - ts) / ms)
		) / 3

		// Add Winkler.
		jaro + ((if (prefix.length <= 4) prefix.length else 4) * (0.1f * (1 - jaro)))
	}

	private[this] def `match`(ct: CompareTuple): MatchTuple = {
		val window = math.abs((math.max(ct._1.length, ct._2.length) / 2f).floor.toInt - 1)
		val a1 = ArrayBuffer[Int]()
		val a2 = ArrayBuffer[Int]()

		breakable {
			for (i <- 0 until ct._1.length) {
				val start = if (i - window <= 0) 0 else i - window
				val end = if (i + window >= ct._2.length - 1) ct._2.length - 1 else i + window

				if (start > ct._2.length - 1) break()

				breakable {
					for (ii <- start to end if ! a2.contains(ii)) {
						if (ct._1(i) == ct._2(ii)) {
							a1.append(i)
							a2.append(ii)

							break()
						}
					}
				}
			}
		}

		(a1.map(ct._1(_)).toArray, a2.sortWith(_ < _).map(ct._2(_)).toArray)
	}

	private[this] def scoreMatches(mt: MatchTuple): Int = {
		require(mt._1.length == mt._2.length)

		mt._1.length
	}

	private[this] def scoreTranspositions(mt: MatchTuple): Int = {
		require(mt._1.length == mt._2.length)

		(mt._1.zip(mt._2).filter(t => t._1 != t._2).length / 2f).floor.toInt
	}
}