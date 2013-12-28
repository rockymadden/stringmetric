package com.rockymadden.stringmetric

object Tokenizer {
	trait TokenizerLike[A] {
		def tokenize(a: A): Option[Array[A]]
	}


	trait StringTokenizerLike extends TokenizerLike[Array[Char]] {
		def tokenize(a: String): Option[Array[String]]
	}
}
