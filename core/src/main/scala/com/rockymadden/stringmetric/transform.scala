package com.rockymadden.stringmetric

trait transform {
	private val Ascii = 0x00.toChar to 0x7F.toChar
	private val ExtendedAscii = 0x00.toChar to 0x7F.toChar
	private val Latin = 0x00.toChar to 0x24F.toChar
	private val LowerCase = 'a' to 'z'
	private val Numbers = '0' to '9'
	private val UpperCase = 'A' to 'Z'

	private val filter: ((Array[Char], (Char => Boolean)) => String) = (ca, f) =>
		ca.filter(c => f(c)).mkString

	private val filterNot: ((Array[Char], (Char => Boolean)) => String) = (ca, f) =>
		ca.filterNot(c => f(c)).mkString

	val filterAlpha: StringTransform = (ca) =>
		filter(ca, c => LowerCase.contains(c) || UpperCase.contains(c))

	val filterNotAlpha: StringTransform = (ca) =>
		filterNot(ca, c => LowerCase.contains(c) || UpperCase.contains(c))

	val filterAlphaNumeric: StringTransform = (ca) =>
		filter(ca, c => LowerCase.contains(c) || UpperCase.contains(c) || Numbers.contains(c))

	val filterNotAlphaNumeric: StringTransform = (ca) =>
		filterNot(ca, c => LowerCase.contains(c) || UpperCase.contains(c) || Numbers.contains(c))

	val filterAscii: StringTransform = (ca) => filter(ca, Ascii.contains)

	val filterNotAscii: StringTransform = (ca) => filterNot(ca, Ascii.contains)

	val filterExtendedAscii: StringTransform = (ca) => filter(ca, ExtendedAscii.contains)

	val filterNotExtendedAscii: StringTransform = (ca) => filterNot(ca, ExtendedAscii.contains)

	val filterLatin: StringTransform = (ca) => filter(ca, Latin.contains)

	val filterNotLatin: StringTransform = (ca) => filterNot(ca, Latin.contains)

	val filterLowerCase: StringTransform = (ca) => filter(ca, LowerCase.contains)

	val filterNotLowerCase: StringTransform = (ca) => filterNot(ca, LowerCase.contains)

	val filterNumeric: StringTransform = (ca) => filter(ca, Numbers.contains)

	val filterNotNumeric: StringTransform = (ca) => filterNot(ca, Numbers.contains)

	val filterUpperCase: StringTransform = (ca) => filter(ca, UpperCase.contains)

	val filterNotUpperCase: StringTransform = (ca) => filterNot(ca, UpperCase.contains)

	val ignoreAlphaCase: StringTransform = (ca) => ca.map(_.toLower)
}

object transform extends transform
