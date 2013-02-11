package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.StringMetric
import com.rockymadden.stringmetric.phonetic.Alphabet._

/** A implementation of Metaphone metric. */
class MetaphoneMetric extends StringMetric[Boolean] {
	final override def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] = {
		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || !(fca1.head is Alpha) || fca2.length == 0 || !(fca2.head is Alpha)) None
		else {
			val metaphoneAlgorithm = MetaphoneAlgorithm()

			metaphoneAlgorithm.compute(fca1).filter(_.length > 0).flatMap(mp1 =>
				metaphoneAlgorithm.compute(fca2).filter(_.length > 0).map(mp1.sameElements(_)))
		}
	}

	final override def compare(string1: String, string2: String): Option[Boolean] =
		compare(filter(string1.toCharArray), filter(string2.toCharArray))
}

object MetaphoneMetric {
	def apply(): MetaphoneMetric = new MetaphoneMetric
}
