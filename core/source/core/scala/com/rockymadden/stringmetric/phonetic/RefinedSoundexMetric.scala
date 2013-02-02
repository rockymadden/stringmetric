package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{ FilterableStringMetric, StringFilter, StringMetric }
import com.rockymadden.stringmetric.phonetic.Alphabet._

/** An implementation of the refined Soundex [[com.rockymadden.stringmetric.StringMetric]]. */
object RefinedSoundexMetric extends StringMetric with FilterableStringMetric {
	type CompareReturn = Boolean

	override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		val fca1 = stringFilter.filter(charArray1)
		lazy val fca2 = stringFilter.filter(charArray2)

		if (fca1.length == 0 || !(fca1.head is Alpha) || fca2.length == 0 || !(fca2.head is Alpha)) None
		else if (fca1.head.toLower != fca2.head.toLower) Some(false)
		else RefinedSoundexAlgorithm.compute(fca1).filter(_.length > 0).flatMap(rse1 =>
			RefinedSoundexAlgorithm.compute(fca2).filter(_.length > 0).map(rse1.sameElements(_)))
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(stringFilter.filter(string1.toCharArray), stringFilter.filter(string2.toCharArray))
}
