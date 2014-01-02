package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.phonetic.RefinedNysiisAlgorithm

case object refinednysiisalgorithm extends Command(
	(opts) =>
		"Returns the phonetic representation of the passed string, per the refined NYSIIS algorithm." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "refinednysiisalgorithm [Options] string..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and opts.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 1,
	(opts) => RefinedNysiisAlgorithm.compute(opts('dashless)).getOrElse("not computable")
) { override def main(args: Array[String]): Unit = super.main(args) }
