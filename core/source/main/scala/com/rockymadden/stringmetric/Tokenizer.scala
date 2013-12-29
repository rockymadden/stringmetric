package com.rockymadden.stringmetric

object Tokenizer {
	trait Tokenizer[A] {
		def tokenize(a: A): Option[Array[A]]
	}


	trait StringTokenizer extends Tokenizer[Array[Char]] {
		def tokenize(a: String): Option[Array[String]]
	}
}
