package com.rockymadden.stringmetric

object Transform {
	import scala.collection.immutable.NumericRange


	type Transform[A] = (A => A)
	type StringTransform = Transform[Array[Char]]


	object StringTransform {
		private final val Ascii = NumericRange(0x00, 0x7F, 1)
		private final val ExtendedAscii = NumericRange(0x00, 0x7F, 1)
		private final val Latin = NumericRange(0x00, 0x24F, 1)
		private final val LowerCase = NumericRange(0x61, 0x7A, 1)
		private final val Numbers = NumericRange(0x30, 0x39, 1)
		private final val UpperCase = NumericRange(0x41, 0x5A, 1)

		private final val filter: ((Array[Char], (Char => Boolean)) => String) = (ca, f) =>
			ca.filter(c => f(c)).mkString

		private final val filterNot: ((Array[Char], (Char => Boolean)) => String) = (ca, f) =>
			ca.filterNot(c => f(c)).mkString

		val filterAlpha: StringTransform = (ca) => filter(ca, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci)
		})

		val filterNotAlpha: StringTransform = (ca) => filterNot(ca, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci)
		})

		val filterAlphaNumeric: StringTransform = (ca) => filter(ca, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci) || Numbers.contains(ci)
		})

		val filterNotAlphaNumeric: StringTransform = (ca) => filterNot(ca, c => {
			val ci = c.toInt
			LowerCase.contains(ci) || UpperCase.contains(ci) || Numbers.contains(ci)
		})

		val filterAscii: StringTransform = (ca) => filter(ca, c => Ascii.contains(c.toInt))

		val filterNotAscii: StringTransform = (ca) => filterNot(ca, c => Ascii.contains(c.toInt))

		val filterExtendedAscii: StringTransform = (ca) => filter(ca, c => ExtendedAscii.contains(c.toInt))

		val filterNotExtendedAscii: StringTransform = (ca) => filterNot(ca, c => ExtendedAscii.contains(c.toInt))

		val filterLatin: StringTransform = (ca) => filter(ca, c => Latin.contains(c.toInt))

		val filterNotLatin: StringTransform = (ca) => filterNot(ca, c => Latin.contains(c.toInt))

		val filterLowerCase: StringTransform = (ca) => filter(ca, c => LowerCase.contains(c.toInt))

		val filterNotLowerCase: StringTransform = (ca) => filterNot(ca, c => LowerCase.contains(c.toInt))

		val filterNumeric: StringTransform = (ca) => filter(ca, c => Numbers.contains(c.toInt))

		val filterNotNumeric: StringTransform = (ca) => filterNot(ca, c => Numbers.contains(c.toInt))

		val filterUpperCase: StringTransform = (ca) => filter(ca, c => UpperCase.contains(c.toInt))

		val filterNotUpperCase: StringTransform = (ca) => filterNot(ca, c => UpperCase.contains(c.toInt))
	}
}
