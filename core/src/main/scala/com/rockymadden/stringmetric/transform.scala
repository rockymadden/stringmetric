package com.rockymadden.stringmetric

trait transform {
	private val Ascii = 0x00.toChar to 0x7F.toChar
	private val ExtendedAscii = 0x00.toChar to 0x7F.toChar
	private val Latin = 0x00.toChar to 0x24F.toChar
	private val LowerCase = 'a' to 'z'
	private val Numbers = '0' to '9'
	private val UpperCase = 'A' to 'Z'

	val filterAlpha: StringTransform =
		_.filter(c => LowerCase.contains(c) || UpperCase.contains(c))

	val filterNotAlpha: StringTransform =
		_.filterNot(c => LowerCase.contains(c) || UpperCase.contains(c))

	val filterAlphaNumeric: StringTransform =
		_.filter(c => LowerCase.contains(c) || UpperCase.contains(c) || Numbers.contains(c))

	val filterNotAlphaNumeric: StringTransform =
		_.filterNot(c => LowerCase.contains(c) || UpperCase.contains(c) || Numbers.contains(c))

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
