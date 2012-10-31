package org.hashtree.stringmetric.cli.similarity

import org.hashtree.stringmetric.{ AsciiLetterCaseStringFilter, StringFilterDelegate }
import org.hashtree.stringmetric.cli._
import org.hashtree.stringmetric.similarity.HammingMetric

/**
 * The hammingMetric [[org.hashtree.stringmetric.cli.Command]]. Compares the number of characters that two equal
 * length strings are different from one another.
 */
object hammingMetric extends Command {
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
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		} catch {
			case e => error(e)(options)
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
		val strings = options('dashless).split(" ")

		println(
			HammingMetric.compare(
				strings(0),
				strings(1)
			)(new StringFilterDelegate with AsciiLetterCaseStringFilter).getOrElse("not comparable").toString
		)
	}
}