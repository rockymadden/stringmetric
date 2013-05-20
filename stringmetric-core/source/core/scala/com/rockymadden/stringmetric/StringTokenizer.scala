package com.rockymadden.stringmetric

trait StringTokenizer[A, B] extends Tokenizer[String, A, B] {
	def tokenize(charArray: Array[Char])(implicit a: A): Option[Array[Array[Char]]]
}

object StringTokenizer {
	type NGram = com.rockymadden.stringmetric.tokenization.NGramTokenizer
	val NGram = com.rockymadden.stringmetric.tokenization.NGramTokenizer

	def tokenizeWithNGram(charArray: Array[Char])(n: Int) = NGram.tokenize(charArray)(n)

	def tokenizeWithNGram(string: String)(n: Int) = NGram.tokenize(string)(n)
}
