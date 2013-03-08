package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.filter.StringFilterDelegate

trait StringFilter extends Filter[String] with StringFilterable {
	override def filter(charArray: Array[Char]): Array[Char] = charArray
}

object StringFilter {
	type AsciiControlStringFilter = com.rockymadden.stringmetric.filter.AsciiControlStringFilter
	lazy val asciiControl = new StringFilterDelegate with AsciiControlStringFilter

	type AsciiControlOnlyStringFilter = com.rockymadden.stringmetric.filter.AsciiControlOnlyStringFilter
	lazy val asciiControlOnly = new StringFilterDelegate with AsciiControlOnlyStringFilter

	type AsciiLetterCaseStringFilter = com.rockymadden.stringmetric.filter.AsciiLetterCaseStringFilter
	lazy val asciiLetterCase = new StringFilterDelegate with AsciiLetterCaseStringFilter

	type AsciiLetterNumberStringFilter = com.rockymadden.stringmetric.filter.AsciiLetterNumberStringFilter
	lazy val asciiLetterNumber = new StringFilterDelegate with AsciiLetterNumberStringFilter

	type AsciiLetterNumberOnlyStringFilter = com.rockymadden.stringmetric.filter.AsciiLetterNumberOnlyStringFilter
	lazy val asciiLetterNumberOnly = new StringFilterDelegate with AsciiLetterNumberOnlyStringFilter

	type AsciiLetterStringFilter = com.rockymadden.stringmetric.filter.AsciiLetterStringFilter
	lazy val asciiLetter = new StringFilterDelegate with AsciiLetterStringFilter

	type AsciiLetterOnlyStringFilter = com.rockymadden.stringmetric.filter.AsciiLetterOnlyStringFilter
	lazy val asciiLetterOnly = new StringFilterDelegate with AsciiLetterOnlyStringFilter

	type AsciiNumberStringFilter = com.rockymadden.stringmetric.filter.AsciiNumberStringFilter
	lazy val asciiNumber = new StringFilterDelegate with AsciiNumberStringFilter

	type AsciiNumberOnlyStringFilter = com.rockymadden.stringmetric.filter.AsciiNumberOnlyStringFilter
	lazy val asciiNumberOnly = new StringFilterDelegate with AsciiNumberOnlyStringFilter

	type AsciiSpaceStringFilter = com.rockymadden.stringmetric.filter.AsciiSpaceStringFilter
	lazy val asciiSpace = new StringFilterDelegate with AsciiSpaceStringFilter

	type AsciiSymbolStringFilter = com.rockymadden.stringmetric.filter.AsciiSymbolStringFilter
	lazy val asciiSymbol = new StringFilterDelegate with AsciiSymbolStringFilter

	type AsciiSymbolOnlyStringFilter = com.rockymadden.stringmetric.filter.AsciiSymbolOnlyStringFilter
	lazy val asciiSymbolOnly = new StringFilterDelegate with AsciiSymbolOnlyStringFilter
}
