package com.rockymadden.stringmetric

trait StringFilterLike extends FilterLike[String] {
	def filter(charArray: Array[Char]): Array[Char]
}
