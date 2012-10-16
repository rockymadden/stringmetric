package org.hashtree.stringmetric

/** An implementation of the Hamming [[org.hashtree.stringmetric.StringMetric]]. */
object HammingMetric extends StringMetric {
	implicit val stringCleaner = new StringCleanerDelegate with CaseStringCleaner

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

	private[this] def hamming(ca1: Array[Char], ca2: Array[Char]) = {
		require(ca1.length > 0)
		require(ca2.length > 0)
		require(ca1.length == ca2.length)

		ca1.zip(ca2).count(t => t._1 != t._2)
	}
}