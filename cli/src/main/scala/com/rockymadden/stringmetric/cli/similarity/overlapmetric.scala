package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.OverlapMetric

case object overlapmetric extends Command(
	(opts) =>
		"Compares the similarity of two strings using the overlap coefficient." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "overlapmetric [Options] string1 string2..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and opts." +
		Tab + "--n" + Ls +
		Tab + Tab + "The n-gram size.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 2 &&
		opts.contains('n) && (opts('n): Int) >= 1,
	(opts) => {
		val strings: Array[String] = opts('dashless)
		val n: Int = opts('n)

		OverlapMetric(n).compare(strings(0), strings(1))
			.map(_.toString)
			.getOrElse("not comparable")
	}
)
