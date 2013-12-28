package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.Metric.StringMetricLike

case object NysiisMetric extends StringMetricLike[Boolean] {
	import com.rockymadden.stringmetric.Alphabet.Alpha

	override def compare(a: Array[Char], b: Array[Char]): Option[Boolean] = {
		val unequal = (c1: Char, c2: Char) => {
			val lc1 = c1.toLower
			val lc2 = c2.toLower

			(if (lc1 == 'k') 'c' else lc1) != (if (lc2 == 'k') 'c' else lc2)
		}

		if (a.length == 0 || !(Alpha isSuperset a.head) || b.length == 0 || !(Alpha isSuperset b.head)) None
		else if (unequal(a.head, b.head)) Some(false)
		else NysiisAlgorithm.compute(a).filter(_.length > 0).flatMap(ny1 =>
			NysiisAlgorithm.compute(b).filter(_.length > 0).map(ny1.sameElements(_))
		)
	}

	override def compare(a: String, b: String): Option[Boolean] = compare(a.toCharArray, b.toCharArray)
}
