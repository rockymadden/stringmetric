package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringMetric, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate

/** An implementation of the refined NYSIIS [[org.hashtree.stringmetric.StringMetric]]. */
object RefinedNysiisMetric extends StringMetric with FilterableStringMetric {
	type CompareReturn = Boolean

	override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		val ca1 = stringFilter.filter(charArray1)
		lazy val ca2 = stringFilter.filter(charArray2)
		val unequal = (c1: Char, c2: Char) => {
			val c1l = c1.toLower
			val c2l = c2.toLower

			(if (c1l == 'k') 'c' else c1l) != (if (c2l == 'k') 'c' else c2l)
		}

		if (ca1.length == 0 || !Alphabet.is(ca1.head) || ca2.length == 0 || !Alphabet.is(ca2.head)) None
		else if (unequal(ca1.head, ca2.head)) Some(false)
		else {
			val rny1 = RefinedNysiisAlgorithm.compute(ca1)
			lazy val rny2 = RefinedNysiisAlgorithm.compute(ca2)

			if (!rny1.isDefined || rny1.get.length == 0 || !rny2.isDefined || rny2.get.length == 0) None
			else Some(rny1.get.sameElements(rny2.get))
		}
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}