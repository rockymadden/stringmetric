package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.phonetic.RefinedSoundexMetric

/**
 * The refinedsoundexmetric [[com.rockymadden.stringmetric.cli.Command]]. Compares two strings to determine if they are
 * phonetically similarly, per the refined Soundex algorithm.
 */
object refinedsoundexmetric extends Command {
	override def main(args: Array[String]): Unit = {
		val options: OptionMap = args

		try
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			} else if (options.contains('dashless) && (options('dashless): Array[String]).length == 2) {
				execute(options)
				exit(options)
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		catch { case e: Throwable => error(e, options) }
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares two strings to determine if they are phonetically similarly, per the refined Soundex algorithm." + ls + ls +
			"Syntax:" + ls +
			tab + "refinedsoundexmetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings: Array[String] = options('dashless)

		println(RefinedSoundexMetric.compare(strings(0), strings(1)).getOrElse("not comparable"))
	}
}
