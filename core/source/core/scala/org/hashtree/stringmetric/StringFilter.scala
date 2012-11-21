package org.hashtree.stringmetric

import org.hashtree.stringmetric.filter._

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Filter]]. */
trait StringFilter extends Filter[String] {
	def filter(charArray: Array[Char]): Array[Char]
}

/** Convenience object for those extending [[org.hashtree.stringmetric.StringFilter]]. */
object StringFilter {
	implicit val stringFilter = delegate

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