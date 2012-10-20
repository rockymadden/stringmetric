package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ StringAlgorithm, StringCleaner, StringCleanerDelegate }
import scala.annotation.tailrec

/** An implementation of the Soundex [[org.hashtree.stringmetric.StringAlgorithm]]. */
object Soundex extends StringAlgorithm {
	override def compute(charArray: Array[Char])(implicit stringCleaner: StringCleaner): Option[Array[Char]] = {
		val ca = stringCleaner.clean(charArray)

		if (ca.length == 0) None
		else {
			letter(ca, 0) match {
				case Some(l) => {
					if (ca.length - 1 == l._2) Some(Array(l._1, '0', '0', '0'))
					else {
						Some(
							code(
								ca.takeRight(ca.length - (l._2 + 1)),
								l._1, // Pass first letter.
								Array(l._1) // Pass array with first letter.
							).padTo(4, '0')
						)
					}
				}
				case None => None
			}
		}
	}

	override def compute(string: String)(implicit stringCleaner: StringCleaner): Option[String] = {
		compute(stringCleaner.clean(string.toCharArray))(new StringCleanerDelegate) match {
			case Some(se) => Some(se.mkString)
			case None => None
		}
	}

	@tailrec
	private[this] def letter(i: Array[Char], ind: Int): Option[Tuple2[Char, Int]] = {
		if (i.length == 0) None
		else {
			val c = i.head.toLower

			if (c >= 97 && c <= 122) Some((c, ind)) else letter(i.tail, ind + 1)
		}
	}

	@tailrec
	private[this] def code(i: Array[Char], p: Char, o: Array[Char]): Array[Char] = {
		require(p >= 97 && p <= 122)
		require(o.length > 0)

		if (i.length == 0) o
		else {
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
					m1(
						c,
						o.last match {
							case '1' | '2' | '3' | '4' | '5' | '6' => o.last
							case _ => m2(o.last)
						}
					)
				}
			}

			if (o.length == 3 && a != '\0') o :+ a
			else
				code(i.tail, c, if (a != '\0') o :+ a else o)
		}
	}
}