package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{ StringFilter, StringMetric }
import com.rockymadden.stringmetric.phonetic.Alphabet.Alpha

/** An implementation of the Soundex metric. */
class SoundexMetric extends StringMetric[Boolean] {
	this: StringFilter =>

	final override def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] = {
		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || !(Alpha isSuperset fca1.head) || fca2.length == 0 || !(Alpha isSuperset fca2.head)) None
		else if (fca1.head.toLower != fca2.head.toLower) Some(false)
		else {
			val soundexAlgorithm = SoundexAlgorithm()

			soundexAlgorithm.compute(fca1).filter(_.length > 0).flatMap(se1 =>
				soundexAlgorithm.compute(fca2).filter(_.length > 0).map(se1.sameElements(_)))
		}
	}

	final override def compare(string1: String, string2: String): Option[Boolean] =
		compare(filter(string1.toCharArray), filter(string2.toCharArray))
}

object SoundexMetric {
	def apply(): SoundexMetric = new SoundexMetric with StringFilter
}
