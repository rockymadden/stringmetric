package com.rockymadden.stringmetric.cli

abstract class Command(
	protected val help: (OptionMap => String),
	protected val predicate: (OptionMap => Boolean),
	protected val execute: (OptionMap => String)
) {
	private def error(error: Throwable, opts: OptionMap): Unit =
		if (!isUnitTest(opts)) {
			println(error.getMessage)
			sys.exit(1)
		} else throw error

	private def exit(opts: OptionMap): Unit = if (!isUnitTest(opts)) sys.exit(0)

	private def isUnitTest(opts: OptionMap) =
		opts.contains('ut) || (opts.contains('unitTest) && opts.get('unitTest) != "false")

	final def main(args: Array[String]): Unit = {
		val opts: OptionMap = args

		try
			if (opts.contains('h) || opts.contains('help)) {
				println(help(opts))
				exit(opts)
			} else if (predicate(opts)) {
				println(execute(opts))
				exit(opts)
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		catch { case e: Throwable => error(e, opts) }
	}
}
