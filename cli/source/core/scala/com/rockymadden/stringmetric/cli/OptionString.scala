package com.rockymadden.stringmetric.cli

import scala.language.implicitConversions

class OptionString(val self: String)

object OptionString {
	implicit def OptionStringToArray(optionString: OptionString): Array[String] =
		if (optionString.self.length == 0) Array.empty[String] else optionString.self.split(" ")

	implicit def OptionStringToBigDecimal(optionString: OptionString): BigDecimal = BigDecimal(optionString.self)

	implicit def OptionStringToBigInt(optionString: OptionString): BigInt = BigInt(optionString.self)

	implicit def OptionStringToDouble(optionString: OptionString): Double = optionString.self.toDouble

	implicit def OptionStringToFloat(optionString: OptionString): Float = optionString.self.toFloat

	implicit def OptionStringToInt(optionString: OptionString): Int = optionString.self.toInt

	implicit def OptionStringToLong(optionString: OptionString): Long = optionString.self.toLong

	implicit def OptionStringToShort(optionString: OptionString): Short = optionString.self.toShort

	implicit def OptionStringToString(optionString: OptionString): String = optionString.self

	implicit def StringToOptionString(string: String): OptionString = apply(string)

	def apply(string: String): OptionString = new OptionString(string)
}
