package org.hashtree.stringmetric.similarity

import org.hashtree.stringmetric.{ FilterableConfigurableStringAlgorithm, StringAlgorithm, StringFilter }
import scala.annotation.tailrec

/** An implementation of the N-Gram [[org.hashtree.stringmetric.StringAlgorithm]]. */
object NGramAlgorithm extends StringAlgorithm with FilterableConfigurableStringAlgorithm[Int] {
	type ComputeReturn = Array[String]

	override def compute(charArray: Array[Char])(n: Int)
		(implicit stringFilter: StringFilter): Option[Array[Array[Char]]] = {

		if (n <= 0) throw new IllegalArgumentException("Expected valid n.")

		val fca = stringFilter.filter(charArray)

		if (fca.length < n) None
		else Some(sequence(fca, Array.empty[Array[Char]], n))
	}

	override def compute(string: String)(n: Int)
		(implicit stringFilter: StringFilter): Option[ComputeReturn] =

		compute(stringFilter.filter(string.toCharArray))(n).map(_.map(_.mkString))

	@tailrec
	private[this] def sequence(i: Array[Char], o: Array[Array[Char]], n: Int): Array[Array[Char]] = {
		require(n > 0)

		if (i.length <= n) o :+ i
		else sequence(i.tail, o :+ i.take(n), n)
	}
}