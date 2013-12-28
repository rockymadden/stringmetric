package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedNysiisAlgorithmSpec extends ScalaTest {
	"RefinedNysiisAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					RefinedNysiisAlgorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					RefinedNysiisAlgorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// a
					RefinedNysiisAlgorithm.compute("a").get should equal ("a")
					RefinedNysiisAlgorithm.compute("aa").get should equal ("a")

					// b
					RefinedNysiisAlgorithm.compute("b").get should equal ("b")
					RefinedNysiisAlgorithm.compute("bb").get should equal ("b")

					// c
					RefinedNysiisAlgorithm.compute("c").get should equal ("c")
					RefinedNysiisAlgorithm.compute("cc").get should equal ("c")

					// d
					RefinedNysiisAlgorithm.compute("d").get should equal ("d")
					RefinedNysiisAlgorithm.compute("dd").get should equal ("d")

					// e
					RefinedNysiisAlgorithm.compute("e").get should equal ("e")
					RefinedNysiisAlgorithm.compute("ee").get should equal ("y")

					// f
					RefinedNysiisAlgorithm.compute("f").get should equal ("f")
					RefinedNysiisAlgorithm.compute("ff").get should equal ("f")

					// g
					RefinedNysiisAlgorithm.compute("g").get should equal ("g")
					RefinedNysiisAlgorithm.compute("gg").get should equal ("g")

					// h
					RefinedNysiisAlgorithm.compute("h").get should equal ("h")
					RefinedNysiisAlgorithm.compute("hh").get should equal ("h")

					// i
					RefinedNysiisAlgorithm.compute("i").get should equal ("i")
					RefinedNysiisAlgorithm.compute("ii").get should equal ("i")

					// j
					RefinedNysiisAlgorithm.compute("j").get should equal ("j")
					RefinedNysiisAlgorithm.compute("jj").get should equal ("j")

					// k
					RefinedNysiisAlgorithm.compute("k").get should equal ("c")
					RefinedNysiisAlgorithm.compute("kk").get should equal ("c")

					// l
					RefinedNysiisAlgorithm.compute("l").get should equal ("l")
					RefinedNysiisAlgorithm.compute("ll").get should equal ("l")

					// m
					RefinedNysiisAlgorithm.compute("m").get should equal ("m")
					RefinedNysiisAlgorithm.compute("mm").get should equal ("mn")

					// n
					RefinedNysiisAlgorithm.compute("n").get should equal ("n")
					RefinedNysiisAlgorithm.compute("nn").get should equal ("n")

					// o
					RefinedNysiisAlgorithm.compute("o").get should equal ("o")
					RefinedNysiisAlgorithm.compute("oo").get should equal ("o")

					// p
					RefinedNysiisAlgorithm.compute("p").get should equal ("p")
					RefinedNysiisAlgorithm.compute("pp").get should equal ("p")

					// q
					RefinedNysiisAlgorithm.compute("q").get should equal ("q")
					RefinedNysiisAlgorithm.compute("qq").get should equal ("qg")

					// r
					RefinedNysiisAlgorithm.compute("r").get should equal ("r")
					RefinedNysiisAlgorithm.compute("rr").get should equal ("r")

					// s
					RefinedNysiisAlgorithm.compute("s").get should equal ("s")
					RefinedNysiisAlgorithm.compute("ss").get should equal ("s")

					// t
					RefinedNysiisAlgorithm.compute("t").get should equal ("t")
					RefinedNysiisAlgorithm.compute("tt").get should equal ("t")

					// u
					RefinedNysiisAlgorithm.compute("u").get should equal ("u")
					RefinedNysiisAlgorithm.compute("uu").get should equal ("u")

					// v
					RefinedNysiisAlgorithm.compute("v").get should equal ("v")
					RefinedNysiisAlgorithm.compute("vv").get should equal ("v")

					// w
					RefinedNysiisAlgorithm.compute("w").get should equal ("w")
					RefinedNysiisAlgorithm.compute("ww").get should equal ("w")

					// x
					RefinedNysiisAlgorithm.compute("x").get should equal ("x")
					RefinedNysiisAlgorithm.compute("xx").get should equal ("x")

					// y
					RefinedNysiisAlgorithm.compute("y").get should equal ("y")
					RefinedNysiisAlgorithm.compute("yy").get should equal ("y")
					RefinedNysiisAlgorithm.compute("ybyb").get should equal ("ybab")

					// z
					RefinedNysiisAlgorithm.compute("z").get should equal ("z")
					RefinedNysiisAlgorithm.compute("zz").get should equal ("z")

					// Head cases.
					RefinedNysiisAlgorithm.compute("mac").get should equal ("mc")
					RefinedNysiisAlgorithm.compute("pf").get should equal ("f")

					// Last cases.
					RefinedNysiisAlgorithm.compute("ix").get should equal ("ic")
					RefinedNysiisAlgorithm.compute("ex").get should equal ("ec")
					RefinedNysiisAlgorithm.compute("ye").get should equal ("y")
					RefinedNysiisAlgorithm.compute("ee").get should equal ("y")
					RefinedNysiisAlgorithm.compute("ie").get should equal ("y")
					RefinedNysiisAlgorithm.compute("dt").get should equal ("d")
					RefinedNysiisAlgorithm.compute("rt").get should equal ("d")
					RefinedNysiisAlgorithm.compute("rd").get should equal ("d")
					RefinedNysiisAlgorithm.compute("nt").get should equal ("d")
					RefinedNysiisAlgorithm.compute("nd").get should equal ("d")

					// Core cases.
					RefinedNysiisAlgorithm.compute("bevb").get should equal ("bafb")
					RefinedNysiisAlgorithm.compute("bghtb").get should equal ("bgtb")
					RefinedNysiisAlgorithm.compute("bdgb").get should equal ("bgb")
					RefinedNysiisAlgorithm.compute("bphb").get should equal ("bfb")
					RefinedNysiisAlgorithm.compute("bknb").get should equal ("bnb")
					RefinedNysiisAlgorithm.compute("bshb").get should equal ("bsb")
					RefinedNysiisAlgorithm.compute("bschb").get should equal ("bsb")
					RefinedNysiisAlgorithm.compute("bywb").get should equal ("bab")
					RefinedNysiisAlgorithm.compute("byw").get should equal ("by")
					RefinedNysiisAlgorithm.compute("ywb").get should equal ("yb")
					RefinedNysiisAlgorithm.compute("bwrb").get should equal ("brb")

					// Transcode cases.
					RefinedNysiisAlgorithm.compute("bay").get should equal ("by")

					// Miscellaneous.
					RefinedNysiisAlgorithm.compute("macdonald").get should equal ("mcdanald")
					RefinedNysiisAlgorithm.compute("phone").get should equal ("fan")
					RefinedNysiisAlgorithm.compute("aggregate").get should equal ("agragat")
					RefinedNysiisAlgorithm.compute("accuracy").get should equal ("acaracy")
					RefinedNysiisAlgorithm.compute("encyclopedia").get should equal ("encaclapad")
					RefinedNysiisAlgorithm.compute("honorificabilitudinitatibus").get should equal ("hanarafacabalatadanatatab")
					RefinedNysiisAlgorithm.compute("antidisestablishmentarianism").get should equal ("antadasastablasnantaranasn")

					// Dropby.
					RefinedNysiisAlgorithm.compute("edwards").get should equal ("edwad")
					RefinedNysiisAlgorithm.compute("parez").get should equal ("par")
					RefinedNysiisAlgorithm.compute("macintosh").get should equal ("mcantas")
					RefinedNysiisAlgorithm.compute("phillipson").get should equal ("falapsan")
					RefinedNysiisAlgorithm.compute("haddix").get should equal ("hadac")
					RefinedNysiisAlgorithm.compute("essex").get should equal ("esac")
					RefinedNysiisAlgorithm.compute("moye").get should equal ("my")
					RefinedNysiisAlgorithm.compute("mckee").get should equal ("mcy")
					RefinedNysiisAlgorithm.compute("mackie").get should equal ("mcy")
					RefinedNysiisAlgorithm.compute("heitschmidt").get should equal ("hatsnad")
					RefinedNysiisAlgorithm.compute("bart").get should equal ("bad")
					RefinedNysiisAlgorithm.compute("hurd").get should equal ("had")
					RefinedNysiisAlgorithm.compute("hunt").get should equal ("had")
					RefinedNysiisAlgorithm.compute("westerlund").get should equal ("wastarlad")
					RefinedNysiisAlgorithm.compute("evers").get should equal ("evar")
					RefinedNysiisAlgorithm.compute("devito").get should equal ("dafat")
					RefinedNysiisAlgorithm.compute("rawson").get should equal ("rasan")
					RefinedNysiisAlgorithm.compute("shoulders").get should equal ("saldar")
					RefinedNysiisAlgorithm.compute("leighton").get should equal ("lagtan")
					RefinedNysiisAlgorithm.compute("wooldridge").get should equal ("waldrag")
					RefinedNysiisAlgorithm.compute("oliphant").get should equal ("olafad")
					RefinedNysiisAlgorithm.compute("hatchett").get should equal ("hatcat")
					RefinedNysiisAlgorithm.compute("mcknight").get should equal ("mcnagt")
					RefinedNysiisAlgorithm.compute("rickert").get should equal ("racad")
					RefinedNysiisAlgorithm.compute("bowman").get should equal ("banan")
					RefinedNysiisAlgorithm.compute("vasquez").get should equal ("vasg")
					RefinedNysiisAlgorithm.compute("bashaw").get should equal ("bas")
					RefinedNysiisAlgorithm.compute("schoenhoeft").get should equal ("sanaft") // dropby wrongly says scanaft
					RefinedNysiisAlgorithm.compute("heywood").get should equal ("had")
					RefinedNysiisAlgorithm.compute("hayman").get should equal ("hanan")
					RefinedNysiisAlgorithm.compute("seawright").get should equal ("saragt")
					RefinedNysiisAlgorithm.compute("kratzer").get should equal ("cratsar")
					RefinedNysiisAlgorithm.compute("canaday").get should equal ("canady")
					RefinedNysiisAlgorithm.compute("crepeau").get should equal ("crap")
				}
			}
		}
	}
}
