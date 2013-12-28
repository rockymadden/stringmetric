package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NysiisAlgorithmSpec extends ScalaTest {
	"NysiisAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					NysiisAlgorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					NysiisAlgorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// a
					NysiisAlgorithm.compute("a").get should equal ("a")
					NysiisAlgorithm.compute("aa").get should equal ("a")

					// b
					NysiisAlgorithm.compute("b").get should equal ("b")
					NysiisAlgorithm.compute("bb").get should equal ("bb")

					// c
					NysiisAlgorithm.compute("c").get should equal ("c")
					NysiisAlgorithm.compute("cc").get should equal ("cc")

					// d
					NysiisAlgorithm.compute("d").get should equal ("d")
					NysiisAlgorithm.compute("dd").get should equal ("dd")

					// e
					NysiisAlgorithm.compute("e").get should equal ("e")
					NysiisAlgorithm.compute("ee").get should equal ("y")

					// f
					NysiisAlgorithm.compute("f").get should equal ("f")
					NysiisAlgorithm.compute("ff").get should equal ("ff")

					// g
					NysiisAlgorithm.compute("g").get should equal ("g")
					NysiisAlgorithm.compute("gg").get should equal ("gg")

					// h
					NysiisAlgorithm.compute("h").get should equal ("h")
					NysiisAlgorithm.compute("hh").get should equal ("hh")

					// i
					NysiisAlgorithm.compute("i").get should equal ("i")
					NysiisAlgorithm.compute("ii").get should equal ("i")

					// j
					NysiisAlgorithm.compute("j").get should equal ("j")
					NysiisAlgorithm.compute("jj").get should equal ("jj")

					// k
					NysiisAlgorithm.compute("k").get should equal ("c")
					NysiisAlgorithm.compute("kk").get should equal ("cc")

					// l
					NysiisAlgorithm.compute("l").get should equal ("l")
					NysiisAlgorithm.compute("ll").get should equal ("ll")

					// m
					NysiisAlgorithm.compute("m").get should equal ("m")
					NysiisAlgorithm.compute("mm").get should equal ("mn")

					// n
					NysiisAlgorithm.compute("n").get should equal ("n")
					NysiisAlgorithm.compute("nn").get should equal ("nn")

					// o
					NysiisAlgorithm.compute("o").get should equal ("o")
					NysiisAlgorithm.compute("oo").get should equal ("o")

					// p
					NysiisAlgorithm.compute("p").get should equal ("p")
					NysiisAlgorithm.compute("pp").get should equal ("pp")

					// q
					NysiisAlgorithm.compute("q").get should equal ("q")
					NysiisAlgorithm.compute("qq").get should equal ("qg")

					// r
					NysiisAlgorithm.compute("r").get should equal ("r")
					NysiisAlgorithm.compute("rr").get should equal ("rr")

					// s
					NysiisAlgorithm.compute("s").get should equal ("s")
					NysiisAlgorithm.compute("ss").get should equal ("s")

					// t
					NysiisAlgorithm.compute("t").get should equal ("t")
					NysiisAlgorithm.compute("tt").get should equal ("tt")

					// u
					NysiisAlgorithm.compute("u").get should equal ("u")
					NysiisAlgorithm.compute("uu").get should equal ("u")

					// v
					NysiisAlgorithm.compute("v").get should equal ("v")
					NysiisAlgorithm.compute("vv").get should equal ("vv")

					// w
					NysiisAlgorithm.compute("w").get should equal ("w")
					NysiisAlgorithm.compute("ww").get should equal ("ww")

					// x
					NysiisAlgorithm.compute("x").get should equal ("x")
					NysiisAlgorithm.compute("xx").get should equal ("xx")

					// y
					NysiisAlgorithm.compute("y").get should equal ("y")
					NysiisAlgorithm.compute("yy").get should equal ("yy")

					// z
					NysiisAlgorithm.compute("z").get should equal ("z")
					NysiisAlgorithm.compute("zz").get should equal ("z")

					// Head cases.
					NysiisAlgorithm.compute("mac").get should equal ("mc")
					NysiisAlgorithm.compute("kn").get should equal ("nn")
					NysiisAlgorithm.compute("k").get should equal ("c")
					NysiisAlgorithm.compute("ph").get should equal ("ff")
					NysiisAlgorithm.compute("pf").get should equal ("ff")
					NysiisAlgorithm.compute("sch").get should equal ("s") // dropby wrongly says ss

					// Last cases.
					NysiisAlgorithm.compute("ee").get should equal ("y")
					NysiisAlgorithm.compute("ie").get should equal ("y")
					NysiisAlgorithm.compute("dt").get should equal ("d")
					NysiisAlgorithm.compute("rt").get should equal ("d")
					NysiisAlgorithm.compute("rd").get should equal ("d")
					NysiisAlgorithm.compute("nt").get should equal ("d")
					NysiisAlgorithm.compute("nd").get should equal ("d")

					// Core cases.
					NysiisAlgorithm.compute("eev").get should equal ("eaf")
					NysiisAlgorithm.compute("zev").get should equal ("zaf")
					NysiisAlgorithm.compute("kkn").get should equal ("cn")
					NysiisAlgorithm.compute("sschn").get should equal ("ssn")
					NysiisAlgorithm.compute("pph").get should equal ("pf")

					// Miscellaneous.
					NysiisAlgorithm.compute("macdonald").get should equal ("mcdanald")
					NysiisAlgorithm.compute("phone").get should equal ("ffan")
					NysiisAlgorithm.compute("aggregate").get should equal ("agragat")
					NysiisAlgorithm.compute("accuracy").get should equal ("acaracy")
					NysiisAlgorithm.compute("encyclopedia").get should equal ("encyclapad")
					NysiisAlgorithm.compute("honorificabilitudinitatibus").get should equal ("hanarafacabalatadanatatab")
					NysiisAlgorithm.compute("antidisestablishmentarianism").get should equal ("antadasastablasnantaranasn")

					// Dropby.
					NysiisAlgorithm.compute("macintosh").get should equal ("mcant")
					NysiisAlgorithm.compute("knuth").get should equal ("nnat")
					NysiisAlgorithm.compute("koehn").get should equal ("can") // dropby wrongly says c
					NysiisAlgorithm.compute("phillipson").get should equal ("ffalapsan")
					NysiisAlgorithm.compute("pfeister").get should equal ("ffastar")
					NysiisAlgorithm.compute("schoenhoeft").get should equal ("ssanaft")
					NysiisAlgorithm.compute("mckee").get should equal ("mcy")
					NysiisAlgorithm.compute("heitschmedt").get should equal ("hatsnad")
					NysiisAlgorithm.compute("bart").get should equal ("bad")
					NysiisAlgorithm.compute("hurd").get should equal ("had")
					NysiisAlgorithm.compute("hunt").get should equal ("had")
					NysiisAlgorithm.compute("westerlund").get should equal ("wastarlad")
					NysiisAlgorithm.compute("casstevens").get should equal ("castafan")
					NysiisAlgorithm.compute("vasquez").get should equal ("vasg")
					NysiisAlgorithm.compute("frazier").get should equal ("frasar")
					NysiisAlgorithm.compute("bowman").get should equal ("banan")
					NysiisAlgorithm.compute("mcknight").get should equal ("mcnagt")
					NysiisAlgorithm.compute("rickert").get should equal ("racad")
					NysiisAlgorithm.compute("deutsch").get should equal ("dat") // dropby wrongly says dats
					NysiisAlgorithm.compute("westphal").get should equal ("wastfal")
					NysiisAlgorithm.compute("shriver").get should equal ("shravar")
					NysiisAlgorithm.compute("kuhl").get should equal ("cal") // dropby wrongly says c
					NysiisAlgorithm.compute("rawson").get should equal ("rasan")
					NysiisAlgorithm.compute("jiles").get should equal ("jal")
					NysiisAlgorithm.compute("carraway").get should equal ("caray")
					NysiisAlgorithm.compute("yamada").get should equal ("yanad")
				}
			}
		}
	}
}
