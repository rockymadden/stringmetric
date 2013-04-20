package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{CompareTuple, MatchTuple, StringFilter, StringMetric}
import scala.collection.mutable.{ArrayBuffer, HashSet}

/**
 * An implementation of the Jaro metric. One differing detail in this implementation is that if a character is matched
 * in string2, it cannot be matched upon again. This results in a more penalized distance in these scenarios.
 */
class JaroMetric extends StringMetric[DummyImplicit, Double] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit di: DummyImplicit): Option[Double] = {

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || fca2.length == 0) None
		else if (fca1.sameElements(fca2)) Some(1d)
		else {
			val mt = `match`(fca1, fca2)
			val ms = scoreMatches(mt._1, mt._2)

			if (ms == 0) Some(0d)
			else {
				val ts = scoreTranspositions(mt._1, mt._2)

				Some(((ms.toDouble / fca1.length) + (ms.toDouble / fca2.length) + ((ms.toDouble - ts) / ms)) / 3)
			}
		}
	}

	final override def compare(string1: String, string2: String)(implicit di: DummyImplicit): Option[Double] =
		compare(string1.toCharArray, string2.toCharArray)

	private[this] def `match`(ct: CompareTuple[Char]): MatchTuple[Char] = {
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

	private[this] def scoreMatches(mt: MatchTuple[Char]) = {
		require(mt._1.length == mt._2.length)

		mt._1.length
	}

	private[this] def scoreTranspositions(mt: MatchTuple[Char]) = {
		require(mt._1.length == mt._2.length)

		(mt._1.zip(mt._2).count(t => t._1 != t._2) / 2d).floor.toInt
	}
}

object JaroMetric {
	private lazy val self = apply()

	def apply(): JaroMetric = new JaroMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char]) = self.compare(charArray1, charArray2)

	def compare(string1: String, string2: String) = self.compare(string1, string2)
}
