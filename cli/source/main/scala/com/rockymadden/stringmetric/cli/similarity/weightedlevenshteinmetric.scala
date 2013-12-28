package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric
import scala.math.BigDecimal

/**
 * The weightedlevenshteinmetric [[com.rockymadden.stringmetric.cli.Command]]. Compares the number of characters that
 * two strings are different from one another via insertion, deletion, and substitution. Allows the invoker to indicate
 * the weight each operation takes.
 */
object weightedlevenshteinmetric extends Command {
	override def main(args: Array[String]): Unit = {
		val opts: OptionMap = args

		try
			if (opts.contains('h) || opts.contains('help)) {
				help()
				exit(opts)
			} else if (opts.contains('dashless) && (opts('dashless): Array[String]).length == 2
				&& opts.contains('deleteWeight) && (opts('deleteWeight): Double) >= 0
				&& opts.contains('insertWeight) && (opts('insertWeight): Double) >= 0
				&& opts.contains('substituteWeight) && (opts('substituteWeight): Double) >= 0) {

				execute(opts)
				exit(opts)
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		catch { case e: Throwable => error(e, opts) }
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares the number of characters that two strings are different from one another via insertion, deletion, " +
			"and substitution. Allows the invoker to indicate the weight each operation takes." + ls + ls +
			"Syntax:" + ls +
			tab + "weightedlevenshteinmetric [Options] --deleteWeight=[double] --insertWeight=[double] --substituteWeight=[double] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "--deleteWeight" + ls +
			tab + tab + "The weight given to delete operations." +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and opts." +
			tab + "--insertWeight" + ls +
			tab + tab + "The weight given to insert operations." +
			tab + "--substituteWeight" + ls +
			tab + tab + "The weight given to substitute operations."
		)
	}

	override def execute(opts: OptionMap): Unit = {
		val strings: Array[String] = opts('dashless)

		println(WeightedLevenshteinMetric(
			opts('deleteWeight), opts('insertWeight), opts('substituteWeight)
		).compare(strings(0), strings(1)).getOrElse("not comparable"))
	}
}
