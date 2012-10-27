package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ CompareTuple, StringCleaner, StringCleanerDelegate, StringMetric }

/** An implementation of the Hamming [[org.hashtree.stringmetric.StringMetric]]. */
object HammingMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Option[Int] = {
		val ca1 = stringCleaner.clean(charArray1)
		val ca2 = stringCleaner.clean(charArray2)

		if (ca1.length == 0 || ca2.length == 0 || ca1.length != ca2.length) None
		else Some(hamming(ca1, ca2))
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Option[Int] = {
		if (string1.length > 0 && string1.length == string2.length && string1 == string2) Some(0)
		else
			compare(
				stringCleaner.clean(string1.toCharArray),
				stringCleaner.clean(string2.toCharArray)
			)(new StringCleanerDelegate)
	}

	private[this] def hamming(ct: CompareTuple[Char]) = {
		require(ct._1.length == ct._2.length)

		if (ct._1.length == 0) 0
		else
			ct._1.zip(ct._2).count(t => t._1 != t._2)
	}
}