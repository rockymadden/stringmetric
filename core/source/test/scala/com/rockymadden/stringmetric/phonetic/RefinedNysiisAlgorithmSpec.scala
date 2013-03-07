package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedNysiisAlgorithmSpec extends ScalaTest {
	import RefinedNysiisAlgorithmSpec.Algorithm

	"RefinedNysiisAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					Algorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					Algorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// a
					Algorithm.compute("a").get should equal ("a")
					Algorithm.compute("aa").get should equal ("a")

					// b
					Algorithm.compute("b").get should equal ("b")
					Algorithm.compute("bb").get should equal ("b")

					// c
					Algorithm.compute("c").get should equal ("c")
					Algorithm.compute("cc").get should equal ("c")

					// d
					Algorithm.compute("d").get should equal ("d")
					Algorithm.compute("dd").get should equal ("d")

					// e
					Algorithm.compute("e").get should equal ("e")
					Algorithm.compute("ee").get should equal ("y")

					// f
					Algorithm.compute("f").get should equal ("f")
					Algorithm.compute("ff").get should equal ("f")

					// g
					Algorithm.compute("g").get should equal ("g")
					Algorithm.compute("gg").get should equal ("g")

					// h
					Algorithm.compute("h").get should equal ("h")
					Algorithm.compute("hh").get should equal ("h")

					// i
					Algorithm.compute("i").get should equal ("i")
					Algorithm.compute("ii").get should equal ("i")

					// j
					Algorithm.compute("j").get should equal ("j")
					Algorithm.compute("jj").get should equal ("j")

					// k
					Algorithm.compute("k").get should equal ("c")
					Algorithm.compute("kk").get should equal ("c")

					// l
					Algorithm.compute("l").get should equal ("l")
					Algorithm.compute("ll").get should equal ("l")

					// m
					Algorithm.compute("m").get should equal ("m")
					Algorithm.compute("mm").get should equal ("mn")

					// n
					Algorithm.compute("n").get should equal ("n")
					Algorithm.compute("nn").get should equal ("n")

					// o
					Algorithm.compute("o").get should equal ("o")
					Algorithm.compute("oo").get should equal ("o")

					// p
					Algorithm.compute("p").get should equal ("p")
					Algorithm.compute("pp").get should equal ("p")

					// q
					Algorithm.compute("q").get should equal ("q")
					Algorithm.compute("qq").get should equal ("qg")

					// r
					Algorithm.compute("r").get should equal ("r")
					Algorithm.compute("rr").get should equal ("r")

					// s
					Algorithm.compute("s").get should equal ("s")
					Algorithm.compute("ss").get should equal ("s")

					// t
					Algorithm.compute("t").get should equal ("t")
					Algorithm.compute("tt").get should equal ("t")

					// u
					Algorithm.compute("u").get should equal ("u")
					Algorithm.compute("uu").get should equal ("u")

					// v
					Algorithm.compute("v").get should equal ("v")
					Algorithm.compute("vv").get should equal ("v")

					// w
					Algorithm.compute("w").get should equal ("w")
					Algorithm.compute("ww").get should equal ("w")

					// x
					Algorithm.compute("x").get should equal ("x")
					Algorithm.compute("xx").get should equal ("x")

					// y
					Algorithm.compute("y").get should equal ("y")
					Algorithm.compute("yy").get should equal ("y")
					Algorithm.compute("ybyb").get should equal ("ybab")

					// z
					Algorithm.compute("z").get should equal ("z")
					Algorithm.compute("zz").get should equal ("z")

					// Head cases.
					Algorithm.compute("mac").get should equal ("mc")
					Algorithm.compute("pf").get should equal ("f")

					// Last cases.
					Algorithm.compute("ix").get should equal ("ic")
					Algorithm.compute("ex").get should equal ("ec")
					Algorithm.compute("ye").get should equal ("y")
					Algorithm.compute("ee").get should equal ("y")
					Algorithm.compute("ie").get should equal ("y")
					Algorithm.compute("dt").get should equal ("d")
					Algorithm.compute("rt").get should equal ("d")
					Algorithm.compute("rd").get should equal ("d")
					Algorithm.compute("nt").get should equal ("d")
					Algorithm.compute("nd").get should equal ("d")

					// Core cases.
					Algorithm.compute("bevb").get should equal ("bafb")
					Algorithm.compute("bghtb").get should equal ("bgtb")
					Algorithm.compute("bdgb").get should equal ("bgb")
					Algorithm.compute("bphb").get should equal ("bfb")
					Algorithm.compute("bknb").get should equal ("bnb")
					Algorithm.compute("bshb").get should equal ("bsb")
					Algorithm.compute("bschb").get should equal ("bsb")
					Algorithm.compute("bywb").get should equal ("bab")
					Algorithm.compute("byw").get should equal ("by")
					Algorithm.compute("ywb").get should equal ("yb")
					Algorithm.compute("bwrb").get should equal ("brb")

					// Transcode cases.
					Algorithm.compute("bay").get should equal ("by")

					// Miscellaneous.
					Algorithm.compute("macdonald").get should equal ("mcdanald")
					Algorithm.compute("phone").get should equal ("fan")
					Algorithm.compute("aggregate").get should equal ("agragat")
					Algorithm.compute("accuracy").get should equal ("acaracy")
					Algorithm.compute("encyclopedia").get should equal ("encaclapad")
					Algorithm.compute("honorificabilitudinitatibus").get should equal ("hanarafacabalatadanatatab")
					Algorithm.compute("antidisestablishmentarianism").get should equal ("antadasastablasnantaranasn")

					// Dropby.
					Algorithm.compute("edwards").get should equal ("edwad")
					Algorithm.compute("parez").get should equal ("par")
					Algorithm.compute("macintosh").get should equal ("mcantas")
					Algorithm.compute("phillipson").get should equal ("falapsan")
					Algorithm.compute("haddix").get should equal ("hadac")
					Algorithm.compute("essex").get should equal ("esac")
					Algorithm.compute("moye").get should equal ("my")
					Algorithm.compute("mckee").get should equal ("mcy")
					Algorithm.compute("mackie").get should equal ("mcy")
					Algorithm.compute("heitschmidt").get should equal ("hatsnad")
					Algorithm.compute("bart").get should equal ("bad")
					Algorithm.compute("hurd").get should equal ("had")
					Algorithm.compute("hunt").get should equal ("had")
					Algorithm.compute("westerlund").get should equal ("wastarlad")
					Algorithm.compute("evers").get should equal ("evar")
					Algorithm.compute("devito").get should equal ("dafat")
					Algorithm.compute("rawson").get should equal ("rasan")
					Algorithm.compute("shoulders").get should equal ("saldar")
					Algorithm.compute("leighton").get should equal ("lagtan")
					Algorithm.compute("wooldridge").get should equal ("waldrag")
					Algorithm.compute("oliphant").get should equal ("olafad")
					Algorithm.compute("hatchett").get should equal ("hatcat")
					Algorithm.compute("mcknight").get should equal ("mcnagt")
					Algorithm.compute("rickert").get should equal ("racad")
					Algorithm.compute("bowman").get should equal ("banan")
					Algorithm.compute("vasquez").get should equal ("vasg")
					Algorithm.compute("bashaw").get should equal ("bas")
					Algorithm.compute("schoenhoeft").get should equal ("sanaft") // dropby wrongly says scanaft
					Algorithm.compute("heywood").get should equal ("had")
					Algorithm.compute("hayman").get should equal ("hanan")
					Algorithm.compute("seawright").get should equal ("saragt")
					Algorithm.compute("kratzer").get should equal ("cratsar")
					Algorithm.compute("canaday").get should equal ("canady")
					Algorithm.compute("crepeau").get should equal ("crap")
				}
			}
		}
	}
}

object RefinedNysiisAlgorithmSpec {
	final private val Algorithm = RefinedNysiisAlgorithm()
}
