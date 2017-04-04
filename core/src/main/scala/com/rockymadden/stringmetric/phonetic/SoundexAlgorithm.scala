package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric._
import com.rockymadden.stringmetric.Alphabet._

case object SoundexAlgorithm extends StringAlgorithm {
	override def compute(a: Array[Char]): Option[Array[Char]] =
		if (a.length == 0 || !(Alpha isSuperset a.head)) None
		else {
			val fc = a.head.toLower

			Some(transcode(a.tail, fc, Array(fc)).padTo(4, '0'))
		}

	override def compute(string: String): Option[String] = compute(string.toCharArray).map(_.mkString)

	@annotation.tailrec
	private val transcode: ((Array[Char], Char, Array[Char]) => Array[Char]) = (i, pc, o) =>
		if (i.length == 0) o
		else {
			val c = i.head.toLower
			val m2 = (mc: Char) => (mc: @annotation.switch) match {
				case 'b' | 'f' | 'p' | 'v' => '1'
				case 'c' | 'g' | 'j' | 'k' | 'q' | 's' | 'x' | 'z' => '2'
				case 'd' | 't' => '3'
				case 'l' => '4'
				case 'm' | 'n' => '5'
				case 'r' => '6'
				case _ => '\u0000'
			}
			val m1 = (mc: Char, pc: Char) => (mc: @annotation.switch) match {
				case 'b' | 'f' | 'p' | 'v' if pc != '1' => '1'
				case 'c' | 'g' | 'j' | 'k' | 'q' | 's' | 'x' | 'z' if pc != '2' => '2'
				case 'd' | 't' if pc != '3' => '3'
				case 'l' if pc != '4' => '4'
				case 'm' | 'n' if pc != '5' => '5'
				case 'r' if pc != '6' => '6'
				case _ => '\u0000'
			}
			val a = pc match {
				// Code twice.
				case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => m2(c)
				// Code once.
				case _ => m1(
					c,
					(o.last: @annotation.switch) match {
						case '1' | '2' | '3' | '4' | '5' | '6' => o.last
						case _ => m2(o.last)
					}
				)
			}

			if (o.length == 3 && a != '\u0000') o :+ a
			else transcode(i.tail, c, if (a != '\u0000') o :+ a else o)
		}
}
