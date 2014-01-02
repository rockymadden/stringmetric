package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.phonetic.SoundexMetric

case object soundexmetric extends Command(
	(opts) =>
		"Compares two strings to determine if they are phonetically similarly, per the Soundex algorithm." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "soundexmetric [Options] string1 string2..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and options.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 2,
	(opts) => {
		val strings: Array[String] = opts('dashless)
		SoundexMetric.compare(strings(0), strings(1))
			.map(_.toString)
			.getOrElse("not comparable")
	}
)
