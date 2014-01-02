package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.WeightedLevenshteinMetric

case object weightedlevenshteinmetric extends Command(
	(opts) =>
		"Compares the number of characters that two strings are different from one another via insertion, deletion, " +
		"and substitution. Allows the invoker to indicate the weight each operation takes." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "weightedlevenshteinmetric [Options] --deleteWeight=[double] --insertWeight=[double] --substituteWeight=[double] string1 string2..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "--deleteWeight" + Ls +
		Tab + Tab + "The weight given to delete operations." +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and opts." +
		Tab + "--insertWeight" + Ls +
		Tab + Tab + "The weight given to insert operations." +
		Tab + "--substituteWeight" + Ls +
		Tab + Tab + "The weight given to substitute operations.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 2 &&
		opts.contains('deleteWeight) && (opts('deleteWeight): Double) >= 0 &&
		opts.contains('insertWeight) && (opts('insertWeight): Double) >= 0 &&
		opts.contains('substituteWeight) && (opts('substituteWeight): Double) >= 0,
	(opts) => {
		val strings: Array[String] = opts('dashless)

		WeightedLevenshteinMetric(opts('deleteWeight), opts('insertWeight), opts('substituteWeight))
			.compare(strings(0), strings(1))
			.map(_.toString)
			.getOrElse("not comparable")
	}
)
