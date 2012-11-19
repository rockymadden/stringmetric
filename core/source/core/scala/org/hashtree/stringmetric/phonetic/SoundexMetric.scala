package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringMetric, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate

/** An implementation of the Soundex [[org.hashtree.stringmetric.StringMetric]]. */
object SoundexMetric extends StringMetric with FilterableStringMetric {
	type CompareReturn = Boolean

	override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		val ca1 = stringFilter.filter(charArray1)
		lazy val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || !Alphabet.is(ca1.head) || ca2.length == 0 || !Alphabet.is(ca2.head)) None
		else if (ca1.head.toLower != ca2.head.toLower) Some(false)
		else {
			val se1 = SoundexAlgorithm.compute(ca1)
			lazy val se2 = SoundexAlgorithm.compute(ca2)

			if (!se1.isDefined || se1.get.length == 0 || !se2.isDefined || se2.get.length == 0) None
			else Some(se1.get.sameElements(se2.get))
		}
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}