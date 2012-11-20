package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ FilterableStringAlgorithm, StringAlgorithm, StringFilter }
import org.hashtree.stringmetric.filter.StringFilterDelegate
import scala.annotation.tailrec

/** An implementation of the refined NYSIIS [[org.hashtree.stringmetric.StringAlgorithm]]. */
object RefinedNysiisAlgorithm extends StringAlgorithm with FilterableStringAlgorithm {
	type ComputeReturn = String

	override def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] = {
		val ca = stringFilter.filter(charArray)

		if (ca.length == 0) None
		else {
			if (!Alphabet.is(ca.head)) None
			else {
				val cal = ca.map(_.toLower)
				val thl = transcodeLast(transcodeHead(cal.head +: cleanLast(cal.tail, Set('s', 'z'))))
				val t = transcode(Array.empty[Char], thl.head, thl.tail, Array.empty[Char])

				if (t.length == 1) Some(t)
				else Some(deduplicate(t.head +: cleanTerminal(cleanLast(t.tail, Set('a')))))
			}
		}
	}

	override def compute(string: String)(implicit stringFilter: StringFilter): Option[ComputeReturn] =
		compute(stringFilter.filter(string.toCharArray))(new StringFilterDelegate).map(_.mkString)

	private[this] def cleanLast(ca: Array[Char], s: Set[Char]) =
		if (ca.length == 0) ca
		else if(s.contains(ca.last)) ca.dropRight(ca.reverseIterator.takeWhile(c => s.contains(c)).length)
		else ca

	private[this] def cleanTerminal(ca: Array[Char]) =
		if (ca.length >= 2 && ca.last == 'y' && ca(ca.length - 2) == 'a') ca.dropRight(2) :+ 'y'
		else ca

	private[this] def deduplicate(ca: Array[Char]) =
		if (ca.length <= 1) ca
		else ca.sliding(2).withFilter(a => a(0) != a(1)).map(a => a(0)).toArray[Char] :+ ca.last

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
						else if (!Alphabet.isVowel(l.last) || (r.length >= 1 && !Alphabet.isVowel(r.head))) shift(1, o)
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
						if (l.length >= 1 && Alphabet.isVowel(l.last)) shift(1, o)
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
	}

	private[this] def transcodeHead(ca: Array[Char]) = {
		if (ca.length == 0) ca
		else
			ca.head match {
				case 'm' if (ca.length >= 3 && ca(1) == 'a' && ca(2) == 'c') => Array('m', 'c') ++ ca.takeRight(ca.length - 3)
				case 'p' if (ca.length >= 2 && ca(1) == 'f') => 'f' +: ca.takeRight(ca.length - 2)
				case _ => ca
			}
	}

	private[this] def transcodeLast(ca: Array[Char]) = {
		if (ca.length >= 2) {
			val l = ca(ca.length - 1)
			val lm1 = ca(ca.length - 2)
			lazy val t2 = ca.take(ca.length - 2)

			l match {
				case 'd' if (lm1 == 'n' || lm1 == 'r') => t2 :+ 'd'
				case 'e' if (lm1 == 'e' || lm1 == 'i' || lm1 =='y') => t2 :+ 'y'
				case 't' if (lm1 == 'd' || lm1 == 'n' || lm1 == 'r') => t2 :+ 'd'
				case 'x' if (lm1 == 'e') => t2 ++ Array('e', 'c')
				case 'x' if (lm1 == 'i') => t2 ++ Array('i', 'c')
				case _ => ca
			}
		} else ca
	}
}