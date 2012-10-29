package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ StringFilter, StringFilterDelegate, StringMetric }

/** An implementation of the NYSIIS [[org.hashtree.stringmetric.StringMetric]]. */
object NysiisMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[Boolean] = {
		val ca1 = stringFilter.filter(charArray1)
		val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else {
			val ny1 = NysiisAlgorithm.compute(ca1)
			val ny2 = NysiisAlgorithm.compute(ca2)

			if (!ny1.isDefined || !ny2.isDefined || (ny1.get.length == 0 && ny2.get.length == 0)) None
			else Some(ny1.get.sameElements(ny2.get))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringFilter: StringFilter): Option[Boolean] =
		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)
}