package org.hashtree.stringmetric.cli

import scala.annotation.tailrec
import scala.collection.immutable.HashMap

/** Utility standalone for OptionMap based operations. */
object OptionMapUtility {
	def toOptionMap(arguments: Array[String]): OptionMap = toOptionMap(arguments.toList)

	def toOptionMap(arguments: List[String]): OptionMap = next(HashMap.empty[Symbol, String], arguments)

	@tailrec
	private[this] def next(optionMap: OptionMap, arguments: List[String]): OptionMap = {
		val double = """^(--[a-zA-Z0-9]+)(\=[a-zA-Z0-9\.\-\_]+)?""".r
		val single = """^(-[a-zA-Z0-9]+)(\=[a-zA-Z0-9\.\-\_]+)?""".r
		val less = """([a-zA-Z0-9\/\-\_\$\.]+)""".r

		arguments match {
			// Empty List, return OptionMap.
			case Nil => optionMap
			// Double dash options, without value.
			case double(name, null) :: tail =>
				next(optionMap + (Symbol(name.tail.tail) -> ""), tail)
			// Double dash options, with value.
			case double(name, value) :: tail =>
				next(optionMap + (Symbol(name.tail.tail) -> value.tail), tail)
			// Single dash options, without value.
			case single(name, null) :: tail =>
				next(optionMap + (Symbol(name.tail) -> ""), tail)
			// Single dash options, with value. Value is discarded.
			case single(name, value) :: tail =>
				next(optionMap + (Symbol(name.tail) -> ""), tail)
			// Dashless options.
			case less(value) :: tail if value.head != '-' => {
				if (optionMap.contains('dashless)) {
					val dashless = optionMap('dashless) + " " + value.trim

					next((optionMap - 'dashless) + ('dashless -> dashless), tail)
				} else
					next(optionMap + ('dashless -> value.trim), tail)
			}
			// Invalid option, ignore.
			case _ :: tail => next(optionMap, tail)
		}
	}
}