package com.rockymadden.stringmetric

trait ConfigurableStringAlgorithmLike[R, O] extends ConfigurableAlgorithmLike[String, R, O] { this: StringFilterLike =>
	def compute(charArray: Array[Char])(implicit o: O): Option[Array[_]]

	override def filter(charArray: Array[Char]): Array[Char] = charArray

	override def filter(string: String): String = string
}
