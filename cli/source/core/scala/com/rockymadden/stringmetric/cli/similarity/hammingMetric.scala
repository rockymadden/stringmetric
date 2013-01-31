package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.HammingMetric

/**
 * The hammingMetric [[com.rockymadden.stringmetric.cli.Command]]. Compares the number of characters that two equal
 * length strings are different from one another.
 */
object hammingMetric extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMap(args)

		try
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			} else if (options.contains('dashless) && (options('dashless): OptionMapArray).length == 2) {
				execute(options)
				exit(options)
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		catch {
			case e: Throwable => error(e, options)
		}
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares the number of characters that two equal length strings are different from one another." + ls + ls +
			"Syntax:" + ls +
			tab + "hammingMetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings: OptionMapArray = options('dashless)

		println(HammingMetric.compare(strings(0), strings(1)).getOrElse("not comparable"))
	}
}
