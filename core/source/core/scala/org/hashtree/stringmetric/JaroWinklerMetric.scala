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

	override def compare(s1: String, s2: String): Float = {
		val charArray1 = s1.replaceAllLiterally(" ", "").toLowerCase.toCharArray
		val charArray2 = s2.replaceAllLiterally(" ", "").toLowerCase.toCharArray

		// Return 0 if either character array lacks length.
		if (charArray1.length == 0 || charArray2.length == 0) return 0f

		val matchTuple = `match`(charArray1, charArray2)
		val matchesScore = scoreMatches(matchTuple._1, matchTuple._2)
		val transpositionsScore = scoreTranspositions(matchTuple._1, matchTuple._2)

		// Return 0 if matches score is 0.
		if (matchesScore == 0) return 0f

		val prefix = charArray1.zip(charArray2).takeWhile(t => t._1 == t._2).map(_._1)
		val jaro = (
			(matchesScore.toFloat / charArray1.length) +
			(matchesScore.toFloat / charArray2.length) +
			((matchesScore.toFloat - transpositionsScore) / matchesScore)
		) / 3

		// Add Winkler.
		jaro + ((if (prefix.length <= 4) prefix.length else 4) * (0.1f * (1 - jaro)))
	}

	private[this] def `match`(ct: CompareTuple): MatchTuple = {
		val window = math.abs((math.max(ct._1.length, ct._2.length) / 2f).floor.toInt - 1)
		val a1Indices = ArrayBuffer[Int]()
		val a2Indices = ArrayBuffer[Int]()

		breakable {
			for (i <- 0 until ct._1.length) {
				val start = if (i - window <= 0) 0 else i - window
				val end = if (i + window >= ct._2.length - 1) ct._2.length - 1 else i + window

				if (start > ct._2.length - 1) break()

				breakable {
					for (ii <- start to end if ! a2Indices.contains(ii)) {
						if (ct._1(i) == ct._2(ii)) {
							a1Indices.append(i)
							a2Indices.append(ii)

							break()
						}
					}
				}
			}
		}

		(a1Indices.map(ct._1(_)).toArray, a2Indices.sortWith(_ < _).map(ct._2(_)).toArray)
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