package com.rockymadden.stringmetric.tokenize

import com.rockymadden.stringmetric.Tokenizer.StringTokenizerLike

final case class NGramTokenizer(private val n: Int) extends StringTokenizerLike {
	override def tokenize(a: Array[Char]): Option[Array[Array[Char]]] = {
		if (n <= 0) return None

		if (a.length < n) None
		else Some(sequence(a, Array.empty[Array[Char]], n))
	}

	override def tokenize(a: String): Option[Array[String]] = tokenize(a.toCharArray).map(_.map(_.mkString))

	@annotation.tailrec
	private val sequence: ((Array[Char], Array[Array[Char]], Int) => Array[Array[Char]]) = (i, o, n) =>
		if (i.length <= n) o :+ i
		else sequence(i.tail, o :+ i.take(n), n)
}
