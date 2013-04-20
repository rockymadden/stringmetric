package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{StringFilter, StringMetric}
import com.rockymadden.stringmetric.Alphabet.Alpha

/** An implementation of the refined NYSIIS metric. */
class RefinedNysiisMetric extends StringMetric[DummyImplicit, Boolean] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit di: DummyImplicit): Option[Boolean] = {

		val unequal = (c1: Char, c2: Char) => {
			val lc1 = c1.toLower
			val lc2 = c2.toLower

			(if (lc1 == 'k') 'c' else lc1) != (if (lc2 == 'k') 'c' else lc2)
		}

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || !(Alpha isSuperset fca1.head) || fca2.length == 0 || !(Alpha isSuperset fca2.head)) None
		else if (unequal(fca1.head, fca2.head)) Some(false)
		else RefinedNysiisAlgorithm.compute(fca1).filter(_.length > 0).flatMap(rny1 =>
			RefinedNysiisAlgorithm.compute(fca2).filter(_.length > 0).map(rny1.sameElements(_))
		)
	}

	final override def compare(string1: String, string2: String)(implicit di: DummyImplicit): Option[Boolean] =
		compare(string1.toCharArray, string2.toCharArray)
}

object RefinedNysiisMetric {
	private lazy val self = apply()

	def apply(): RefinedNysiisMetric = new RefinedNysiisMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char]) = self.compare(charArray1, charArray2)

	def compare(string1: String, string2: String) = self.compare(string1, string2)
}
