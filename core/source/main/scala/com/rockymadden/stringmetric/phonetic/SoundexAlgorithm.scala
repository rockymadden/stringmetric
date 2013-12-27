package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.{StringAlgorithm, StringFilter}
import com.rockymadden.stringmetric.Alphabet.Alpha
import scala.annotation.{switch, tailrec}

/** An implementation of the Soundex algorithm. */
class SoundexAlgorithm extends StringAlgorithm[DummyImplicit, String] { this: StringFilter =>
	final override def compute(charArray: Array[Char])(implicit di: DummyImplicit): Option[Array[Char]] = {
		val fca = filter(charArray)

		if (fca.length == 0 || !(Alpha isSuperset fca.head)) None
		else {
			val fc = fca.head.toLower

			Some(transcode(fca.tail, fc, Array(fc)).padTo(4, '0'))
		}
	}

	final override def compute(string: String)(implicit di: DummyImplicit): Option[String] =
		compute(string.toCharArray).map(_.mkString)

	@tailrec
	private[this] def transcode(i: Array[Char], pc: Char, o: Array[Char]): Array[Char] = {
		if (i.length == 0) o
		else {
			val c = i.head.toLower
			val m2 = (mc: Char) => (mc: @switch) match {
				case 'b' | 'f' | 'p' | 'v' => '1'
				case 'c' | 'g' | 'j' | 'k' | 'q' | 's' | 'x' | 'z' => '2'
				case 'd' | 't' => '3'
				case 'l' => '4'
				case 'm' | 'n' => '5'
				case 'r' => '6'
				case _ => '\0'
			}
			val m1 = (mc: Char, pc: Char) => (mc: @switch) match {
				case 'b' | 'f' | 'p' | 'v' if pc != '1' => '1'
				case 'c' | 'g' | 'j' | 'k' | 'q' | 's' | 'x' | 'z' if pc != '2' => '2'
				case 'd' | 't' if pc != '3' => '3'
				case 'l' if pc != '4' => '4'
				case 'm' | 'n' if pc != '5' => '5'
				case 'r' if pc != '6' => '6'
				case _ => '\0'
			}
			val a = pc match {
				// Code twice.
				case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => m2(c)
				// Code once.
				case _ => m1(
					c,
					(o.last: @switch) match {
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

object SoundexAlgorithm {
	private lazy val self = apply()

	def apply(): SoundexAlgorithm = new SoundexAlgorithm with StringFilter

	def compute(charArray: Array[Char]) = self.compute(charArray)

	def compute(string: String) = self.compute(string)
}
