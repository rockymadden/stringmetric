package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.LevenshteinMetric

/**
 * The levenshteinMetric [[com.rockymadden.stringmetric.cli.Command]]. Compares the number of characters that two strings
 * are different from one another via insertion, deletion, and substitution.
 */
object levenshteinMetric extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMap(args)

		try {
			// Help.
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			// Execute.
			} else if (options.contains('dashless) && (options('dashless): OptionMapArray).length == 2) {
				execute(options)
				exit(options)
			// Invalid syntax.
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		} catch {
			case e => error(e, options)
		}
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares the number of characters that two strings are different from one another via insertion, deletion, " +
			"and substitution." + ls + ls +
			"Syntax:" + ls +
			tab + "levenshteinMetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings: OptionMapArray = options('dashless)

		println(
			LevenshteinMetric.compare(
				strings(0),
				strings(1)
			).getOrElse("not comparable")
		)
	}
}