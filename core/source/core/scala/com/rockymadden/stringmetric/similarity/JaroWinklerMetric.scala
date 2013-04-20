package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.{StringFilter, StringMetric}

/**
 * An implementation of the Jaro-Winkler metric. One differing detail in this implementation is that if a character is
 * matched in string2, it cannot be matched upon again. This results in a more penalized distance in these scenarios
 * (e.g. comparing henka and henkan distance is 0.9666 versus the typical 0.9722).
 */
class JaroWinklerMetric extends StringMetric[DummyImplicit, Double] { this: StringFilter =>
	final override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit di: DummyImplicit): Option[Double] = {

		val fca1 = filter(charArray1)
		val fca2 = filter(charArray2)

		JaroMetric.compare(fca1, fca2).map {
			case 0d => 0d
			case 1d => 1d
			case jaro => {
				val prefix = fca1.zip(fca2).takeWhile(t => t._1 == t._2)

				jaro + ((if (prefix.length <= 4) prefix.length else 4) * 0.1d * (1 - jaro))
			}
		}
	}

	final override def compare(string1: String, string2: String)(implicit di: DummyImplicit): Option[Double] =
		compare(string1.toCharArray, string2.toCharArray)
}

object JaroWinklerMetric {
	private lazy val self = apply()

	def apply(): JaroWinklerMetric = new JaroWinklerMetric with StringFilter

	def compare(charArray1: Array[Char], charArray2: Array[Char]) = self.compare(charArray1, charArray2)

	def compare(string1: String, string2: String) = self.compare(string1, string2)
}
