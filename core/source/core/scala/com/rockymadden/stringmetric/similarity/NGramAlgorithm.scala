package com.rockymadden.stringmetric.similarity

import com.rockymadden.stringmetric.ConfigurableStringAlgorithm
import scala.annotation.tailrec

/** An implementation of the N-Gram algorithm. */
class NGramAlgorithm extends ConfigurableStringAlgorithm[Array[String], Int] {
	final override def compute(charArray: Array[Char])(implicit n: Int): Option[Array[Array[Char]]] = {
		if (n <= 0) throw new IllegalArgumentException("Expected valid n.")

		val fca = filter(charArray)

		if (fca.length < n) None
		else Some(sequence(fca, Array.empty[Array[Char]], n))
	}

	final override def compute(string: String)(implicit n: Int): Option[Array[String]] =
		compute(filter(string.toCharArray))(n).map(_.map(_.mkString))

	@tailrec
	private[this] def sequence(i: Array[Char], o: Array[Array[Char]], n: Int): Array[Array[Char]] = {
		require(n > 0)

		if (i.length <= n) o :+ i
		else sequence(i.tail, o :+ i.take(n), n)
	}
}

object NGramAlgorithm {
	def apply(): NGramAlgorithm = new NGramAlgorithm
}
