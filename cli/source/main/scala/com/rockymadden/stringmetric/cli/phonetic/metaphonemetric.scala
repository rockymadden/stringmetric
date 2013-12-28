package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.phonetic.MetaphoneMetric

case object metaphonemetric extends Command(
	(opts) =>
		"Compares two strings to determine if they are phonetically similarly, per the Metaphone algorithm." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "metaphonemetric [Options] string1 string2..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and opts.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 2,
	(opts) => {
		val strings: Array[String] = opts('dashless)
		MetaphoneMetric.compare(strings(0), strings(1))
			.map(_.toString)
			.getOrElse("not comparable")
	}
)
