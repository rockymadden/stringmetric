package com.rockymadden.stringmetric

/**
 * Provides core CLI functionality. Note that some things might look sloppy (e.g. access modifiers, broad imports,
 * repetitive imports, etc), but are required because of the way scalascript is ultimately compiled.
 */
package object cli {
	import scala.language.implicitConversions


	implicit def optionStringToArray(os: OptionString): Array[String] =
		if (os.get.length == 0) Array.empty[String] else os.get.split(" ")
	implicit def optionStringToBigDecimal(os: OptionString): BigDecimal = BigDecimal(os.get)
	implicit def optionStringToBigInt(os: OptionString): BigInt = BigInt(os.get)
	implicit def optionStringToDouble(os: OptionString): Double = os.get.toDouble
	implicit def optionStringToFloat(os: OptionString): Float = os.get.toFloat
	implicit def optionStringToInt(os: OptionString): Int = os.get.toInt
	implicit def optionStringToLong(os: OptionString): Long = os.get.toLong
	implicit def optionStringToShort(os: OptionString): Short = os.get.toShort
	implicit def optionStringToString(os: OptionString): String = os.get
	implicit def stringToOptionString(s: String): OptionString = OptionString(s)
	implicit def arrayOfStringToOptionMap(stringArray: Array[String]): OptionMap = OptionMap(stringArray)


	class OptionString(val get: String)

	object OptionString {
		def apply(s: String): OptionString = new OptionString(s)
	}


	type OptionMap = Map[Symbol, OptionString]

	object OptionMap {
		def apply(args: Array[String]): OptionMap = apply(args: _*)

		def apply(varargs: String*): OptionMap = {
			@annotation.tailrec
			def next(om: OptionMap, a: List[String]): OptionMap = {
				val double = """^(--[a-zA-Z0-9]+)(=[a-zA-Z0-9\.\-_]+)?""".r
				val single = """^(-[a-zA-Z0-9]+)(=[a-zA-Z0-9\.\-_]+)?""".r
				val less = """([a-zA-Z0-9/\-_\$\.]+)""".r

				a match {
					// Empty, return.
					case Nil => om
					// Double dash options without value.
					case double(k, null) :: t => next(om + (Symbol(k.tail.tail) -> ""), t)
					// Double dash options with value.
					case double(k, v) :: t => next(om + (Symbol(k.tail.tail) -> v.tail), t)
					// Single dash options without value.
					case single(k, null) :: t => next(om + (Symbol(k.tail) -> ""), t)
					// Single dash options with value. Value is discarded.
					case single(k, v) :: t => next(om + (Symbol(k.tail) -> ""), t)
					// Dashless options.
					case less(v) :: t if v.head != '-' =>
						if (om.contains('dashless))
							next((om - 'dashless) + ('dashless -> (om('dashless).get + " " + v.trim)), t)
						else next(om + ('dashless -> v.trim), t)
					// Invalid option, ignore.
					case _ :: t => next(om, t)
				}
			}

			next(Map.empty[Symbol, OptionString], varargs.toList)
		}
	}
}
