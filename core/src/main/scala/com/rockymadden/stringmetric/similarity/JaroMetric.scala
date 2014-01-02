package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.Metric.StringMetric
import scala.Some

/**
 * An implementation of the Jaro metric. One differing detail in this implementation is that if a character is matched
 * in string2, it cannot be matched upon again. This results in a more penalized distance in these scenarios.
 */
case object JaroMetric extends StringMetric[Double] {
	import com.rockymadden.stringmetric.{CompareTuple, MatchTuple}
	import scala.collection.mutable.{ArrayBuffer, HashSet}

	override def compare(a: Array[Char], b: Array[Char]): Option[Double] =
		if (a.length == 0 || b.length == 0) None
		else if (a.sameElements(b)) Some(1d)
		else {
			val mt = `match`(a, b)
			val ms = scoreMatches(mt._1, mt._2)

			if (ms == 0) Some(0d)
			else {
				val ts = scoreTranspositions(mt._1, mt._2)

				Some(((ms.toDouble / a.length) + (ms.toDouble / b.length) + ((ms.toDouble - ts) / ms)) / 3)
			}
		}

	override def compare(a: String, b: String): Option[Double] = compare(a.toCharArray, b.toCharArray)

	private val `match`: (CompareTuple[Char] => MatchTuple[Char]) = (ct) => {
		lazy val window = math.abs((math.max(ct._1.length, ct._2.length) / 2d).floor.toInt - 1)
		val one = ArrayBuffer.empty[Int]
		val two = HashSet.empty[Int]
		var i = 0
		var bi = false

		while (i < ct._1.length && !bi) {
			val start = if (i - window <= 0) 0 else i - window
			val end = if (i + window >= ct._2.length - 1) ct._2.length - 1 else i + window

			if (start > ct._2.length - 1) bi = !bi
			else {
				var ii = start
				var bii = false

				while (ii <= end && !bii) {
					if (!two.contains(ii) && ct._1(i) == ct._2(ii)) {
						one += i
						two += ii
						bii = !bii
					} else ii += 1
				}

				i += 1
			}
		}

		(one.toArray.map(ct._1(_)), two.toArray.sortWith(_ < _).map(ct._2(_)))
	}

	private val scoreMatches: (MatchTuple[Char] => Int) = (mt) => mt._1.length

	private val scoreTranspositions: (MatchTuple[Char] => Int) = (mt) =>
		(mt._1.zip(mt._2).count(t => t._1 != t._2) / 2d).floor.toInt
}
