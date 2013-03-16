package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{ StringFilter, StringMetric }
import com.rockymadden.stringmetric.phonetic.Alphabet.Alpha

/** An implementation of the NYSIIS metric. */
class NysiisMetric extends StringMetric[Boolean] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] = {
		val unequal = (c1: Char, c2: Char) => {
			val lc1 = c1.toLower
			val lc2 = c2.toLower

			(if (lc1 == 'k') 'c' else lc1) != (if (lc2 == 'k') 'c' else lc2)
		}

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || !(Alpha isSuperset fca1.head) || fca2.length == 0 || !(Alpha isSuperset fca2.head)) None
		else if (unequal(fca1.head, fca2.head)) Some(false)
		else {
			val nysiisAlgorithm = NysiisAlgorithm()

			nysiisAlgorithm.compute(fca1).filter(_.length > 0).flatMap(ny1 =>
				nysiisAlgorithm.compute(fca2).filter(_.length > 0).map(ny1.sameElements(_)))
		}
	}

	final override def compare(string1: String, string2: String): Option[Boolean] =
		compare(string1.toCharArray, string2.toCharArray)
}

object NysiisMetric {
	private lazy val self = apply()

	def apply(): NysiisMetric = new NysiisMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char]) = self.compare(charArray1, charArray2)

	def compare(string1: String, string2: String) = self.compare(string1, string2)
}
