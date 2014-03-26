package com.rockymadden.stringmetric

sealed trait StringTokenizer extends Tokenizer[Array[Char]] {
	def tokenize(a: String): Option[Array[String]]
}


final case class NGramTokenizer(n: Int) extends StringTokenizer {
	override def tokenize(a: Array[Char]): Option[Array[Array[Char]]] =
		if (n <= 0 || a.length < n) None
		else Some(sequence(a, Array.empty[Array[Char]], n))

	override def tokenize(a: String): Option[Array[String]] = tokenize(a.toCharArray).map(_.map(_.mkString))

	@annotation.tailrec
	private val sequence: ((Array[Char], Array[Array[Char]], Int) => Array[Array[Char]]) = (i, o, n) =>
		if (i.length <= n) o :+ i
		else sequence(i.tail, o :+ i.take(n), n)
}
