package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ StringAlgorithm, StringFilter, StringFilterDelegate }
import scala.annotation.tailrec

/** An implementation of the Metaphone [[org.hashtree.stringmetric.StringAlgorithm]]. */
object Metaphone extends StringAlgorithm {
	override def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] = {
		val ca = stringFilter.filter(charArray)

		if (ca.length == 0) None
		else {
			val th = deduplicate(transcodeHead(ca.map(_.toLower)))

			if (th.head < 97 || th.head > 122) None
			else {
				val t = transcode(Array.empty[Char], th.head, th.tail, Array.empty[Char])

				if (t.length == 0) None else Some(t) // Single Y or W would have 0 length.
			}
		}
	}

	override def compute(string: String)(implicit stringFilter: StringFilter): Option[String] =
		compute(stringFilter.filter(string.toCharArray))(new StringFilterDelegate) match {
			case Some(mp) => Some(mp.mkString)
			case None => None
		}

	private[this] def deduplicate(ca: Array[Char]) =
		if (ca.length <= 1) ca
		else
			ca.sliding(2).filter(a => a(0) == 'c' || a(0) != a(1)).map(a => a(0)).toArray[Char] :+ ca.last

	private[this] def isVowel(c: Char) = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')

	@tailrec
	private[this] def transcode(l: Array[Char], c: Char, r: Array[Char], o: Array[Char]): Array[Char] = {
		if (c == '\0' && r.length == 0) o
		else {
			val shift = (d: Int, ca: Array[Char]) => {
				val sa = r.splitAt(d - 1)

				(
					if (sa._1.length > 0) (l :+ c) ++ sa._1 else l :+ c,
					if (sa._2.length > 0) sa._2.head else '\0',
					if (sa._2.length > 1) sa._2.tail else Array.empty[Char],
					ca
				)
			}

			val t = {
				c match {
					case 'a' | 'e' | 'i' | 'o' | 'u' => if (l.length == 0) shift(1, o:+ c) else shift(1, o)
					case 'f' | 'j' | 'l' | 'm' | 'n' | 'r' => shift(1, o :+ c)
					case 'b' => if (l.length >= 1 && l.last == 'm' && r.length == 0) shift(1, o) else shift(1, o :+ 'b')
					case 'c' => {
						if (r.length >= 1 && r.head == 'h' && l.length >= 1 && l.last == 's')
							shift(1, o :+ 'k')
						else if (r.length >= 2 && r.head == 'i' && r(1) == 'a')
							shift(3, o :+ 'x')
						else if (
							(r.length >= 1 && r.head == 'h') ||
							(l.length >= 1 && r.length >= 1 && l.last == 's' && r.head == 'h')
						)
							shift(2, o :+ 'x')
						else if (l.length >= 1 && r.length >= 1 && l.last == 's' && (
								r.head == 'i' || r.head == 'e' || r.head == 'y'
							)
						)
							shift(1, o)
						else if (r.length >= 1 && (r.head == 'i' || r.head == 'e' || r.head == 'y'))
							shift(1, o :+ 's')
						else
							shift(1, o :+ 'k')
					}
					case 'd' => {
						if (r.length >= 2 && r.head == 'g' && (
								r(1) == 'e' || r(1) == 'y' || r(1) == 'i'
							)
						)
							shift(1, o :+ 'j')
						else
							shift(1, o :+ 't')
					}
					case 'g' => {
						if ((r.length > 1 && r.head == 'h') ||
							(r.length == 1 && r.head == 'n') ||
							(r.length == 3 && r.head == 'n' && r(1) == 'e' && r(2) == 'd')
						)
							shift(1, o)
						else if (r.length >= 1 && (r.head == 'i' || r.head == 'e' || r.head == 'y'))
							shift(2, o :+ 'j')
						else
							shift(1, o :+ 'k')
					}
					case 'h' => {
						if ((l.length >= 1 && isVowel(l.last) && (r.length == 0 || !isVowel(r.head))) ||
							(l.length >= 2 && l.last == 'h' && (
									l(l.length - 2) == 'c' || l(l.length - 2) == 's' || l(l.length - 2) == 'p' ||
									l(l.length - 2) == 't' || l(l.length - 2) == 'g'
								)
							)
						)
							shift(1, o)
						else
							shift(1, o :+ 'h')
					}
					case 'k' => if (l.length >= 1 && l.last == 'c') shift(1, o) else shift(1, o :+ 'k')
					case 'p' => if (r.length >= 1 && r.head == 'h') shift(2, o :+ 'f') else shift(1, o :+ 'p')
					case 'q' => shift(1, o :+ 'k')
					case 's' => {
						if (r.length >= 2 && r.head == 'i' && (r(1) == 'o' || r(1) == 'a'))
							shift(3, o :+ 'x')
						else if (r.length >= 1 && r.head == 'h')
							shift(2, o :+ 'x')
						else
							shift(1, o :+ 's')
					}
					case 't' => {
						if (r.length >= 2 && r.head == 'i' && (r(1) == 'a' || r(1) == 'o'))
							shift(3, o :+ 'x')
						else if (r.length >= 1 && r.head == 'h')
							shift(2, o :+ '0')
						else if (r.length >= 2 && r.head == 'c' && r(1) == 'h')
							shift(1, o)
						else
							shift(1, o :+ 't')
					}
					case 'v' => shift(1, o :+ 'f')
					case 'w' | 'y' => if (r.length == 0 || !isVowel(r.head)) shift(1, o) else shift(1, o :+ c)
					case 'x' => shift(1, (o :+ 'k') :+ 's')
					case 'z' => shift(1, o :+ 's')
					case _ => shift(1, o)
				}
			}

			transcode(t._1, t._2, t._3, t._4)
		}
	}

	private[this] def transcodeHead(ca: Array[Char]) = {
		val h = ca.take(2).padTo(2, '\0')

		if ((h.head == 'a' && h.last == 'e') ||
			(h.last == 'n' && (h.head == 'g' || h.head == 'k' || h.head == 'p')) ||
			(h.head == 'w' && h.last == 'r')
		)
			ca.tail
		else if (h.head == 'w' && h.last == 'h')
			'w' +: ca.drop(2)
		else if (h.head == 'x')
			's' +: ca.tail
		else ca
	}
}