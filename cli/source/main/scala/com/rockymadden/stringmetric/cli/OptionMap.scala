package com.rockymadden.stringmetric.cli

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
						next((om - 'dashless) + ('dashless -> (om('dashless).self + " " + v.trim)), t)
					else next(om + ('dashless -> v.trim), t)
				// Invalid option, ignore.
				case _ :: t => next(om, t)
			}
		}

		next(Map.empty[Symbol, OptionString], varargs.toList)
	}
}
