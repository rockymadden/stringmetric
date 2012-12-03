package org.hashtree.stringmetric.cli.phonetic

import org.hashtree.stringmetric.cli._
import org.hashtree.stringmetric.phonetic.NysiisMetric

/**
 * The nysiisMetric [[org.hashtree.stringmetric.cli.Command]]. Compares two strings to determine if they are
 * phonetically similarly, per the NYSIIS algorithm.
 */
object nysiisMetric extends Command {
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
			"Compares two strings to determine if they are phonetically similarly, per the NYSIIS algorithm." + ls + ls +
			"Syntax:" + ls +
			tab + "nysiisMetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings: OptionMapArray = options('dashless)

		println(
			NysiisMetric.compare(
				strings(0),
				strings(1)
			).getOrElse("not comparable")
		)
	}
}