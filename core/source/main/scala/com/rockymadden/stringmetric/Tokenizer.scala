package com.rockymadden.stringmetric

trait Tokenizer[A, B, C] {
	def tokenize(a: A)(implicit b: B): Option[C]
}
