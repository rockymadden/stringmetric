package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringAlgorithm, StringAlgorithm, StringFilter }
import org.hashtree.stringmetric.filter.StringFilterDelegate
import scala.annotation.tailrec

/** An implementation of the NYSIIS [[org.hashtree.stringmetric.StringAlgorithm]]. */
object NysiisAlgorithm extends StringAlgorithm with FilterableStringAlgorithm {
	type ComputeReturn = String

	override def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] = {
		val ca = stringFilter.filter(charArray)

		if (ca.length == 0) None
		else {
			val cal = ca.map(_.toLower)

			if (cal.head < 97 || cal.head > 122) None
			else {
				val tl = transcodeLeft(cal)
				val tr = transcodeRight(tl._2)
				val t =
					if (tr._1.length == 0) tl._1 ++ tr._2
					else if (tr._1.length == 1)
						if (tl._1.length == 0) tl._1 ++ tr._1 ++ tr._2
						else
							tl._1 ++ transcodeCenter(Array.empty[Char], tr._1.head, Array.empty[Char], Array.empty[Char]) ++ tr._2
					else
						if (tl._1.length == 0) {
							val ts = tr._1.splitAt(1)
							val tc = transcodeCenter(Array.empty[Char], ts._2.head, ts._2.tail, ts._1)

							tl._1 ++ tc ++ tr._2
						} else
							tl._1 ++ transcodeCenter(Array.empty[Char], tr._1.head, tr._1.tail, Array.empty[Char]) ++ tr._2

				Some(t.head +: deduplicate(clean(t.tail)))
			}
		}
	}

	override def compute(string: String)(implicit stringFilter: StringFilter): Option[ComputeReturn] =
		compute(stringFilter.filter(string.toCharArray))(new StringFilterDelegate) match {
			case Some(ny) => Some(ny.mkString)
			case None => None
		}

	private[this] def clean(ca: Array[Char]) =
		if (ca.length >= 1 && (ca.last == 'a' || ca.last == 's'))
			ca.dropRight(ca.reverseIterator.takeWhile(c => c == 'a' || c == 's').length)
		else if (ca.length >= 2 && ca.last == 'y' && ca(ca.length - 2) == 'a')
			ca.dropRight(2) :+ 'y'
		else ca

	private[this] def deduplicate(ca: Array[Char]) =
		if (ca.length <= 1) ca
		else
			ca.sliding(2).withFilter(a => a(0) != a(1)).map(a => a(0)).toArray[Char] :+ ca.last

	private[this] def isVowel(c: Char) = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')

	@tailrec
	private[this] def transcodeCenter(l: Array[Char], c: Char, r: Array[Char], o: Array[Char]): Array[Char] = {
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
					case 'e' =>
						if (r.length >= 1 && r.head == 'v')
							shift(2, o ++ Array('a', 'f'))
						else
							shift(1, o :+ 'a')
					case 'h' =>
						if (l.length >= 1 && (!isVowel(l.last) || (r.length >= 1 && !isVowel(r.head))))
							shift(1, o)
						else
							shift(1, o :+ c)
					case 'k' => if (r.length >= 1 && r.head == 'n') shift(2, o :+ 'n') else shift(1, o :+ 'c')
					case 'm' => shift(1, o :+ 'n')
					case 'p' => if (r.length >= 1 && r.head == 'h') shift(2, o ++ Array('f', 'f')) else shift(1, o :+ 'p')
					case 'q' => shift(1, o :+ 'g')
					case 's' =>
						if (r.length >= 2 && r.head == 'c' && r(1) == 'h')
							shift(3, o ++ Array('s', 's', 's'))
						else
							shift(1, o :+ c)
					case 'w' =>
						if (l.length >= 1 && isVowel(l.last))
							shift(1, o)
						else
							shift(1, o :+ c)
					case 'z' => shift(1, o :+ 's')
					case _ => shift(1, o)
				}
			}

			transcodeCenter(t._1, t._2, t._3, t._4)
		}
	}

	private[this] def transcodeLeft(ca: Array[Char]) = {
		val l = ca.take(3).padTo(3, '\0')

		if (l.head == 'm' && l(1) == 'a' && l.last == 'c')
			(Array('m', 'c', 'c'), ca.takeRight(ca.length - 3))
		else if (l.head == 's' && l(1) == 'c' && l.last == 'h')
			(Array('s', 's', 's'), ca.takeRight(ca.length - 3))
		else if (l.head == 'p' && (l(1) == 'h' || l(1) == 'f'))
			(Array('f', 'f'), ca.takeRight(ca.length - 2))
		else if (l.head == 'k' && l(1) == 'n')
			(Array('n', 'n'), ca.takeRight(ca.length - 2))
		else if (l.head == 'k')
			(Array('c'), ca.takeRight(ca.length - 1))
		else (Array.empty[Char], ca)
	}

	private[this] def transcodeRight(ca: Array[Char]) = {
		val r = ca.takeRight(2).padTo(2, '\0')

		if ((r.last == 't' && (r.head == 'd' || r.head == 'r' || r.head == 'n'))
			|| (r.last == 'd' && (r.head == 'r' || r.head == 'n'))
		)
			(ca.take(ca.length - 2), Array('d'))
		else if (r.last == 'e' && (r.head == 'i' || r.head == 'e'))
			(ca.take(ca.length - 2), Array('y'))
		else (ca, Array.empty[Char])
	}
}