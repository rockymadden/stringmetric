package org.hashtree.stringmetric.distance

import org.hashtree.stringmetric.{ CompareTuple, StringCleaner, StringCleanerDelegate, StringMetric }

/** An implementation of the Hamming [[org.hashtree.stringmetric.StringMetric]]. */
object HammingMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Option[Int] = {
		val ca1 = stringCleaner.clean(charArray1)
		val ca2 = stringCleaner.clean(charArray2)

		if (ca1.length == 0 || ca2.length == 0 || ca1.length != ca2.length)
			None
		else
			Some(hamming(ca1, ca2))
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Option[Int] = {
		compare(
			stringCleaner.clean(string1.toCharArray),
			stringCleaner.clean(string2.toCharArray)
		)(new StringCleanerDelegate)
	}

	private[this] def hamming(ct: CompareTuple[Char]) = {
		require(ct._1.length > 0)
		require(ct._2.length > 0)
		require(ct._1.length == ct._2.length)

		ct._1.zip(ct._2).count(t => t._1 != t._2)
	}
}