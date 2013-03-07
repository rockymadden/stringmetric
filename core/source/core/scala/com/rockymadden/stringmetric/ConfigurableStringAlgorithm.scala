package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.similarity.NGramAlgorithm

trait ConfigurableStringAlgorithm[R, O] extends ConfigurableAlgorithm[String, R, O] {
	def compute(charArray: Array[Char])(implicit o: O): Option[Array[_]]
}

object ConfigurableStringAlgorithm {
	lazy val nGram = NGramAlgorithm()

	def computeWithNGram(charArray: Array[Char])(n: Int): Option[Array[Array[Char]]] = nGram.compute(charArray)(n)

	def computeWithNGram(string: String)(n: Int): Option[Array[String]] = nGram.compute(string)(n)
}
