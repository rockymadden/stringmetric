package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.Metric.StringMetric

case object SoundexMetric extends StringMetric[Boolean] {
	import com.rockymadden.stringmetric.Alphabet.Alpha

	override def compare(a: Array[Char], b: Array[Char]): Option[Boolean] =
		if (a.length == 0 || !(Alpha isSuperset a.head) || b.length == 0 || !(Alpha isSuperset b.head)) None
		else if (a.head.toLower != b.head.toLower) Some(false)
		else SoundexAlgorithm.compute(a).filter(_.length > 0).flatMap { se1 =>
			SoundexAlgorithm.compute(b).filter(_.length > 0).map(se1.sameElements(_))
		}

	final override def compare(a: String, b: String): Option[Boolean] = compare(a.toCharArray, b.toCharArray)
}
