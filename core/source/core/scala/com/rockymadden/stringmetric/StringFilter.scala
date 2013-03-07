package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.filter._

trait StringFilter extends Filter[String] with StringFilterable {
	override def filter(charArray: Array[Char]): Array[Char] = charArray
}

object StringFilter {
	lazy val asciiControl = new StringFilterDelegate with AsciiControlStringFilter
	lazy val asciiControlOnly = new StringFilterDelegate with AsciiControlOnlyStringFilter
	lazy val asciiLetterCase = new StringFilterDelegate with AsciiLetterCaseStringFilter
	lazy val asciiLetterNumber = new StringFilterDelegate with AsciiLetterNumberStringFilter
	lazy val asciiLetterNumberOnly = new StringFilterDelegate with AsciiLetterNumberOnlyStringFilter
	lazy val asciiLetter = new StringFilterDelegate with AsciiLetterStringFilter
	lazy val asciiLetterOnly = new StringFilterDelegate with AsciiLetterOnlyStringFilter
	lazy val asciiNumber = new StringFilterDelegate with AsciiNumberStringFilter
	lazy val asciiNumberOnly = new StringFilterDelegate with AsciiNumberOnlyStringFilter
	lazy val asciiSpace = new StringFilterDelegate with AsciiSpaceStringFilter
	lazy val asciiSymbol = new StringFilterDelegate with AsciiSymbolStringFilter
	lazy val asciiSymbolOnly = new StringFilterDelegate with AsciiSymbolOnlyStringFilter
	lazy val delegate = new StringFilterDelegate
}
