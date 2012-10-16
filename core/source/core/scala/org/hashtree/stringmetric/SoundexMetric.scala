package org.hashtree.stringmetric

import scala.annotation.tailrec

/** An implementation of the Soundex [[org.hashtree.stringmetric.StringMetric]]. */
object SoundexMetric extends StringMetric {
	override def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringCleaner: StringCleaner): Option[Boolean] = {
		val se1 = if (charArray1.length > 0) soundex(stringCleaner.clean(charArray1)) else None
		val se2 = if (charArray2.length > 0) soundex(stringCleaner.clean(charArray2)) else None

		if (!se1.isDefined || !se2.isDefined) None else Some(se1.get == se2.get)
	}

	override def compare(string1: String, string2: String)(implicit stringCleaner: StringCleaner): Option[Boolean] = {
		compare(stringCleaner.clean(string1.toCharArray),
			stringCleaner.clean(string2.toCharArray)
		)(new StringCleanerDelegate)
	}

	private[this] def soundex(ca: Array[Char]) = {
		require(ca.length > 0)

		@tailrec
		def letter(ca: Array[Char], i: Int): Option[Tuple2[Char, Int]] = {
			require(ca.length > 0)

			val c = ca.head.toLower

			if (c >= 97 && c <= 122) Some((c, i)) else if (ca.length == 1) None else letter(ca.tail, i + 1)
		}

		@tailrec
		def code(i: Array[Char], p: Char, o: Array[Char]): Array[Char] = {
			require(i.length > 0)
			require(p >= 97 && p <= 122)
			require(o.length > 0)

			val c = i.head.toLower
			val m2 = (mc: Char) => mc match {
				case 'b' | 'f' | 'p' | 'v' => '1'
				case 'c' | 'g' | 'j' | 'k' | 'q' | 's' | 'x' | 'z' => '2'
				case 'd' | 't' => '3'
				case 'l' => '4'
				case 'm' | 'n' => '5'
				case 'r' => '6'
				case _ => '\0'
			}
			val m1 = (mc: Char, pc: Char) => mc match {
				case 'b' | 'f' | 'p' | 'v' if pc != '1' => '1'
				case 'c' | 'g' | 'j' | 'k' | 'q' | 's' | 'x' | 'z' if pc != '2' => '2'
				case 'd' | 't' if pc != '3' => '3'
				case 'l' if pc != '4' => '4'
				case 'm' | 'n' if pc != '5' => '5'
				case 'r' if pc != '6' => '6'
				case _ => '\0'
			}
			val a = p match {
				// Code twice.
				case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => m2(c)
				// Code once.
				case _ => {
					m1(c,
						o.last match {
							case '1' | '2' | '3' | '4' | '5' | '6' => o.last
							case _ => m2(o.last)
						}
					)
				}
			}

			if (i.length == 1 || (o.length == 3 && a != '\0'))
				if (a != '\0') o :+ a else o
			else
				code(i.tail, c, if (a != '\0') o :+ a else o)
		}

		letter(ca, 0) match {
			case Some(l) => {
				if (ca.length - 1 == l._2) Some(l._1 + "000")
				else {
					Some(
						code(ca.takeRight(ca.length - (l._2 + 1)),
							l._1, // Pass first letter.
							Array(l._1) // Pass array with first letter.
						).mkString.padTo(4, '0')
					)
				}
			}
			case None => None
		}
	}
}