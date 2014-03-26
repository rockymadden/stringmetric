package com.rockymadden.stringmetric

trait Tokenizer[A] {
	def tokenize(a: A): Option[Array[A]]
}
