package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric._
import com.rockymadden.stringmetric.Alphabet._

case object MetaphoneAlgorithm extends StringAlgorithm {
	override def compute(a: Array[Char]): Option[Array[Char]] =
		if (a.length == 0 || !(Alpha isSuperset a.head)) None
		else {
			val th = (transcodeHead andThen deduplicate)(a.map(_.toLower))
			val t = transcode(Array.empty[Char], th.head, th.tail, Array.empty[Char])

			if (t.length == 0) None else Some(t) // Single Y or W would have 0 length.
		}

	override def compute(a: String): Option[String] = compute(a.toCharArray).map(_.mkString)

	private val deduplicate: (Array[Char] => Array[Char]) = (ca) =>
		if (ca.length <= 1) ca
		else ca.sliding(2).withFilter(a => a(0) == 'c' || a(0) != a(1)).map(_(0)).toArray[Char] :+ ca.last

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
					case 'a' | 'e' | 'i' | 'o' | 'u' => if (l.length == 0) shift(1, o:+ c) else shift(1, o)
					case 'f' | 'j' | 'l' | 'm' | 'n' | 'r' => shift(1, o :+ c)
					case 'b' => if (l.length >= 1 && l.last == 'm' && r.length == 0) shift(1, o) else shift(1, o :+ 'b')
					case 'c' =>
						if (r.length >= 1 && r.head == 'h' && l.length >= 1 && l.last == 's') shift(1, o :+ 'k')
						else if (r.length >= 2 && r.head == 'i' && r(1) == 'a') shift(3, o :+ 'x')
						else if ((r.length >= 1 && r.head == 'h')
							|| (l.length >= 1 && r.length >= 1 && l.last == 's' && r.head == 'h')) shift(2, o :+ 'x')
						else if (l.length >= 1 && r.length >= 1 && l.last == 's'
							&& (r.head == 'i' || r.head == 'e' || r.head == 'y')) shift(1, o)
						else if (r.length >= 1 && (r.head == 'i' || r.head == 'e' || r.head == 'y')) shift(1, o :+ 's')
						else shift(1, o :+ 'k')
					case 'd' =>
						if (r.length >= 2 && r.head == 'g'
							&& (r(1) == 'e' || r(1) == 'y' || r(1) == 'i')) shift(1, o :+ 'j')
						else shift(1, o :+ 't')
					case 'g' =>
						if ((r.length > 1 && r.head == 'h')
							|| (r.length == 1 && r.head == 'n')
							|| (r.length == 3 && r.head == 'n' && r(1) == 'e' && r(2) == 'd')) shift(1, o)
						else if (r.length >= 1 && (r.head == 'i' || r.head == 'e' || r.head == 'y')) shift(2, o :+ 'j')
						else shift(1, o :+ 'k')
					case 'h' =>
						if ((l.length >= 1 && (LowercaseVowel isSuperset l.last) && (r.length == 0 || !(LowercaseVowel isSuperset r.head)))
							|| (l.length >= 2 && l.last == 'h'
								&& (l(l.length - 2) == 'c' || l(l.length - 2) == 's' || l(l.length - 2) == 'p'
									|| l(l.length - 2) == 't' || l(l.length - 2) == 'g'))) shift(1, o)
						else shift(1, o :+ 'h')
					case 'k' => if (l.length >= 1 && l.last == 'c') shift(1, o) else shift(1, o :+ 'k')
					case 'p' => if (r.length >= 1 && r.head == 'h') shift(2, o :+ 'f') else shift(1, o :+ 'p')
					case 'q' => shift(1, o :+ 'k')
					case 's' =>
						if (r.length >= 2 && r.head == 'i' && (r(1) == 'o' || r(1) == 'a')) shift(3, o :+ 'x')
						else if (r.length >= 1 && r.head == 'h') shift(2, o :+ 'x')
						else shift(1, o :+ 's')
					case 't' =>
						if (r.length >= 2 && r.head == 'i' && (r(1) == 'a' || r(1) == 'o')) shift(3, o :+ 'x')
						else if (r.length >= 1 && r.head == 'h') shift(2, o :+ '0')
						else if (r.length >= 2 && r.head == 'c' && r(1) == 'h') shift(1, o)
						else shift(1, o :+ 't')
					case 'v' => shift(1, o :+ 'f')
					case 'w' | 'y' => if (r.length == 0 || !(LowercaseVowel isSuperset r.head)) shift(1, o) else shift(1, o :+ c)
					case 'x' => shift(1, (o :+ 'k') :+ 's')
					case 'z' => shift(1, o :+ 's')
					case _ => shift(1, o)
				}
			}

			transcode(t._1, t._2, t._3, t._4)
		}

	private val transcodeHead: (Array[Char] => Array[Char]) = (ca) =>
		(ca.length: @annotation.switch) match {
			case 0 => ca
			case 1 => if (ca.head == 'x') Array('s') else ca
			case _ =>
				(ca.head: @annotation.switch) match {
					case 'a' if ca(1) == 'e' => ca.tail
					case 'g' | 'k' | 'p' if ca(1) == 'n' => ca.tail
					case 'w' if ca(1) == 'r' => ca.tail
					case 'w' if ca(1) == 'h' => 'w' +: ca.drop(2)
					case 'x' => 's' +: ca.tail
					case _ => ca
				}
		}
}
