package com.rockymadden.stringmetric.cli.tokenize

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.tokenize.NGramTokenizer

/**
 * The ngramtokenizer [[com.rockymadden.stringmetric.cli.Command]]. Returns the N-Gram representation of the passed
 * string.
 */
object ngramtokenizer extends Command {
	override def main(args: Array[String]): Unit = {
		val opts: OptionMap = args

		try
			if (opts.contains('h) || opts.contains('help)) {
				help()
				exit(opts)
			} else if (opts.contains('dashless) && (opts('dashless): Array[String]).length == 1
				&& opts.contains('n) && (opts('n): Int) >= 1) {

				execute(opts)
				exit(opts)
			} else throw new IllegalArgumentException("Expected valid syntax. See --help.")
		catch { case e: Throwable => error(e, opts) }
	}

	override def help(): Unit = {
		val ls = sys.props("line.separator")
		val tab = "  "

		println(
			"Returns the N-Gram representation of the passed string." + ls + ls +
			"Syntax:" + ls +
			tab + "ngramtokenizer [Options] string..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and opts." +
			tab + "--n" + ls +
			tab + tab + "The n."
		)
	}

	override def execute(opts: OptionMap): Unit =
		NGramTokenizer(opts('n)).tokenize(opts('dashless)) match {
			// Implicits are a pain here.
			case Some(c) => {
				val sb = new StringBuilder

				Range(0, c.length).foreach { i =>
					sb.append(c(i))
					if (i < c.length - 1) sb.append("|")
				}

				println(sb.result())
			}
			case None => println("not computable")
		}
}
