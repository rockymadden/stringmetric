package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.{ StringAlgorithm, StringFilter, StringFilterDelegate }
import scala.annotation.tailrec

/** An implementation of the Metaphone [[org.hashtree.stringmetric.StringAlgorithm]]. */
object Metaphone extends StringAlgorithm {
	override def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] = {
		val ca = stringFilter.filter(charArray)

		if (ca.length == 0) None
		else {
			val e = exceptions(ca.map(_.toLower))
			val t = transformations(Array.empty[Char], e.head, e.tail, Array.empty[Char])

			if (t.length == 0)
				None
			else
				Some(t)
		}
	}

	override def compute(string: String)(implicit stringFilter: StringFilter): Option[String] = {
		compute(stringFilter.filter(string.toCharArray))(new StringFilterDelegate) match {
			case Some(mp) => Some(mp.mkString)
			case None => None
		}
	}

	private[this] def exceptions(ca: Array[Char]): Array[Char] = {
		val deduplicate = (x: Array[Char]) => {
			x.sliding(2).filter(a => a(0) == 'c' || a(0) != a(1)).map(a => a(0)).toArray[Char] :+ x.last
		}

		ca.length match {
			case 0 => Array.empty[Char]
			case 1 if ca.head == 'x' => Array('s')
			case 1 => ca
			case _ if ca.head == 'x' => 's' +: deduplicate(ca.tail)
			case _ => {
				"" + ca.head + ca.tail.head match {
					case "ae" | "gn" | "kn" | "pn" | "wr" => ca.tail
					case "wh" => 'w' +: deduplicate(ca.tail.tail)
					case _ => deduplicate(ca)
				}
			}
		}
	}

	private[this] def isVowel(c: Char) = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')

	@tailrec
	private[this] def transformations(l: Array[Char], c: Char, r: Array[Char], o: Array[Char]): Array[Char] = {
		if (c == '\0' && r.length == 0) o
		else {
			val lshift = (d: Int) => if (d == 1) l :+ c else (l :+ c) ++ r.take(d - 1)
			val cshift = (d: Int) => if (d > r.length) '\0' else r(d - 1)
			val rshift = (d: Int) => if (d >= r.length) Array.empty[Char] else r.drop(d)

			c match {
				case 'a' | 'e' | 'i' | 'o' | 'u' => {
					if (l.length == 0)
						transformations(lshift(1), cshift(1), rshift(1), o :+ c)
					else
						transformations(lshift(1), cshift(1), rshift(1), o)
				}
				case 'f' | 'j' | 'l' | 'm' | 'n' | 'r' => transformations(lshift(1), cshift(1), rshift(1), o :+ c)
				case 'b' => {
					if (
						(l.length >= 1 && l.last == 'm' && r.length == 0)
					)
						transformations(lshift(1), cshift(1), rshift(1), o)
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'b')
				}
				case 'c' => {
					if (
						(r.length >= 1 && r.head == 'h' && l.length >= 1 && l.last == 's')
					)
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'k')
					else if (
						(r.length >= 2 && r.head == 'i' && r.tail.head == 'a')
					)
						transformations(lshift(3), cshift(3), rshift(3), o :+ 'x')
					else if (
						(r.length >= 1 && r.head == 'h') ||
						(l.length >= 1 && r.length >= 1 && l.last == 's' && r.head == 'h')
					)
						transformations(lshift(2), cshift(2), rshift(2), o :+ 'x')
					else if (
						(l.length >= 1 && r.length >= 1 && l.last == 's' && (
								r.head == 'i' ||
								r.head == 'e' ||
								r.head == 'y'
							)
						)
					)
						transformations(lshift(1), cshift(1), rshift(1), o)
					else if (
						(r.length >= 1 && (
								r.head == 'i' ||
								r.head == 'e' ||
								r.head == 'y'
							)
						)
					)
						transformations(lshift(1), cshift(1), rshift(1), o :+ 's')
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'k')
				}
				case 'd' => {
					if (
						(r.length >= 2 && r.head == 'g' && (
								r.tail.head == 'e' ||
								r.tail.head == 'y' ||
								r.tail.head == 'i'
							)
						)
					)
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'j') // just d
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 't')
				}
				case 'g' => {
					if (
						(r.length > 1 && r.head == 'h') ||
						(r.length == 1 && r.head == 'n') ||
						(r.length == 3 && r.head == 'n' && r.tail.head == 'e' && r.tail.tail.head == 'd')
					)
						transformations(lshift(1), cshift(1), rshift(1), o) // just g
					else if (
						(r.length >= 1 && (
								r.head == 'i' ||
								r.head == 'e' ||
								r.head == 'y'
							)
						)
					)
						transformations(lshift(2), cshift(2), rshift(2), o :+ 'j')
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'k')
				}
				case 'h' => {
					if (
						(l.length >= 1 && isVowel(l.last) && (r.length == 0 || !isVowel(r.head))) ||
						(l.length >= 2 && l.last == 'h' && (
								l(l.length - 2) == 'c' ||
								l(l.length - 2) == 's' ||
								l(l.length - 2) == 'p' ||
								l(l.length - 2) == 't' ||
								l(l.length - 2) == 'g'
							)
						)
					)
						transformations(lshift(1), cshift(1), rshift(1), o)
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'h')
				}
				case 'k' => {
					if (
						(l.length >= 1 && l.last == 'c') // raw
					)
						transformations(lshift(1), cshift(1), rshift(1), o)
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'k')
				}
				case 'p' => {
					if (
						(r.length >= 1 && r.head == 'h')
					)
						transformations(lshift(2), cshift(2), rshift(2), o :+ 'f')
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 'p')
				}
				case 'q' => transformations(lshift(1), cshift(1), rshift(1), o :+ 'k')
				case 's' => {
					if (

						(r.length >= 2 && r.head == 'i' && (
								r.tail.head == 'o' ||
								r.tail.head == 'a'
							)
						)
					)
						transformations(lshift(3), cshift(3), rshift(3), o :+ 'x')
					else if (
						(r.length >= 1 && r.head == 'h')
					)
						transformations(lshift(2), cshift(2), rshift(2), o :+ 'x')
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 's')
				}
				case 't' => {
					if (
						(r.length >= 2 && r.head == 'i' && (
								r.tail.head == 'a' ||
								r.tail.head == 'o'
							)
						)
					)
						transformations(lshift(3), cshift(3), rshift(3), o :+ 'x')
					else if (r.length >= 1 && r.head == 'h')
						transformations(lshift(2), cshift(2), rshift(2), o :+ '0')
					else if (r.length >= 2 && r.head == 'c' && r.tail.head == 'h')
						transformations(lshift(1), cshift(1), rshift(1), o) // only t
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ 't')
				}
				case 'v' => transformations(lshift(1), cshift(1), rshift(1), o :+ 'f')
				case 'w' | 'y' => {
					if (r.length == 0 || !isVowel(r.head))
						transformations(lshift(1), cshift(1), rshift(1), o)
					else
						transformations(lshift(1), cshift(1), rshift(1), o :+ c)
				}
				case 'x' => transformations(lshift(1), cshift(1), rshift(1), (o :+ 'k') :+ 's')
				case 'z' => transformations(lshift(1), cshift(1), rshift(1), o :+ 's')
				case _ => transformations(lshift(1), cshift(1), rshift(1), o)
			}
		}
	}
}