package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.StringMetric
import com.rockymadden.stringmetric.phonetic.Alphabet._

/** An implementation of the NYSIIS metric. */
class NysiisMetric extends StringMetric[Boolean] {
	final override def compare(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] = {
		val unequal = (c1: Char, c2: Char) => {
			val lc1 = c1.toLower
			val lc2 = c2.toLower

			(if (lc1 == 'k') 'c' else lc1) != (if (lc2 == 'k') 'c' else lc2)
		}

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || !(fca1.head is Alpha) || fca2.length == 0 || !(fca2.head is Alpha)) None
		else if (unequal(fca1.head, fca2.head)) Some(false)
		else {
			val nysiisAlgorithm = NysiisAlgorithm()

			nysiisAlgorithm.compute(fca1).filter(_.length > 0).flatMap(ny1 =>
				nysiisAlgorithm.compute(fca2).filter(_.length > 0).map(ny1.sameElements(_)))
		}
	}

	final override def compare(string1: String, string2: String): Option[Boolean] =
		compare(filter(string1.toCharArray), filter(string2.toCharArray))
}

object NysiisMetric {
	def apply(): NysiisMetric = new NysiisMetric
}
