package com.rockymadden.stringmetric.cli

/** Defines the traits and provides basic implementations of a command. Commands are always implemented as objects. */
trait Command {
	def help(): Unit

	final def error(error: Throwable, options: OptionMap): Unit =
		if (!isUnitTest(options)) {
			println(error.getMessage)
			sys.exit(1)
		} else throw error

	def execute(options: OptionMap): Unit

	final def exit(options: OptionMap): Unit =
		if (!isUnitTest(options)) sys.exit(0)

	final protected[this] def isDebug(options: OptionMap): Boolean =
		(options.contains('d) || (options.contains('debug) && options.get('debug) != "false"))

	final protected[this] def isUnitTest(options: OptionMap): Boolean =
		(options.contains('ut) || (options.contains('unitTest) && options.get('unitTest) != "false"))

	def main(args: Array[String]): Unit
}