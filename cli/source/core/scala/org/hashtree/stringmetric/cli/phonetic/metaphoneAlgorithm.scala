package org.hashtree.stringmetric.cli.phonetic

import org.hashtree.stringmetric.StringFilterDelegate
import org.hashtree.stringmetric.cli._
import org.hashtree.stringmetric.phonetic.MetaphoneAlgorithm

/**
 * The metaphoneAlgorithm [[org.hashtree.stringmetric.cli.Command]]. Returns the phonetic representation of the
 * passed string, per the Metaphone algorithm.
 */
object metaphoneAlgorithm extends Command {
	override def main(args: Array[String]): Unit = {
		val options = OptionMapUtility.toOptionMap(args)

		try {
			// Help.
			if (options.contains('h) || options.contains('help)) {
				help()
				exit(options)
			// Execute.
			} else if (options.contains('dashless) && options('dashless).count(_ == ' ') == 0) {
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
			"Returns the phonetic representation of the passed string, per the Metaphone algorithm." + ls + ls +
			"Syntax:" + ls +
			tab + "metaphoneAlgorithm [Options] string..." + ls + ls +
			"Options:" + ls +
			tab + "-h, --help" + ls +
			tab + tab + "Outputs description, syntax, and options."
		)
	}

	override def execute(options: OptionMap): Unit =
		println(
			MetaphoneAlgorithm.compute(
				options('dashless)
			)(new StringFilterDelegate).getOrElse("not computable").toString
		)
}