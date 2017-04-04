package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric._
import com.rockymadden.stringmetric.Alphabet._

case object RefinedNysiisAlgorithm extends StringAlgorithm {
	override def compute(a: Array[Char]): Option[Array[Char]] =
		if (a.length == 0 || !(Alpha isSuperset a.head)) None
		else {
			val lca = a.map(_.toLower)
			val tlh = (transcodeHead andThen transcodeLast)(lca.head +: cleanLast(lca.tail, Set('s', 'z')))
			val t = transcode(Array.empty[Char], tlh.head, tlh.tail, Array.empty[Char])

			if (t.length == 1) Some(t)
			else Some(deduplicate(
				t.head +: (cleanLast.tupled andThen cleanTerminal)(t.tail, Set('a'))
			))
		}

	override def compute(string: String): Option[String] = compute(string.toCharArray).map(_.mkString)

	private val cleanLast: ((Array[Char], Set[Char]) => Array[Char]) = (ca, s) =>
		if (ca.length == 0) ca
		else if(s.contains(ca.last)) ca.dropRight(ca.reverseIterator.takeWhile(c => s.contains(c)).length)
		else ca

	private val cleanTerminal: (Array[Char] => Array[Char]) = (ca) =>
		if (ca.length >= 2 && ca.last == 'y' && ca(ca.length - 2) == 'a') ca.dropRight(2) :+ 'y'
		else ca

	private val deduplicate: (Array[Char] => Array[Char]) = (ca) =>
		if (ca.length <= 1) ca
		else ca.sliding(2).withFilter(a => a(0) != a(1)).map(a => a(0)).toArray[Char] :+ ca.last

	@annotation.tailrec
	private val transcode: ((Array[Char], Char, Array[Char], Array[Char]) => Array[Char]) = (l, c, r, o) =>
		if (c == '\u0000' && r.length == 0) o
		else {
			def shift(d: Int, ca: Array[Char]) = {
				val sca = r.splitAt(d - 1)

				(
					if (sca._1.length > 0) (l :+ c) ++ sca._1 else l :+ c,
					if (sca._2.length > 0) sca._2.head else '\u0000',
					if (sca._2.length > 1) sca._2.tail else Array.empty[Char],
					ca
				)
			}

			val t = {
				(c: @annotation.switch) match {
					case 'a' | 'i' | 'o' | 'u' =>
						if (l.length == 0) shift(1, o :+ c)
						else shift(1, o :+ 'a')
					case 'b' | 'c' | 'f' | 'j' | 'l' | 'n' | 'r' | 't' | 'v' | 'x' => shift(1, o :+ c)
					case 'd' =>
						if (r.length >= 1 && r.head == 'g') shift(2, o :+ 'g') else shift(1, o :+ c)
					case 'e' =>
						if (l.length == 0) shift(1, o :+ c)
						else if (r.length >= 1 && r.head == 'v') shift(2, o ++ Array('a', 'f'))
						else shift(1, o :+ 'a')
					case 'g' =>
						if (r.length >= 2 && r.head == 'h' && r(1) == 't') shift(3, o ++ Array('g', 't'))
						else shift(1, o :+ c)
					case 'h' =>
						if (l.length == 0) shift(1, o :+ c)
						else if (!(LowercaseVowel isSuperset l.last) || (r.length >= 1 && !(LowercaseVowel isSuperset r.head)))
							shift(1, o)
						else shift(1, o :+ c)
					case 'k' => if (r.length >= 1 && r.head == 'n') shift(2, o :+ 'n') else shift(1, o :+ 'c')
					case 'm' => if (l.length == 0) shift(1, o :+ c) else shift(1, o :+ 'n')
					case 'p' => if (r.length >= 1 && r.head == 'h') shift(2, o :+ 'f') else shift(1, o :+ c)
					case 'q' => if (l.length == 0) shift(1, o :+ c) else shift(1, o :+ 'g')
					case 's' =>
						if (r.length >= 2 && r.head == 'c' && r(1) == 'h') shift(3, o :+ c)
						else if (r.length >= 1 && r.head == 'h') shift(2, o :+ c)
						else shift(1, o :+ c)
					case 'w' =>
						if (l.length >= 1 && (LowercaseVowel isSuperset l.last)) shift(1, o)
						else if (r.length >= 1 && r.head == 'r') shift(2, o :+ 'r')
						else shift(1, o :+ c)
					case 'y' =>
						if (l.length >= 1 && r.length >= 2 && r.head == 'w') shift(2, o :+ 'a')
						else if (r.length >= 1 && r.head == 'w') shift(2, o :+ c)
						else if (l.length >= 1 && r.length >= 1) shift(1, o :+ 'a')
						else shift(1, o :+ c)
					case 'z' => if (l.length == 0) shift(1, o :+ c) else shift(1, o :+ 's')
					case _ => shift(1, o)
				}
			}

			transcode(t._1, t._2, t._3, t._4)
		}

	private val transcodeHead: (Array[Char] => Array[Char]) = (ca) =>
		if (ca.length == 0) ca
		else
			(ca.head: @annotation.switch) match {
				case 'm' if ca.length >= 3 && ca(1) == 'a' && ca(2) == 'c' =>
					Array('m', 'c') ++ ca.takeRight(ca.length - 3)
				case 'p' if ca.length >= 2 && ca(1) == 'f' =>'f' +: ca.takeRight(ca.length - 2)
				case _ => ca
			}

	private val transcodeLast: (Array[Char] => Array[Char]) = (ca) =>
		if (ca.length >= 2) {
			val lc = ca(ca.length - 1)
			val lcm1 = ca(ca.length - 2)
			lazy val t2 = ca.take(ca.length - 2)

			(lc: @annotation.switch) match {
				case 'd' if lcm1 == 'n' || lcm1 == 'r' => t2 :+ 'd'
				case 'e' if lcm1 == 'e' || lcm1 == 'i' || lcm1 =='y' => t2 :+ 'y'
				case 't' if lcm1 == 'd' || lcm1 == 'n' || lcm1 == 'r' => t2 :+ 'd'
				case 'x' if lcm1 == 'e' => t2 ++ Array('e', 'c')
				case 'x' if lcm1 == 'i' => t2 ++ Array('i', 'c')
				case _ => ca
			}
		} else ca
}
