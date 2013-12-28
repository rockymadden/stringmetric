package com.rockymadden.stringmetric

object Algorithm {
	trait AlgorithmLike[A] {
		def compute(a: A): Option[A]
	}


	trait StringAlgorithmLike extends AlgorithmLike[Array[Char]] {
		def compute(a: String): Option[String]
	}
}
