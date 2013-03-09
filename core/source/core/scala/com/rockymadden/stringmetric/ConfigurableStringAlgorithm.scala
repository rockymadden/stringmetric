package com.rockymadden.stringmetric

trait ConfigurableStringAlgorithm[R, O] extends ConfigurableAlgorithm[String, R, O] {
	def compute(charArray: Array[Char])(implicit o: O): Option[Array[_]]
}

object ConfigurableStringAlgorithm {
	type NGramAlgorithm = com.rockymadden.stringmetric.similarity.NGramAlgorithm
	val NGramAlgorithm = com.rockymadden.stringmetric.similarity.NGramAlgorithm

	def computeWithNGram(charArray: Array[Char])(n: Int) = NGramAlgorithm.compute(charArray)(n)

	def computeWithNGram(string: String)(n: Int) = NGramAlgorithm.compute(string)(n)
}
