package com.rockymadden.stringmetric.phonetic

object NysiisAlgorithmSpec extends org.specs2.mutable.Specification {
	"NysiisAlgorithm compute()" should {
		"return None with empty argument" in {
			NysiisAlgorithm.compute("").isDefined must beFalse
		}
		"return None with non-phonetic argument" in {
			NysiisAlgorithm.compute("123").isDefined must beFalse
		}
		"return Some with phonetic argument" in {
			// a
			NysiisAlgorithm.compute("a").get must beEqualTo("a")
			NysiisAlgorithm.compute("aa").get must beEqualTo("a")

			// b
			NysiisAlgorithm.compute("b").get must beEqualTo("b")
			NysiisAlgorithm.compute("bb").get must beEqualTo("bb")

			// c
			NysiisAlgorithm.compute("c").get must beEqualTo("c")
			NysiisAlgorithm.compute("cc").get must beEqualTo("cc")

			// d
			NysiisAlgorithm.compute("d").get must beEqualTo("d")
			NysiisAlgorithm.compute("dd").get must beEqualTo("dd")

			// e
			NysiisAlgorithm.compute("e").get must beEqualTo("e")
			NysiisAlgorithm.compute("ee").get must beEqualTo("y")

			// f
			NysiisAlgorithm.compute("f").get must beEqualTo("f")
			NysiisAlgorithm.compute("ff").get must beEqualTo("ff")

			// g
			NysiisAlgorithm.compute("g").get must beEqualTo("g")
			NysiisAlgorithm.compute("gg").get must beEqualTo("gg")

			// h
			NysiisAlgorithm.compute("h").get must beEqualTo("h")
			NysiisAlgorithm.compute("hh").get must beEqualTo("hh")

			// i
			NysiisAlgorithm.compute("i").get must beEqualTo("i")
			NysiisAlgorithm.compute("ii").get must beEqualTo("i")

			// j
			NysiisAlgorithm.compute("j").get must beEqualTo("j")
			NysiisAlgorithm.compute("jj").get must beEqualTo("jj")

			// k
			NysiisAlgorithm.compute("k").get must beEqualTo("c")
			NysiisAlgorithm.compute("kk").get must beEqualTo("cc")

			// l
			NysiisAlgorithm.compute("l").get must beEqualTo("l")
			NysiisAlgorithm.compute("ll").get must beEqualTo("ll")

			// m
			NysiisAlgorithm.compute("m").get must beEqualTo("m")
			NysiisAlgorithm.compute("mm").get must beEqualTo("mn")

			// n
			NysiisAlgorithm.compute("n").get must beEqualTo("n")
			NysiisAlgorithm.compute("nn").get must beEqualTo("nn")

			// o
			NysiisAlgorithm.compute("o").get must beEqualTo("o")
			NysiisAlgorithm.compute("oo").get must beEqualTo("o")

			// p
			NysiisAlgorithm.compute("p").get must beEqualTo("p")
			NysiisAlgorithm.compute("pp").get must beEqualTo("pp")

			// q
			NysiisAlgorithm.compute("q").get must beEqualTo("q")
			NysiisAlgorithm.compute("qq").get must beEqualTo("qg")

			// r
			NysiisAlgorithm.compute("r").get must beEqualTo("r")
			NysiisAlgorithm.compute("rr").get must beEqualTo("rr")

			// s
			NysiisAlgorithm.compute("s").get must beEqualTo("s")
			NysiisAlgorithm.compute("ss").get must beEqualTo("s")

			// t
			NysiisAlgorithm.compute("t").get must beEqualTo("t")
			NysiisAlgorithm.compute("tt").get must beEqualTo("tt")

			// u
			NysiisAlgorithm.compute("u").get must beEqualTo("u")
			NysiisAlgorithm.compute("uu").get must beEqualTo("u")

			// v
			NysiisAlgorithm.compute("v").get must beEqualTo("v")
			NysiisAlgorithm.compute("vv").get must beEqualTo("vv")

			// w
			NysiisAlgorithm.compute("w").get must beEqualTo("w")
			NysiisAlgorithm.compute("ww").get must beEqualTo("ww")

			// x
			NysiisAlgorithm.compute("x").get must beEqualTo("x")
			NysiisAlgorithm.compute("xx").get must beEqualTo("xx")

			// y
			NysiisAlgorithm.compute("y").get must beEqualTo("y")
			NysiisAlgorithm.compute("yy").get must beEqualTo("yy")

			// z
			NysiisAlgorithm.compute("z").get must beEqualTo("z")
			NysiisAlgorithm.compute("zz").get must beEqualTo("z")

			// Head cases.
			NysiisAlgorithm.compute("mac").get must beEqualTo("mc")
			NysiisAlgorithm.compute("kn").get must beEqualTo("nn")
			NysiisAlgorithm.compute("k").get must beEqualTo("c")
			NysiisAlgorithm.compute("ph").get must beEqualTo("ff")
			NysiisAlgorithm.compute("pf").get must beEqualTo("ff")
			NysiisAlgorithm.compute("sch").get must beEqualTo("s") // dropby wrongly says ss

			// Last cases.
			NysiisAlgorithm.compute("ee").get must beEqualTo("y")
			NysiisAlgorithm.compute("ie").get must beEqualTo("y")
			NysiisAlgorithm.compute("dt").get must beEqualTo("d")
			NysiisAlgorithm.compute("rt").get must beEqualTo("d")
			NysiisAlgorithm.compute("rd").get must beEqualTo("d")
			NysiisAlgorithm.compute("nt").get must beEqualTo("d")
			NysiisAlgorithm.compute("nd").get must beEqualTo("d")

			// Core cases.
			NysiisAlgorithm.compute("eev").get must beEqualTo("eaf")
			NysiisAlgorithm.compute("zev").get must beEqualTo("zaf")
			NysiisAlgorithm.compute("kkn").get must beEqualTo("cn")
			NysiisAlgorithm.compute("sschn").get must beEqualTo("ssn")
			NysiisAlgorithm.compute("pph").get must beEqualTo("pf")

			// Miscellaneous.
			NysiisAlgorithm.compute("macdonald").get must beEqualTo("mcdanald")
			NysiisAlgorithm.compute("phone").get must beEqualTo("ffan")
			NysiisAlgorithm.compute("aggregate").get must beEqualTo("agragat")
			NysiisAlgorithm.compute("accuracy").get must beEqualTo("acaracy")
			NysiisAlgorithm.compute("encyclopedia").get must beEqualTo("encyclapad")
			NysiisAlgorithm.compute("honorificabilitudinitatibus").get must beEqualTo("hanarafacabalatadanatatab")
			NysiisAlgorithm.compute("antidisestablishmentarianism").get must beEqualTo("antadasastablasnantaranasn")

			// Dropby.
			NysiisAlgorithm.compute("macintosh").get must beEqualTo("mcant")
			NysiisAlgorithm.compute("knuth").get must beEqualTo("nnat")
			NysiisAlgorithm.compute("koehn").get must beEqualTo("can") // dropby wrongly says c
			NysiisAlgorithm.compute("phillipson").get must beEqualTo("ffalapsan")
			NysiisAlgorithm.compute("pfeister").get must beEqualTo("ffastar")
			NysiisAlgorithm.compute("schoenhoeft").get must beEqualTo("ssanaft")
			NysiisAlgorithm.compute("mckee").get must beEqualTo("mcy")
			NysiisAlgorithm.compute("heitschmedt").get must beEqualTo("hatsnad")
			NysiisAlgorithm.compute("bart").get must beEqualTo("bad")
			NysiisAlgorithm.compute("hurd").get must beEqualTo("had")
			NysiisAlgorithm.compute("hunt").get must beEqualTo("had")
			NysiisAlgorithm.compute("westerlund").get must beEqualTo("wastarlad")
			NysiisAlgorithm.compute("casstevens").get must beEqualTo("castafan")
			NysiisAlgorithm.compute("vasquez").get must beEqualTo("vasg")
			NysiisAlgorithm.compute("frazier").get must beEqualTo("frasar")
			NysiisAlgorithm.compute("bowman").get must beEqualTo("banan")
			NysiisAlgorithm.compute("mcknight").get must beEqualTo("mcnagt")
			NysiisAlgorithm.compute("rickert").get must beEqualTo("racad")
			NysiisAlgorithm.compute("deutsch").get must beEqualTo("dat") // dropby wrongly says dats
			NysiisAlgorithm.compute("westphal").get must beEqualTo("wastfal")
			NysiisAlgorithm.compute("shriver").get must beEqualTo("shravar")
			NysiisAlgorithm.compute("kuhl").get must beEqualTo("cal") // dropby wrongly says c
			NysiisAlgorithm.compute("rawson").get must beEqualTo("rasan")
			NysiisAlgorithm.compute("jiles").get must beEqualTo("jal")
			NysiisAlgorithm.compute("carraway").get must beEqualTo("caray")
			NysiisAlgorithm.compute("yamada").get must beEqualTo("yanad")
		}
	}
}
