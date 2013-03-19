package com.rockymadden.stringmetric

trait Tokenizer[T, O, R] {
	def tokenize(t: T)(implicit o: O): Option[R]
}
