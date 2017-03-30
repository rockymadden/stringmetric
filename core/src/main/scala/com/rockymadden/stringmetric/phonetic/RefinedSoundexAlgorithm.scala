package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric._
import com.rockymadden.stringmetric.Alphabet._

case object RefinedSoundexAlgorithm extends StringAlgorithm {
	override def compute(a: Array[Char]): Option[Array[Char]] =
		if (a.length == 0 || !(Alpha isSuperset a.head)) None
		else Some(transcode(a, Array(a.head.toLower)))

	override def compute(a: String): Option[String] = compute(a.toCharArray).map(_.mkString)

	@annotation.tailrec
	private val transcode: ((Array[Char], Array[Char]) => Array[Char]) = (i, o) =>
		if (i.length == 0) o
		else {
			val c = i.head.toLower
			val m2 = (mc: Char) => (mc: @annotation.switch) match {
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
				case _ => '\u0000'
			}
			val m1 = (mc: Char, pc: Char) => (mc: @annotation.switch) match {
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
				case _ => '\u0000'
			}
			val a =
				// Code twice.
				if (o.length == 1) m2(c)
				// Code once.
				else m1(
					c,
					(o.last: @annotation.switch) match {
						case '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' => o.last
						case _ => m2(o.last)
					}
				)

			transcode(i.tail, if (a != '\u0000') o :+ a else o)
		}
}
