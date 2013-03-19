package com.rockymadden.stringmetric

trait ConfigurableStringAlgorithm[O, R] extends ConfigurableAlgorithm[String, O, R] {
	def compute(charArray: Array[Char])(implicit o: O): Option[Array[_]]
}

object ConfigurableStringAlgorithm
