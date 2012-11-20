package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringAlgorithm, StringAlgorithm, StringFilter }
import org.hashtree.stringmetric.filter.StringFilterDelegate
import scala.annotation.tailrec

/** An implementation of the Soundex [[org.hashtree.stringmetric.StringAlgorithm]]. */
object SoundexAlgorithm extends StringAlgorithm with FilterableStringAlgorithm {
	type ComputeReturn = String

	override def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] = {
		val ca = stringFilter.filter(charArray)

		if (ca.length == 0 || !Alphabet.is(ca.head)) None
		else {
			val fc = ca.head.toLower

			Some(transcode(ca.tail, fc, Array(fc)).padTo(4, '0'))
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
				case _ => m1(
					c,
					o.last match {
						case '1' | '2' | '3' | '4' | '5' | '6' => o.last
						case _ => m2(o.last)
					}
				)
			}

			if (o.length == 3 && a != '\0') o :+ a
			else transcode(i.tail, c, if (a != '\0') o :+ a else o)
		}
	}
}