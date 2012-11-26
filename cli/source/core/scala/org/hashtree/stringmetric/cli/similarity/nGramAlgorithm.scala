package org.hashtree.stringmetric.cli.similarity

import org.hashtree.stringmetric.cli._
import org.hashtree.stringmetric.similarity.NGramAlgorithm

/**
 * The nGramAlgorithm [[org.hashtree.stringmetric.cli.Command]]. Returns the N-Gram representation of the passed string.
 */
object nGramAlgorithm extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMapUtility.toOptionMap(args)

		try {
			// Help.
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			// Execute.
			} else if (options.contains('dashless) && options('dashless).count(_ == ' ') == 0 &&
				options.contains('n) && ParseUtility.parseInt(options('n)).isDefined
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
		val n = ParseUtility.parseInt(options('n)).get

		println(
			NGramAlgorithm.compute(options('dashless))(n).map(_.mkString("|")).getOrElse("not computable")
		)
	}
}