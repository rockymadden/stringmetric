package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringAlgorithm, StringAlgorithm, StringFilter }
import org.hashtree.stringmetric.filter.StringFilterDelegate
import scala.annotation.tailrec

/** An implementation of the refined Soundex [[org.hashtree.stringmetric.StringAlgorithm]]. */
object RefinedSoundexAlgorithm extends StringAlgorithm with FilterableStringAlgorithm {
	type ComputeReturn = String

	override def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] = {
		val ca = stringFilter.filter(charArray)

		if (ca.length == 0 || !Alphabet.is(ca.head)) None
		else {
			val fc = ca.head.toLower

			Some(transcode(ca, fc, Array(fc)))
		}
	}

	override def compute(string: String)(implicit stringFilter: StringFilter): Option[ComputeReturn] =
		compute(stringFilter.filter(string.toCharArray))(new StringFilterDelegate).map(_.mkString)

	@tailrec
	private[this] def transcode(i: Array[Char], p: Char, o: Array[Char]): Array[Char] = {
		require(o.length > 0)

		if (i.length == 0) o
		else {
			val c = i.head.toLower
			val m2 = (mc: Char) => mc match {
				case 'a' | 'e' | 'h' | 'i' | 'o' | 'u' | 'w' | 'y' => '0'
				case 'b' | 'p' => '1'
				case 'f' | 'v' => '2'
				case 'c' | 'k' | 's' => '3'
				case 'g' | 'j' => '4'
				case 'q' | 'x' | 'z' => '5'
				case 'd' | 't' => '6'
				case 'l' => '7'
				case 'm' | 'n' => '8'
				case 'r' => '9'
				case _ => '\0'
			}
			val m1 = (mc: Char, pc: Char) => mc match {
				case 'a' | 'e' | 'h' | 'i' | 'o' | 'u' | 'w' | 'y' if pc != '0' => '0'
				case 'b' | 'p' if pc != '1' => '1'
				case 'f' | 'v' if pc != '2' => '2'
				case 'c' | 'k' | 's' if pc != '3' => '3'
				case 'g' | 'j' if pc != '4' => '4'
				case 'q' | 'x' | 'z' if pc != '5' => '5'
				case 'd' | 't' if pc != '6' => '6'
				case 'l' if pc != '7' => '7'
				case 'm' | 'n' if pc != '8' => '8'
				case 'r' if pc != '9' => '9'
				case _ => '\0'
			}
			val a =
				// Code twice.
				if (o.length == 1) m2(c)
				// Code once.
				else m1(
					c,
					o.last match {
						case '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' => o.last
						case _ => m2(o.last)
					}
				)

			transcode(i.tail, c, if (a != '\0') o :+ a else o)
		}
	}
}