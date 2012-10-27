package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ CompareTuple, StringCleaner, StringCleanerDelegate, StringMetric }

/** An implementation of the Levenshtein [[org.hashtree.stringmetric.StringMetric]]. */
object LevenshteinMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Option[Int] = {
		val ca1 = stringCleaner.clean(charArray1)
		val ca2 = stringCleaner.clean(charArray2)

		if (ca1.length == 0 && ca2.length == 0) None
		else {
			val levenshteinMemoize = Memoize.Y(levenshtein)

			Some(levenshteinMemoize(ca1, ca2))
		}
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Option[Int] = {
		if (string1.length > 0 && string1.length == string2.length && string1 == string2) Some(0)
		else
			compare(
				stringCleaner.clean(string1.toCharArray),
				stringCleaner.clean(string2.toCharArray)
			)(new StringCleanerDelegate)
	}

	private[this] def levenshtein(f: CompareTuple[Char] => Int)(ct: CompareTuple[Char]): Int = {
		if (ct._1.length == 0) ct._2.length
		else if (ct._2.length == 0) ct._1.length
		else {
			math.min(
				math.min(
					f(ct._1.tail, ct._2) + 1,
					f(ct._1, ct._2.tail) + 1
				),
				f(ct._1.tail, ct._2.tail) + (if (ct._1.head != ct._2.head) 1 else 0)
			)
		}
	}

	private[this] final class Memoize[-T, +R](f: T => R) extends (T => R) {
		private[this] val map = scala.collection.mutable.Map.empty[T, R]

		def apply(k: T): R = map.getOrElseUpdate(k, f(k))
	}

	private[this] object Memoize {
		def apply[T, R](f: T => R) = new Memoize(f)

		def Y[T, R](f: (T => R) => T => R): (T => R) = {
			lazy val yf: T => R = Memoize(f(yf)(_))

			yf
		}
	}
}