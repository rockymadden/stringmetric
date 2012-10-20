package org.hashtree.stringmetric.distance

import org.hashtree.stringmetric.{ CompareTuple, MatchTuple, StringCleaner, StringCleanerDelegate, StringMetric }
import scala.annotation.tailrec

/** An implementation of the Dice, and Sorensen, [[org.hashtree.stringmetric.StringMetric]]. */
object DiceSorensenMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Option[Float] = {
		val ca1 = stringCleaner.clean(charArray1)
		val ca2 = stringCleaner.clean(charArray2)

		if (ca1.length == 0 || ca2.length == 0) None
		else {
			val b = bigrams(ca1, ca2)
			val ms = scoreMatches(b)

			Some((2f * ms) / (b._1.length + b._2.length))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Option[Float] = {
		if (string1.length > 0 && string1.length == string2.length && string1 == string2) Some(1f)
		else
			compare(
				stringCleaner.clean(string1.toCharArray),
				stringCleaner.clean(string2.toCharArray)
			)(new StringCleanerDelegate)
	}

	private[this] def bigrams(ct: CompareTuple[Char]): MatchTuple[String] = {
		@tailrec
		def set(ca: Array[Char], sa: Array[String]): Array[String] = {
			if (ca.length <= 1) sa
			else
				set(ca.tail, sa :+ "" + ca.head + ca.tail.head)
		}

		(set(ct._1, Array.empty[String]), set(ct._2, Array.empty[String]))
	}

	private[this] def scoreMatches(mt: MatchTuple[String]) = {
		mt._1.intersect(mt._2).length
	}
}