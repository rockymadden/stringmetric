package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{StringAlgorithm, StringFilter}
import com.rockymadden.stringmetric.Alphabet.Alpha
import scala.annotation.{switch, tailrec}

/** An implementation of the refined Soundex algorithm. */
class RefinedSoundexAlgorithm extends StringAlgorithm[DummyImplicit, String] { this: StringFilter =>
	final override def compute(charArray: Array[Char])(implicit di: DummyImplicit): Option[Array[Char]] = {
		val fca = filter(charArray)

		if (fca.length == 0 || !(Alpha isSuperset fca.head)) None
		else Some(transcode(fca, Array(fca.head.toLower)))
	}

	final override def compute(string: String)(implicit di: DummyImplicit): Option[String] =
		compute(string.toCharArray).map(_.mkString)

	@tailrec
	private[this] def transcode(i: Array[Char], o: Array[Char]): Array[Char] = {
		if (i.length == 0) o
		else {
			val c = i.head.toLower
			val m2 = (mc: Char) => (mc: @switch) match {
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
			val m1 = (mc: Char, pc: Char) => (mc: @switch) match {
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
					(o.last: @switch) match {
						case '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' => o.last
						case _ => m2(o.last)
					}
				)

			transcode(i.tail, if (a != '\0') o :+ a else o)
		}
	}
}

object RefinedSoundexAlgorithm {
	private lazy val self = apply()

	def apply(): RefinedSoundexAlgorithm = new RefinedSoundexAlgorithm with StringFilter

	def compute(charArray: Array[Char]) = self.compute(charArray)

	def compute(string: String) = self.compute(string)
}
