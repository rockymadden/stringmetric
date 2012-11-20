package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringMetric, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate

/** An implementation of the NYSIIS [[org.hashtree.stringmetric.StringMetric]]. */
object NysiisMetric extends StringMetric with FilterableStringMetric {
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
		else NysiisAlgorithm.compute(ca1).filter(_.length > 0).flatMap(ny1 =>
			NysiisAlgorithm.compute(ca2).filter(_.length > 0).map(ny1.sameElements(_))
		)
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}