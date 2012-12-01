package org.hashtree.stringmetric.cli.phonetic

import org.hashtree.stringmetric.cli._
import org.hashtree.stringmetric.phonetic.SoundexMetric

/**
 * The soundexMetric [[org.hashtree.stringmetric.cli.Command]]. Compares two strings to determine if they are
 * phonetically similarly, per the Soundex algorithm.
 */
object soundexMetric extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMap(args)

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
			case e => error(e, options)
		}
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares two strings to determine if they are phonetically similarly, per the Soundex algorithm." + ls + ls +
			"Syntax:" + ls +
			tab + "soundexMetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings = options('dashless).split(" ")

		println(
			SoundexMetric.compare(
				strings(0),
				strings(1)
			).getOrElse("not comparable")
		)
	}
}