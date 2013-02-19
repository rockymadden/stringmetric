package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.similarity.NGramAlgorithm

trait ConfigurableStringAlgorithm[R, O] extends ConfigurableAlgorithm[String, R, O] with StringFilterable {
	def compute(charArray: Array[Char])(implicit o: O): Option[Array[_]]

	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}

object ConfigurableStringAlgorithm {
	def computeWithNGram(charArray: Array[Char])(n: Int): Option[Array[Array[Char]]] =
		NGramAlgorithm().compute(charArray)(n)

	def computeWithNGram(string: String)(n: Int): Option[Array[String]] = NGramAlgorithm().compute(string)(n)

	def nGram: NGramAlgorithm.type = NGramAlgorithm
}
