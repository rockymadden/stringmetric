package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.NGramMetric

/**
 * The ngrammetric [[com.rockymadden.stringmetric.cli.Command]]. Compares the similarity of two strings using an N-Gram
 * similarity index.
 */
object ngrammetric extends Command {
	override def main(args: Array[String]): Unit = {
		val options: OptionMap = args

		try
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			} else if (options.contains('dashless) && (options('dashless): Array[String]).length == 2
				&& options.contains('n) && (options('n): Int) >= 1) {

				execute(options)
				exit(options)
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		catch { case e: Throwable => error(e, options) }
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Compares the similarity of two strings using an N-Gram similarity index." + ls + ls +
			"Syntax:" + ls +
			tab + "ngrammetric [Options] string1 string2..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options." +
			tab + "--n" + ls +
			tab + tab + "The n."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val strings: Array[String] = options('dashless)
		val n: Int = options('n)

		println(NGramMetric(n).compare(strings(0), strings(1)).getOrElse("not comparable"))
	}
}
