package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.JaroMetric

case object jarometric extends Command(
	(opts) =>
		"Compares two strings to calculate the Jaro distance." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "jarometric [Options] string1 string2..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and options.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 2,
	(opts) => {
		val strings: Array[String] = opts('dashless)

		JaroMetric.compare(strings(0), strings(1))
			.map(_.toString)
			.getOrElse("not comparable")
	}
)
