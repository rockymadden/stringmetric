package org.hashtree.stringmetric.cli.command

import org.hashtree.stringmetric.{ CaseStringCleaner, JaroWinklerMetric, StringCleanerDelegate }
import org.hashtree.stringmetric.cli._
import org.hashtree.stringmetric.cli.command._

/**
 * The jaroWinklerMetric [[org.hashtree.stringmetric.cli.command.Command]]. Compares two strings to calculate the
 * Jaro-Winkler distance.
 */
object jaroWinklerMetric extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMapUtility.toOptionMap(args)

		try {
			// Help.
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			// Execute.
			} else if (options.contains('dashless) && options('dashless).count(_ == ' ') == 1) {
				execute(options)
				exit(options)
			// Invalid syntax.
			} else {
				throw new IllegalArgumentException("Expected valid syntax. See --help.")
			}
		} catch {
			case e => error(e)(options)
		}
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares two strings to calculate the Jaro-Winkler distance." + ls + ls +
			"Syntax:" + ls +
			tab + "jaroWinklerMetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings = options('dashless).split(" ")

		println(JaroWinklerMetric.compare(strings(0), strings(1))(new StringCleanerDelegate with CaseStringCleaner).toString)
	}
}