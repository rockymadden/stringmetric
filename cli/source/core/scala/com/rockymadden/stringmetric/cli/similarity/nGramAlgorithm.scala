package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.NGramAlgorithm

/**
 * The nGramAlgorithm [[com.rockymadden.stringmetric.cli.Command]]. Returns the N-Gram representation of the passed string.
 */
object nGramAlgorithm extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMap(args)

		try {
			// Help.
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			// Execute.
			} else if (options.contains('dashless) && (options('dashless): OptionMapArray).length == 1
				&& options.contains('n) && (options('n): OptionMapInt).isDefined
			) {
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
			"Returns the N-Gram representation of the passed string." + ls + ls +
			"Syntax:" + ls +
			tab + "nGramAlgorithm [Options] string..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options." +
			tab + "--n" + ls +
			tab + tab + "The n."
		)
	}

	override def execute(options: OptionMap): Unit = {
		val n: OptionMapInt = options('n)

		println(
			NGramAlgorithm.compute(options('dashless))(n).map(_.mkString("|")).getOrElse("not computable")
		)
	}
}