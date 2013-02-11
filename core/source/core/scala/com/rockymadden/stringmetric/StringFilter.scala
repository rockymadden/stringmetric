package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.filter._

trait StringFilter extends StringFilterLike {
	def filter(charArray: Array[Char]): Array[Char]
}

object StringFilter {
	def asciiControl = new StringFilterDelegate with AsciiControlStringFilter

	def asciiControlOnly = new StringFilterDelegate with AsciiControlOnlyStringFilter

	def asciiLetterCase = new StringFilterDelegate with AsciiLetterCaseStringFilter

	def asciiLetterNumber = new StringFilterDelegate with AsciiLetterNumberStringFilter

	def asciiLetterNumberOnly = new StringFilterDelegate with AsciiLetterNumberOnlyStringFilter

	def asciiLetter = new StringFilterDelegate with AsciiLetterStringFilter

	def asciiLetterOnly = new StringFilterDelegate with AsciiLetterOnlyStringFilter

	def asciiNumber = new StringFilterDelegate with AsciiNumberStringFilter

	def asciiNumberOnly = new StringFilterDelegate with AsciiNumberOnlyStringFilter

	def asciiSpace = new StringFilterDelegate with AsciiSpaceStringFilter

	def asciiSymbol = new StringFilterDelegate with AsciiSymbolStringFilter

	def asciiSymbolOnly = new StringFilterDelegate with AsciiSymbolOnlyStringFilter

	def delegate = new StringFilterDelegate
}
