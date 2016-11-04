package com.rockymadden.stringmetric.phonetic

object RefinedNysiisAlgorithmSpec extends org.specs2.mutable.Specification {
	"RefinedNysiisAlgorithm compute()" should {
		"return None with empty argument" in {
			RefinedNysiisAlgorithm.compute("").isDefined must beFalse
		}
		"return None with non-phonetic argument" in {
			RefinedNysiisAlgorithm.compute("123").isDefined must beFalse
		}
		"return Some with phonetic argument" in {
			// a
			RefinedNysiisAlgorithm.compute("a").get must beEqualTo("a")
			RefinedNysiisAlgorithm.compute("aa").get must beEqualTo("a")

			// b
			RefinedNysiisAlgorithm.compute("b").get must beEqualTo("b")
			RefinedNysiisAlgorithm.compute("bb").get must beEqualTo("b")

			// c
			RefinedNysiisAlgorithm.compute("c").get must beEqualTo("c")
			RefinedNysiisAlgorithm.compute("cc").get must beEqualTo("c")

			// d
			RefinedNysiisAlgorithm.compute("d").get must beEqualTo("d")
			RefinedNysiisAlgorithm.compute("dd").get must beEqualTo("d")

			// e
			RefinedNysiisAlgorithm.compute("e").get must beEqualTo("e")
			RefinedNysiisAlgorithm.compute("ee").get must beEqualTo("y")

			// f
			RefinedNysiisAlgorithm.compute("f").get must beEqualTo("f")
			RefinedNysiisAlgorithm.compute("ff").get must beEqualTo("f")

			// g
			RefinedNysiisAlgorithm.compute("g").get must beEqualTo("g")
			RefinedNysiisAlgorithm.compute("gg").get must beEqualTo("g")

			// h
			RefinedNysiisAlgorithm.compute("h").get must beEqualTo("h")
			RefinedNysiisAlgorithm.compute("hh").get must beEqualTo("h")

			// i
			RefinedNysiisAlgorithm.compute("i").get must beEqualTo("i")
			RefinedNysiisAlgorithm.compute("ii").get must beEqualTo("i")

			// j
			RefinedNysiisAlgorithm.compute("j").get must beEqualTo("j")
			RefinedNysiisAlgorithm.compute("jj").get must beEqualTo("j")

			// k
			RefinedNysiisAlgorithm.compute("k").get must beEqualTo("c")
			RefinedNysiisAlgorithm.compute("kk").get must beEqualTo("c")

			// l
			RefinedNysiisAlgorithm.compute("l").get must beEqualTo("l")
			RefinedNysiisAlgorithm.compute("ll").get must beEqualTo("l")

			// m
			RefinedNysiisAlgorithm.compute("m").get must beEqualTo("m")
			RefinedNysiisAlgorithm.compute("mm").get must beEqualTo("mn")

			// n
			RefinedNysiisAlgorithm.compute("n").get must beEqualTo("n")
			RefinedNysiisAlgorithm.compute("nn").get must beEqualTo("n")

			// o
			RefinedNysiisAlgorithm.compute("o").get must beEqualTo("o")
			RefinedNysiisAlgorithm.compute("oo").get must beEqualTo("o")

			// p
			RefinedNysiisAlgorithm.compute("p").get must beEqualTo("p")
			RefinedNysiisAlgorithm.compute("pp").get must beEqualTo("p")

			// q
			RefinedNysiisAlgorithm.compute("q").get must beEqualTo("q")
			RefinedNysiisAlgorithm.compute("qq").get must beEqualTo("qg")

			// r
			RefinedNysiisAlgorithm.compute("r").get must beEqualTo("r")
			RefinedNysiisAlgorithm.compute("rr").get must beEqualTo("r")

			// s
			RefinedNysiisAlgorithm.compute("s").get must beEqualTo("s")
			RefinedNysiisAlgorithm.compute("ss").get must beEqualTo("s")

			// t
			RefinedNysiisAlgorithm.compute("t").get must beEqualTo("t")
			RefinedNysiisAlgorithm.compute("tt").get must beEqualTo("t")

			// u
			RefinedNysiisAlgorithm.compute("u").get must beEqualTo("u")
			RefinedNysiisAlgorithm.compute("uu").get must beEqualTo("u")

			// v
			RefinedNysiisAlgorithm.compute("v").get must beEqualTo("v")
			RefinedNysiisAlgorithm.compute("vv").get must beEqualTo("v")

			// w
			RefinedNysiisAlgorithm.compute("w").get must beEqualTo("w")
			RefinedNysiisAlgorithm.compute("ww").get must beEqualTo("w")

			// x
			RefinedNysiisAlgorithm.compute("x").get must beEqualTo("x")
			RefinedNysiisAlgorithm.compute("xx").get must beEqualTo("x")

			// y
			RefinedNysiisAlgorithm.compute("y").get must beEqualTo("y")
			RefinedNysiisAlgorithm.compute("yy").get must beEqualTo("y")
			RefinedNysiisAlgorithm.compute("ybyb").get must beEqualTo("ybab")

			// z
			RefinedNysiisAlgorithm.compute("z").get must beEqualTo("z")
			RefinedNysiisAlgorithm.compute("zz").get must beEqualTo("z")

			// Head cases.
			RefinedNysiisAlgorithm.compute("mac").get must beEqualTo("mc")
			RefinedNysiisAlgorithm.compute("pf").get must beEqualTo("f")

			// Last cases.
			RefinedNysiisAlgorithm.compute("ix").get must beEqualTo("ic")
			RefinedNysiisAlgorithm.compute("ex").get must beEqualTo("ec")
			RefinedNysiisAlgorithm.compute("ye").get must beEqualTo("y")
			RefinedNysiisAlgorithm.compute("ee").get must beEqualTo("y")
			RefinedNysiisAlgorithm.compute("ie").get must beEqualTo("y")
			RefinedNysiisAlgorithm.compute("dt").get must beEqualTo("d")
			RefinedNysiisAlgorithm.compute("rt").get must beEqualTo("d")
			RefinedNysiisAlgorithm.compute("rd").get must beEqualTo("d")
			RefinedNysiisAlgorithm.compute("nt").get must beEqualTo("d")
			RefinedNysiisAlgorithm.compute("nd").get must beEqualTo("d")

			// Core cases.
			RefinedNysiisAlgorithm.compute("bevb").get must beEqualTo("bafb")
			RefinedNysiisAlgorithm.compute("bghtb").get must beEqualTo("bgtb")
			RefinedNysiisAlgorithm.compute("bdgb").get must beEqualTo("bgb")
			RefinedNysiisAlgorithm.compute("bphb").get must beEqualTo("bfb")
			RefinedNysiisAlgorithm.compute("bknb").get must beEqualTo("bnb")
			RefinedNysiisAlgorithm.compute("bshb").get must beEqualTo("bsb")
			RefinedNysiisAlgorithm.compute("bschb").get must beEqualTo("bsb")
			RefinedNysiisAlgorithm.compute("bywb").get must beEqualTo("bab")
			RefinedNysiisAlgorithm.compute("byw").get must beEqualTo("by")
			RefinedNysiisAlgorithm.compute("ywb").get must beEqualTo("yb")
			RefinedNysiisAlgorithm.compute("bwrb").get must beEqualTo("brb")

			// Transcode cases.
			RefinedNysiisAlgorithm.compute("bay").get must beEqualTo("by")

			// Miscellaneous.
			RefinedNysiisAlgorithm.compute("macdonald").get must beEqualTo("mcdanald")
			RefinedNysiisAlgorithm.compute("phone").get must beEqualTo("fan")
			RefinedNysiisAlgorithm.compute("aggregate").get must beEqualTo("agragat")
			RefinedNysiisAlgorithm.compute("accuracy").get must beEqualTo("acaracy")
			RefinedNysiisAlgorithm.compute("encyclopedia").get must beEqualTo("encaclapad")
			RefinedNysiisAlgorithm.compute("honorificabilitudinitatibus").get must beEqualTo("hanarafacabalatadanatatab")
			RefinedNysiisAlgorithm.compute("antidisestablishmentarianism").get must beEqualTo("antadasastablasnantaranasn")

			// Dropby.
			RefinedNysiisAlgorithm.compute("edwards").get must beEqualTo("edwad")
			RefinedNysiisAlgorithm.compute("parez").get must beEqualTo("par")
			RefinedNysiisAlgorithm.compute("macintosh").get must beEqualTo("mcantas")
			RefinedNysiisAlgorithm.compute("phillipson").get must beEqualTo("falapsan")
			RefinedNysiisAlgorithm.compute("haddix").get must beEqualTo("hadac")
			RefinedNysiisAlgorithm.compute("essex").get must beEqualTo("esac")
			RefinedNysiisAlgorithm.compute("moye").get must beEqualTo("my")
			RefinedNysiisAlgorithm.compute("mckee").get must beEqualTo("mcy")
			RefinedNysiisAlgorithm.compute("mackie").get must beEqualTo("mcy")
			RefinedNysiisAlgorithm.compute("heitschmidt").get must beEqualTo("hatsnad")
			RefinedNysiisAlgorithm.compute("bart").get must beEqualTo("bad")
			RefinedNysiisAlgorithm.compute("hurd").get must beEqualTo("had")
			RefinedNysiisAlgorithm.compute("hunt").get must beEqualTo("had")
			RefinedNysiisAlgorithm.compute("westerlund").get must beEqualTo("wastarlad")
			RefinedNysiisAlgorithm.compute("evers").get must beEqualTo("evar")
			RefinedNysiisAlgorithm.compute("devito").get must beEqualTo("dafat")
			RefinedNysiisAlgorithm.compute("rawson").get must beEqualTo("rasan")
			RefinedNysiisAlgorithm.compute("shoulders").get must beEqualTo("saldar")
			RefinedNysiisAlgorithm.compute("leighton").get must beEqualTo("lagtan")
			RefinedNysiisAlgorithm.compute("wooldridge").get must beEqualTo("waldrag")
			RefinedNysiisAlgorithm.compute("oliphant").get must beEqualTo("olafad")
			RefinedNysiisAlgorithm.compute("hatchett").get must beEqualTo("hatcat")
			RefinedNysiisAlgorithm.compute("mcknight").get must beEqualTo("mcnagt")
			RefinedNysiisAlgorithm.compute("rickert").get must beEqualTo("racad")
			RefinedNysiisAlgorithm.compute("bowman").get must beEqualTo("banan")
			RefinedNysiisAlgorithm.compute("vasquez").get must beEqualTo("vasg")
			RefinedNysiisAlgorithm.compute("bashaw").get must beEqualTo("bas")
			RefinedNysiisAlgorithm.compute("schoenhoeft").get must beEqualTo("sanaft") // dropby wrongly says scanaft
			RefinedNysiisAlgorithm.compute("heywood").get must beEqualTo("had")
			RefinedNysiisAlgorithm.compute("hayman").get must beEqualTo("hanan")
			RefinedNysiisAlgorithm.compute("seawright").get must beEqualTo("saragt")
			RefinedNysiisAlgorithm.compute("kratzer").get must beEqualTo("cratsar")
			RefinedNysiisAlgorithm.compute("canaday").get must beEqualTo("canady")
			RefinedNysiisAlgorithm.compute("crepeau").get must beEqualTo("crap")
		}
	}
}
