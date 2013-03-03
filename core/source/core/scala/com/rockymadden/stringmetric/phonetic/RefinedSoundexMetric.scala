package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.StringMetric

/** An implementation of the refined Soundex metric. */
class RefinedSoundexMetric extends StringMetric[Boolean] {
	final override def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] = {
		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || !(Alpha isSuperset fca1.head) || fca2.length == 0 || !(Alpha isSuperset fca2.head)) None
		else if (fca1.head.toLower != fca2.head.toLower) Some(false)
		else {
			val refinedSoundexAlgorithm = RefinedSoundexAlgorithm()

			refinedSoundexAlgorithm.compute(fca1).filter(_.length > 0).flatMap(rse1 =>
				refinedSoundexAlgorithm.compute(fca2).filter(_.length > 0).map(rse1.sameElements(_)))
		}
	}

	final override def compare(string1: String, string2: String): Option[Boolean] =
		compare(filter(string1.toCharArray), filter(string2.toCharArray))
}

object RefinedSoundexMetric {
	def apply(): RefinedSoundexMetric = new RefinedSoundexMetric
}
