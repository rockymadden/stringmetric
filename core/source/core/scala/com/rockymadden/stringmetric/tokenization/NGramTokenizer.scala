package com.rockymadden.stringmetric.tokenization

import com.rockymadden.stringmetric.{StringFilter, StringTokenizer}
import scala.annotation.tailrec

/** An implementation of the N-Gram tokenizer. */
class NGramTokenizer extends StringTokenizer[Int, Array[String]] { this: StringFilter =>
	final override def tokenize(charArray: Array[Char])(implicit n: Int): Option[Array[Array[Char]]] = {
		if (n <= 0) throw new IllegalArgumentException("Expected valid n.")

		val fca = filter(charArray)

		if (fca.length < n) None
		else Some(sequence(fca, Array.empty[Array[Char]], n))
	}

	final override def tokenize(string: String)(implicit n: Int): Option[Array[String]] =
		tokenize(string.toCharArray)(n).map(_.map(_.mkString))

	@tailrec
	private[this] def sequence(i: Array[Char], o: Array[Array[Char]], n: Int): Array[Array[Char]] = {
		require(n > 0)

		if (i.length <= n) o :+ i
		else sequence(i.tail, o :+ i.take(n), n)
	}
}

object NGramTokenizer {
	private lazy val self = apply()

	def apply(): NGramTokenizer = new NGramTokenizer with StringFilter

	def tokenize(charArray: Array[Char])(n: Int) = self.tokenize(charArray)(n)

	def tokenize(string: String)(n: Int) = self.tokenize(string)(n)
}
