package com.rockymadden.stringmetric

trait transform {
	private lazy val Ascii = 0x00.toChar to 0x7F.toChar
	private lazy val ExtendedAscii = 0x00.toChar to 0x7F.toChar
	private lazy val Latin = 0x00.toChar to 0x24F.toChar
	private lazy val LowerCase = 'a' to 'z'
	private lazy val Numbers = '0' to '9'
	private lazy val UpperCase = 'A' to 'Z'
	private lazy val Alpha = LowerCase ++ UpperCase
	private lazy val AlphaNumeric = Alpha ++ Numbers

	val filterAlpha: StringTransform = _.filter(Alpha.contains)

	val filterNotAlpha: StringTransform = _.filterNot(Alpha.contains)

	val filterAlphaNumeric: StringTransform = _.filter(AlphaNumeric.contains)

	val filterNotAlphaNumeric: StringTransform = _.filterNot(AlphaNumeric.contains)

	val filterAscii: StringTransform = _.filter(Ascii.contains)

	val filterNotAscii: StringTransform = _.filterNot(Ascii.contains)

	val filterExtendedAscii: StringTransform = _.filter(ExtendedAscii.contains)

	val filterNotExtendedAscii: StringTransform = _.filterNot(ExtendedAscii.contains)

	val filterLatin: StringTransform = _.filter(Latin.contains)

	val filterNotLatin: StringTransform = _.filterNot(Latin.contains)

	val filterLowerCase: StringTransform = _.filter(LowerCase.contains)

	val filterNotLowerCase: StringTransform = _.filterNot(LowerCase.contains)

	val filterNumeric: StringTransform = _.filter(Numbers.contains)

	val filterNotNumeric: StringTransform = _.filterNot(Numbers.contains)

	val filterUpperCase: StringTransform = _.filter(UpperCase.contains)

	val filterNotUpperCase: StringTransform = _.filterNot(UpperCase.contains)

	val ignoreAlphaCase: StringTransform = _.map(c => if (UpperCase contains c) c.toLower else c)
}

object transform extends transform
