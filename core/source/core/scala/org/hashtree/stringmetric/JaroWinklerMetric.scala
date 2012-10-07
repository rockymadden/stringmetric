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
	override def compare(s1: String, s2: String): Float = {
		val ca1 = s1.replaceAllLiterally(" ", "").toLowerCase.toCharArray
		val ca2 = s2.replaceAllLiterally(" ", "").toLowerCase.toCharArray

		// Return 0 if either character array lacks length.
		if (ca1.length == 0 || ca2.length == 0) return 0f

		val (m1, m2) = matchChars(ca1, ca2)
		val matchesScore = scoreMatches(m1, m2)
		val transpositionsScore = scoreTranspositions(m1, m2)

		// Return 0 if matches score is 0.
		if (matchesScore == 0) return 0f

		val prefix = ca1.zip(ca2).takeWhile(t => t._1 == t._2).map(_._1).mkString
		val jaro = (
			(matchesScore.toFloat / ca1.length) +
			(matchesScore.toFloat / ca2.length) +
			((matchesScore.toFloat - transpositionsScore) / matchesScore.toFloat)
		) / 3

		jaro + ((if (prefix.length <= 4) prefix.length else 4) * (.1f * (1 - jaro)))
	}

	private[this] def matchChars(ca1: Array[Char], ca2: Array[Char]): Tuple2[Array[Char], Array[Char]] = {
		val window = math.abs((math.max(ca1.length, ca2.length) / 2f).floor.toInt - 1)
		val a1Indices = ArrayBuffer[Int]()
		val a2Indices = ArrayBuffer[Int]()

		breakable {
			for (i <- 0 until ca1.length) {
				val start = if (i - window <= 0) 0 else i - window
				val end = if (i + window >= ca2.length - 1) ca2.length - 1 else i + window

				if (start > ca2.length) break

				breakable {
					for (ii <- start to end if ! a2Indices.contains(ii)) {
						if (ca1(i) == ca2(ii)) {
							a1Indices.append(i)
							a2Indices.append(ii)

							break
						}
					}
				}
			}
		}

		(a1Indices.map(i => ca1(i)).toArray, a2Indices.sortWith(_ < _).map(i => ca2(i)).toArray)
	}

	private[this] def scoreMatches(mca1: Array[Char], mca2: Array[Char]): Int = {
		require(mca1.length == mca2.length)

		mca1.length
	}

	private[this] def scoreTranspositions(mca1: Array[Char], mca2: Array[Char]): Int = {
		require(mca1.length == mca2.length)

		(mca1.zip(mca2).filter(t => t._1 != t._2).length / 2f).floor.toInt
	}
}