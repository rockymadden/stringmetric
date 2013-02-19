package com.rockymadden.stringmetric

trait StringFilterable extends Filterable[String] {
	def filter(charArray: Array[Char]): Array[Char]
}
