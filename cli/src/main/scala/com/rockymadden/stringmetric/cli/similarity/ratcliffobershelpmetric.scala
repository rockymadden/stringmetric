package com.rockymadden.stringmetric.cli.similarity

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.similarity.RatcliffObershelpMetric

case object ratcliffobershelpmetric extends Command(
	(opts) =>
		"Compares the similarity of two strings using the Ratcliff / Obershelp similarity index." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "ratcliffobershelpmetric [Options] string1 string2..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and opts.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 2,
	(opts) => {
		val strings: Array[String] = opts('dashless)

		RatcliffObershelpMetric.compare(strings(0), strings(1))
			.map(_.toString)
			.getOrElse("not comparable")
	}
)
