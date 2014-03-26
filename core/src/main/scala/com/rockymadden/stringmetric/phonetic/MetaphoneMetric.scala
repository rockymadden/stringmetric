package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric._
import com.rockymadden.stringmetric.Alphabet._

case object MetaphoneMetric extends StringMetric[Boolean] {
	override def compare(a: Array[Char], b: Array[Char]): Option[Boolean] =
		if (a.length == 0 || !(Alpha isSuperset a.head) || b.length == 0 || !(Alpha isSuperset b.head)) None
		else MetaphoneAlgorithm.compute(a).filter(_.length > 0).flatMap { mp1 =>
			MetaphoneAlgorithm.compute(b).filter(_.length > 0).map(mp1.sameElements(_))
		}

	override def compare(a: String, b: String): Option[Boolean] = compare(a.toCharArray, b.toCharArray)
}
