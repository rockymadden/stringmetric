package com.rockymadden.stringmetric

trait ConfigurableStringAlgorithmLike[R, O] extends ConfigurableAlgorithmLike[String, R, O] {
	def compute(charArray: Array[Char])(implicit o: O): Option[Array[_]]
}
