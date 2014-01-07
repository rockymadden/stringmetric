package com.rockymadden.stringmetric


// Some things might look sloppy (e.g. access modifiers, broad imports, repetitive imports, etc), but are required
// because of the way "scalascript" is ultimately compiled.
package object cli {
	import scala.collection.immutable.Map
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


	val Ls = sys.props("line.separator")
	val Tab = "  "


	class OptionString(val get: String)


	object OptionString {
		implicit def fromString(s: String): OptionString = OptionString(s)

		def apply(s: String): OptionString = new OptionString(s)
	}


	type OptionMap = Map[Symbol, OptionString]


	object OptionMap {
		def apply(as: Array[String]): OptionMap = apply(as: _*)

		def apply(as: String*): OptionMap = {
			@annotation.tailrec
			def loop(om: OptionMap, a: List[String]): OptionMap = {
				val double = """^(--[a-zA-Z0-9]+)(=[a-zA-Z0-9\.\-_]+)?""".r
				val single = """^(-[a-zA-Z0-9]+)(=[a-zA-Z0-9\.\-_]+)?""".r
				val less = """([a-zA-Z0-9/\-_\$\.]+)""".r

				a match {
					// Empty, return.
					case Nil => om
					// Double dash options without value.
					case double(k, null) :: t => loop(om + (Symbol(k.tail.tail) -> ""), t)
					// Double dash options with value.
					case double(k, v) :: t => loop(om + (Symbol(k.tail.tail) -> v.tail), t)
					// Single dash options without value.
					case single(k, null) :: t => loop(om + (Symbol(k.tail) -> ""), t)
					// Single dash options with value. Value is discarded.
					case single(k, v) :: t => loop(om + (Symbol(k.tail) -> ""), t)
					// Dashless options.
					case less(v) :: t if v.head != '-' =>
						if (om.contains('dashless))
							loop((om - 'dashless) + ('dashless -> (om('dashless).get + " " + v.trim)), t)
						else loop(om + ('dashless -> v.trim), t)
					// Invalid option, ignore.
					case _ :: t => loop(om, t)
				}
			}

			loop(Map.empty[Symbol, OptionString], as.toList)
		}
	}


	abstract class Command(
		protected val help: (OptionMap => String),
		protected val predicate: (OptionMap => Boolean),
		protected val execute: (OptionMap => String)
	) {
		def main(as: Array[String]): Unit = {
			val opts = OptionMap(as)

			try
				if (opts.contains('h) || opts.contains('help)) {
					println(help(opts))
					exit(opts)
				} else if (predicate(opts)) {
					println(execute(opts))
					exit(opts)
				} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
			catch {
				case e: Throwable => error(e, opts)
			}
		}

		private def error(e: Throwable, opts: OptionMap): Unit =
			if (isUnitTest(opts)) throw e
			else {
				println(e.getMessage)
				sys.exit(1)
			}

		private def exit(opts: OptionMap): Unit = if (!isUnitTest(opts)) sys.exit(0)

		private def isUnitTest(opts: OptionMap) =
			opts.contains('ut) || ((opts.contains('unitTest) && opts.get('unitTest) != "false"))
	}
}
