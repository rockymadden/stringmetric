package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{ StringFilter, StringMetric }
import com.rockymadden.stringmetric.phonetic.Alphabet.Alpha

/** An implementation of the refined Soundex metric. */
class RefinedSoundexMetric extends StringMetric[Boolean] {
	this: StringFilter =>

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
	private lazy val self = apply()

	def apply(): RefinedSoundexMetric = new RefinedSoundexMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char]) = self.compare(charArray1, charArray2)

	def compare(string1: String, string2: String) = self.compare(string1, string2)
}
