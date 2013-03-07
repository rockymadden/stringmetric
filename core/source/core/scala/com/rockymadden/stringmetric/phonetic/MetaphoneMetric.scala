package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{ StringFilter, StringMetric }
import com.rockymadden.stringmetric.phonetic.Alphabet.Alpha

/** A implementation of the Metaphone metric. */
class MetaphoneMetric extends StringMetric[Boolean] {
	this: StringFilter =>

	final override def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] = {
		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || !(Alpha isSuperset fca1.head) || fca2.length == 0 || !(Alpha isSuperset fca2.head)) None
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
	def apply(): MetaphoneMetric = new MetaphoneMetric with StringFilter
}
