package org.hashtree.stringmetric

import scala.collection.mutable.{ ArrayBuffer, HashSet }
import scala.math
import scala.util.control.Breaks.{ break, breakable }

/**
 * An implementation of the Jaro [[org.hashtree.stringmetric.StringMetric]]. One differing detail in this implementation
 * is that if a character is matched in string2, it cannot be matched upon again. This results in a more penalized
 * distance in these scenarios.
 */
object JaroMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Float = {
		val ca1 = stringCleaner.clean(charArray1)
		val ca2 = stringCleaner.clean(charArray2)

		// Return 0 if either character array lacks length.
		if (ca1.length == 0 || ca2.length == 0) return 0f

		val mt = `match`((ca1, ca2))
		val ms = scoreMatches((mt._1, mt._2))
		val ts = scoreTranspositions((mt._1, mt._2))

		// Return 0 if matches score is 0.
		if (ms == 0) return 0f

		((ms.toFloat / ca1.length) + (ms.toFloat / ca2.length) + ((ms.toFloat - ts) / ms)) / 3
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Float = {
		// Return 1 if strings are an exact match.
		if (string1.length > 0 && string2.length > 0 && string1 == string2) return 1f

		compare(stringCleaner.clean(string1.toCharArray), stringCleaner.clean(string2.toCharArray))(new StringCleanerDelegate)
	}

	private[this] def `match`(ct: CompareTuple) = {
		val window = math.abs((math.max(ct._1.length, ct._2.length) / 2f).floor.toInt - 1)
		val one = ArrayBuffer[Int]()
		val two = HashSet[Int]()

		breakable {
			for (i <- 0 until ct._1.length) {
				val start = if (i - window <= 0) 0 else i - window
				val end = if (i + window >= ct._2.length - 1) ct._2.length - 1 else i + window

				if (start > ct._2.length - 1) break()

				breakable {
					for (ii <- start to end if !two.contains(ii)) {
						if (ct._1(i) == ct._2(ii)) {
							one += i
							two += ii

							break()
						}
					}
				}
			}
		}

		(one.toArray.map(ct._1(_)), two.toArray.sortWith(_ < _).map(ct._2(_)))
	}

	private[this] def scoreMatches(mt: MatchTuple) = {
		require(mt._1.length == mt._2.length)

		mt._1.length
	}

	private[this] def scoreTranspositions(mt: MatchTuple) = {
		require(mt._1.length == mt._2.length)

		(mt._1.zip(mt._2).filter(t => t._1 != t._2).length / 2f).floor.toInt
	}
}