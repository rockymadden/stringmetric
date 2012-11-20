package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ CompareTuple, FilterableStringMetric, StringFilter, StringMetric }
import org.hashtree.stringmetric.filter.StringFilterDelegate

/** An implementation of the Levenshtein [[org.hashtree.stringmetric.StringMetric]]. */
object LevenshteinMetric extends StringMetric with FilterableStringMetric {
	type CompareReturn = Int

	override def compare(charArray1: Array[Char], charArray2: Array[Char])
		(implicit stringFilter: StringFilter): Option[CompareReturn] = {

		val ca1 = stringFilter.filter(charArray1)
		val ca2 = stringFilter.filter(charArray2)

		if (ca1.length == 0 && ca2.length == 0) None
		else if (ca1.length == 0) Some(ca2.length)
		else if (ca2.length == 0) Some(ca1.length)
		else Some(levenshtein(ca1, ca2))
	}

	override def compare(string1: String, string2: String)
		(implicit stringFilter: StringFilter): Option[CompareReturn] =

		compare(
			stringFilter.filter(string1.toCharArray),
			stringFilter.filter(string2.toCharArray)
		)(new StringFilterDelegate)

	private[this] def levenshtein(ct: CompareTuple[Char]) = {
		val m = Array.fill[Int](ct._1.length + 1, ct._2.length + 1)(-1)

		def distance(t: Tuple2[Int, Int]): Int = {
			t match {
				case (r, 0) => r
				case (0, c) => c
				case (r, c) if m(r)(c) != -1 => m(r)(c)
				case (r, c) => {
					val min = {
						if (ct._1(r - 1) == ct._2(c - 1)) distance(r - 1, c - 1)
						else math.min(
							math.min(
								distance(r - 1, c) + 1, // Delete (left).
								distance(r, c - 1) + 1 // Insert (up).
							),
							distance(r - 1, c - 1) + 1 // Substitute (left-up).
						)
					}

					m(r)(c) = min
					min
				}
			}
		}

		distance(ct._1.length, ct._2.length)
	}
}