package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.DiceSorensenMetric

/**
 * The diceSorensenMetric [[com.rockymadden.stringmetric.cli.Command]]. Compares the similarity of two strings using the
 * Dice / Sorensen coefficient.
 */
object diceSorensenMetric extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMap(args)

		try
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			} else if (options.contains('dashless) && (options('dashless): OptionMapArray).length == 2
				&& options.contains('n) && (options('n): OptionMapInt) >= 1) {

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
			"Compares the similarity of two strings using the Dice / Sorensen coefficient." + ls + ls +
			"Syntax:" + ls +
			tab + "diceSorensenMetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options." +
			tab + "--n" + ls +
			tab + tab + "The n-gram size, traditionally 2."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings: OptionMapArray = options('dashless)
		val n: OptionMapInt = options('n)

		println(DiceSorensenMetric.compare(strings(0), strings(1))(n).getOrElse("not comparable"))
	}
}
