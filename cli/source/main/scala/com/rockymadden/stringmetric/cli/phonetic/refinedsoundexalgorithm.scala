package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.phonetic.RefinedSoundexAlgorithm

case object refinedsoundexalgorithm extends Command(
	(opts) =>
		"Returns the phonetic representation of the passed string, per the refined Soundex algorithm." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "refinedsoundexalgorithm [Options] string..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and opts.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 1,
	(opts) => RefinedSoundexAlgorithm.compute(opts('dashless)).getOrElse("not computable")
)
