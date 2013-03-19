package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.filter.StringFilterDelegate

trait StringFilter extends Filter[String] with StringFilterable {
	override def filter(charArray: Array[Char]): Array[Char] = charArray
}

object StringFilter {
	type AsciiControl = com.rockymadden.stringmetric.filter.AsciiControlFilter
	lazy val asciiControl = new StringFilterDelegate with AsciiControl

	type AsciiControlOnly = com.rockymadden.stringmetric.filter.AsciiControlOnlyFilter
	lazy val asciiControlOnly = new StringFilterDelegate with AsciiControlOnly

	type AsciiLetterNumber = com.rockymadden.stringmetric.filter.AsciiLetterNumberFilter
	lazy val asciiLetterNumber = new StringFilterDelegate with AsciiLetterNumber

	type AsciiLetterNumberOnly = com.rockymadden.stringmetric.filter.AsciiLetterNumberOnlyFilter
	lazy val asciiLetterNumberOnly = new StringFilterDelegate with AsciiLetterNumberOnly

	type AsciiLetter = com.rockymadden.stringmetric.filter.AsciiLetterFilter
	lazy val asciiLetter = new StringFilterDelegate with AsciiLetter

	type AsciiLetterOnly = com.rockymadden.stringmetric.filter.AsciiLetterOnlyFilter
	lazy val asciiLetterOnly = new StringFilterDelegate with AsciiLetterOnly

	type AsciiNumber = com.rockymadden.stringmetric.filter.AsciiNumberFilter
	lazy val asciiNumber = new StringFilterDelegate with AsciiNumber

	type AsciiNumberOnly = com.rockymadden.stringmetric.filter.AsciiNumberOnlyFilter
	lazy val asciiNumberOnly = new StringFilterDelegate with AsciiNumberOnly

	type AsciiSpace = com.rockymadden.stringmetric.filter.AsciiSpaceFilter
	lazy val asciiSpace = new StringFilterDelegate with AsciiSpace

	type AsciiSymbol = com.rockymadden.stringmetric.filter.AsciiSymbolFilter
	lazy val asciiSymbol = new StringFilterDelegate with AsciiSymbol

	type AsciiSymbolOnly = com.rockymadden.stringmetric.filter.AsciiSymbolOnlyFilter
	lazy val asciiSymbolOnly = new StringFilterDelegate with AsciiSymbolOnly

	type IgnoreAsciiLetterCase = com.rockymadden.stringmetric.filter.IgnoreAsciiLetterCaseFilter
	lazy val ignoreAsciiLetterCase = new StringFilterDelegate with IgnoreAsciiLetterCase
}
