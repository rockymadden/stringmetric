package com.rockymadden.stringmetric.cli.phonetic

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.phonetic.NysiisAlgorithm

case object nysiisalgorithm extends Command(
	(opts) =>
		"Returns the phonetic representation of the passed string, per the NYSIIS algorithm." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "nysiisalgorithm [Options] string..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and options.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 1,
	(opts) => NysiisAlgorithm.compute(opts('dashless)).getOrElse("not computable")
) { override def main(args: Array[String]): Unit = super.main(args) }
