package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.filter.StringFilterDelegate

trait StringFilter extends Filter[String] with StringFilterable {
	override def filter(charArray: Array[Char]): Array[Char] = charArray
}

object StringFilter {
	type AsciiControl = com.rockymadden.stringmetric.filter.AsciiControlStringFilter
	lazy val asciiControl = new StringFilterDelegate with AsciiControl

	type AsciiControlOnly = com.rockymadden.stringmetric.filter.AsciiControlOnlyStringFilter
	lazy val asciiControlOnly = new StringFilterDelegate with AsciiControlOnly

	type AsciiLetterCase = com.rockymadden.stringmetric.filter.AsciiLetterCaseStringFilter
	lazy val asciiLetterCase = new StringFilterDelegate with AsciiLetterCase

	type AsciiLetterNumber = com.rockymadden.stringmetric.filter.AsciiLetterNumberStringFilter
	lazy val asciiLetterNumber = new StringFilterDelegate with AsciiLetterNumber

	type AsciiLetterNumberOnly = com.rockymadden.stringmetric.filter.AsciiLetterNumberOnlyStringFilter
	lazy val asciiLetterNumberOnly = new StringFilterDelegate with AsciiLetterNumberOnly

	type AsciiLetter = com.rockymadden.stringmetric.filter.AsciiLetterStringFilter
	lazy val asciiLetter = new StringFilterDelegate with AsciiLetter

	type AsciiLetterOnly = com.rockymadden.stringmetric.filter.AsciiLetterOnlyStringFilter
	lazy val asciiLetterOnly = new StringFilterDelegate with AsciiLetterOnly

	type AsciiNumber = com.rockymadden.stringmetric.filter.AsciiNumberStringFilter
	lazy val asciiNumber = new StringFilterDelegate with AsciiNumber

	type AsciiNumberOnly = com.rockymadden.stringmetric.filter.AsciiNumberOnlyStringFilter
	lazy val asciiNumberOnly = new StringFilterDelegate with AsciiNumberOnly

	type AsciiSpace = com.rockymadden.stringmetric.filter.AsciiSpaceStringFilter
	lazy val asciiSpace = new StringFilterDelegate with AsciiSpace

	type AsciiSymbol = com.rockymadden.stringmetric.filter.AsciiSymbolStringFilter
	lazy val asciiSymbol = new StringFilterDelegate with AsciiSymbol

	type AsciiSymbolOnly = com.rockymadden.stringmetric.filter.AsciiSymbolOnlyStringFilter
	lazy val asciiSymbolOnly = new StringFilterDelegate with AsciiSymbolOnly
}
