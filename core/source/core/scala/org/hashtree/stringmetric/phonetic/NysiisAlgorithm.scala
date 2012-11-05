package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringAlgorithm, StringAlgorithm, StringFilter, StringFilterDelegate }
import scala.annotation.tailrec

/** An implementation of the NYSIIS [[org.hashtree.stringmetric.StringAlgorithm]]. */
object NysiisAlgorithm extends StringAlgorithm with FilterableStringAlgorithm {
	override def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] = {
		val ca = stringFilter.filter(charArray)

		if (ca.length == 0) None
		else {
			val thl = transcodeLast(transcodeHead(ca.map(_.toLower)))

			if (thl.head < 97 || thl.head > 122) None
			else {
				if (thl.length == 1) Some(thl)
				else {
					val ts = thl.splitAt(1)
					val t = transcode(ts._1, ts._2.head, ts._2.tail, ts._1)

					Some(t.head +: deduplicate(transcodeClean(t.tail)))
				}
			}
		}
	}

	override def compute(string: String)(implicit stringFilter: StringFilter): Option[String] =
		compute(stringFilter.filter(string.toCharArray))(new StringFilterDelegate) match {
			case Some(ny) => Some(ny.mkString)
			case None => None
		}

	private[this] def deduplicate(ca: Array[Char]) =
		if (ca.length <= 1) ca
		else
			ca.sliding(2).filter(a => a(0) != a(1)).map(a => a(0)).toArray[Char] :+ ca.last

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
					case 'a' | 'i' | 'o' | 'u' => shift(1, o :+ 'a')
					case 'b' | 'c' | 'd' | 'f' | 'g' | 'j' | 'l' | 'n' | 'r' | 't' | 'v' | 'x' | 'y' => shift(1, o :+ c)
					case 'e' => {
						if (r.length >= 1 && r.head == 'v')
							shift(2, o ++ Array('a', 'f'))
						else
							shift(1, o :+ 'a')
					}
					case 'h' => {
						if (l.length >= 1 && (!isVowel(l.last) || (r.length >= 1 && !isVowel(r.head))))
							shift(1, o :+ l.last)
						else
							shift(1, o :+ c)
					}
					case 'k' => if (r.length >= 1 && r.head == 'n') shift(2, o :+ 'n') else shift(1, o :+ 'c')
					case 'm' => shift(1, o :+ 'n')
					case 'p' => if (r.length >= 1 && r.head == 'h') shift(2, o ++ Array('f', 'f')) else shift(1, o :+ 'p')
					case 'q' => shift(1, o :+ 'g')
					case 's' => {
						if (r.length >= 2 && r.head == 'c' && r(1) == 'h')
							shift(3, o ++ Array('s', 's', 's'))
						else
							shift(1, o :+ c)
					}
					case 'w' => {
						if (l.length >= 1 && !isVowel(l.last))
							shift(1, o :+ l.last)
						else
							shift(1, o :+ c)
					}
					case 'z' => shift(1, o :+ 's')
					case _ => shift(1, o)
				}
			}

			transcode(t._1, t._2, t._3, t._4)
		}
	}

	private[this] def transcodeClean(ca: Array[Char]) =
		if (ca.length >= 1 && (ca.last == 'a' || ca.last == 's'))
			ca.reverse.dropWhile(c => c == 'a' || c == 's').reverse
		else if (ca.length >= 2 && ca.last == 'y' && ca(ca.length - 2) == 'a')
			ca.dropRight(2) :+ 'y'
		else ca

	private[this] def transcodeHead(ca: Array[Char]) = {
		val h = ca.take(3).padTo(3, '\0')

		if (h.head == 'm' && h(1) == 'a' && h.last == 'c')
			Array('m', 'c', 'c') ++ ca.takeRight(ca.length - 3)
		else if (h.head == 's' && h(1) == 'c' && h.last == 'h')
			Array('s', 's', 's') ++ ca.takeRight(ca.length - 3)
		else if (h.head == 'p' && (h(1) == 'h' || h(1) == 'f'))
			Array('f', 'f') ++ ca.takeRight(ca.length - 2)
		else if (h.head == 'k' && h(1) == 'n')
			Array('n', 'n') ++ ca.takeRight(ca.length - 2)
		else if (h.head == 'k')
			Array('c') ++ ca.takeRight(ca.length - 1)
		else ca
	}

	private[this] def transcodeLast(ca: Array[Char]) = {
		val h = ca.take(2).padTo(2, '\0')

		if ((h.last == 't' && (h.head == 'd' || h.head == 'r' || h.head == 'n')) ||
			(h.last == 'd' && (h.head == 'r' || h.head == 'n'))
		)
			Array('d') ++ ca.takeRight(ca.length - 2)
		else if (h.last == 'e' && (h.head == 'i' || h.head == 'e'))
			Array('y') ++ ca.takeRight(ca.length - 2)
		else ca
	}
}