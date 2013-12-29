package com.rockymadden.stringmetric

object Transform {
	import scala.collection.immutable.NumericRange


	type Transform[A] = (A => A)
	type StringTransform = Transform[String]


	object StringTransform {
		private final val Ascii = NumericRange(0x00, 0x7F, 1)
		private final val ExtendedAscii = NumericRange(0x00, 0x7F, 1)
		private final val Latin = NumericRange(0x00, 0x24F, 1)
		private final val LowerCase = NumericRange(0x61, 0x7A, 1)
		private final val Numbers = NumericRange(0x30, 0x39, 1)
		private final val UpperCase = NumericRange(0x41, 0x5A, 1)

		private final val filter: ((String, (Char => Boolean)) => String) = (s, f) =>
			s.toCharArray.filter(c => f(c)).mkString

		private final val filterNot: ((String, (Char => Boolean)) => String) = (s, f) =>
			s.toCharArray.filterNot(c => f(c)).mkString

		val filterAlpha: StringTransform = (string) => filter(string, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci)
		})

		val filterNotAlpha: StringTransform = (string) => filterNot(string, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci)
		})

		val filterAlphaNumeric: StringTransform = (string) => filter(string, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci) || Numbers.contains(ci)
		})

		val filterNotAlphaNumeric: StringTransform = (string) => filterNot(string, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci) || Numbers.contains(ci)
		})

		val filterAscii: StringTransform = (string) => filter(string, c => Ascii.contains(c.toInt))

		val filterNotAscii: StringTransform = (string) => filterNot(string, c => Ascii.contains(c.toInt))

		val filterExtendedAscii: StringTransform = (string) => filter(string, c => ExtendedAscii.contains(c.toInt))

		val filterNotExtendedAscii: StringTransform = (string) => filterNot(string, c => ExtendedAscii.contains(c.toInt))

		val filterLatin: StringTransform = (string) => filter(string, c => Latin.contains(c.toInt))

		val filterNotLatin: StringTransform = (string) => filterNot(string, c => Latin.contains(c.toInt))

		val filterLowerCase: StringTransform = (string) => filter(string, c => LowerCase.contains(c.toInt))

		val filterNotLowerCase: StringTransform = (string) => filterNot(string, c => LowerCase.contains(c.toInt))

		val filterNumeric: StringTransform = (string) => filter(string, c => Numbers.contains(c.toInt))

		val filterNotNumeric: StringTransform = (string) => filterNot(string, c => Numbers.contains(c.toInt))

		val filterUpperCase: StringTransform = (string) => filter(string, c => UpperCase.contains(c.toInt))

		val filterNotUpperCase: StringTransform = (string) => filterNot(string, c => UpperCase.contains(c.toInt))
	}
}
