package com.rockymadden.stringmetric

trait StringAlgorithmLike[R] extends AlgorithmLike[String, R] {
	def compute(charArray: Array[Char]): Option[Array[_]]
}
