package com.rockymadden.stringmetric.cli.tokenize

import com.rockymadden.stringmetric.cli._
import com.rockymadden.stringmetric.tokenize.NGramTokenizer

case object ngramtokenizer extends Command(
	(opts) =>
		"Returns the N-Gram representation of the passed string." + Ls + Ls +
		"Syntax:" + Ls +
		Tab + "ngramtokenizer [Options] string..." + Ls + Ls +
		"Options:" + Ls +
		Tab + "-h, --help" + Ls +
		Tab + Tab + "Outputs description, syntax, and opts." +
		Tab + "--n" + Ls +
		Tab + Tab + "The n.",
	(opts) => opts.contains('dashless) && (opts('dashless): Array[String]).length == 1 &&
		opts.contains('n) && (opts('n): Int) >= 1,
	(opts) => NGramTokenizer(opts('n)).tokenize(opts('dashless)) match {
		case Some(c) => {
			val sb = new StringBuilder

			Range(0, c.length).foreach { i =>
				sb.append(c(i))
				if (i < c.length - 1) sb.append("|")
			}

			sb.result()
		}
		case None => "not computable"
	}
)
