package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.phonetic.NysiisMetric

/**
 * The nysiismetric [[com.rockymadden.stringmetric.cli.Command]]. Compares two strings to determine if they are
 * phonetically similarly, per the NYSIIS algorithm.
 */
object nysiismetric extends Command {
	override def main(args: Array[String]): Unit = {
		val opts: OptionMap = args

		try
			if (opts.contains('h) || opts.contains('help)) {
				help()
				exit(opts)
			} else if (opts.contains('dashless) && (opts('dashless): Array[String]).length == 2) {
				execute(opts)
				exit(opts)
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		catch { case e: Throwable => error(e, opts) }
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares two strings to determine if they are phonetically similarly, per the NYSIIS algorithm." + ls + ls +
			"Syntax:" + ls +
			tab + "nysiismetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and opts."
		)
	}

	override def execute(opts: OptionMap): Unit = {
		val strings: Array[String] = opts('dashless)

		println(NysiisMetric.compare(strings(0), strings(1)).getOrElse("not comparable"))
	}
}
