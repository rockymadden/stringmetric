package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{CompareTuple, StringFilter, StringMetric}

/** An implementation of the Hamming metric. */
class HammingMetric extends StringMetric[DummyImplicit, Int] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit di: DummyImplicit): Option[Int] = {

		val fca1 = filter(charArray1)
		lazy val fca2 = filter(charArray2)

		if (fca1.length == 0 || fca2.length == 0 || fca1.length != fca2.length) None
		else if (fca1.sameElements(fca2)) Some(0)
		else Some(hamming(fca1, fca2))
	}

	final override def compare(string1: String, string2: String)(implicit di: DummyImplicit): Option[Int] =
		compare(string1.toCharArray, string2.toCharArray)

	private[this] def hamming(ct: CompareTuple[Char]) = {
		require(ct._1.length == ct._2.length)

		if (ct._1.length == 0) 0
		else ct._1.zip(ct._2).count(t => t._1 != t._2)
	}
}

object HammingMetric {
	private lazy val self = apply()

	def apply(): HammingMetric = new HammingMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char]) = self.compare(charArray1, charArray2)

	def compare(string1: String, string2: String) = self.compare(string1, string2)
}
