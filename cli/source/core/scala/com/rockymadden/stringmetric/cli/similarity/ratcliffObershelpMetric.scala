package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.RatcliffObershelpMetric

/**
 * The ratcliffObershelpMetric [[com.rockymadden.stringmetric.cli.Command]]. Compares the similarity of two strings
 * using the Ratcliff / Obershelp similarity index.
 */
object ratcliffObershelpMetric extends Command {
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
			"Compares the similarity of two strings using the Ratcliff / Obershelp similarity index." + ls + ls +
			"Syntax:" + ls +
			tab + "ratcliffObershelpMetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings: OptionMapArray = options('dashless)

		println(RatcliffObershelpMetric.compare(strings(0), strings(1)).getOrElse("not comparable"))
	}
}
