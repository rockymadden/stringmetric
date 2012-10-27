package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class NysiisSpec extends ScalaTest {
	"Nysiis" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					Nysiis.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					Nysiis.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// a
					Nysiis.compute("a").get should equal ("a")
					Nysiis.compute("aa").get should equal ("a")

					// b
					Nysiis.compute("b").get should equal ("b")
					Nysiis.compute("bb").get should equal ("bb")

					// c
					Nysiis.compute("c").get should equal ("c")
					Nysiis.compute("cc").get should equal ("cc")

					// d
					Nysiis.compute("d").get should equal ("d")
					Nysiis.compute("dd").get should equal ("dd")

					// e
					Nysiis.compute("e").get should equal ("e")
					Nysiis.compute("ee").get should equal ("y")

					// f
					Nysiis.compute("f").get should equal ("f")
					Nysiis.compute("ff").get should equal ("ff")

					// g
					Nysiis.compute("g").get should equal ("g")
					Nysiis.compute("gg").get should equal ("gg")

					// h
					Nysiis.compute("h").get should equal ("h")
					Nysiis.compute("hh").get should equal ("hh")

					// i
					Nysiis.compute("i").get should equal ("i")
					Nysiis.compute("ii").get should equal ("i")

					// j
					Nysiis.compute("j").get should equal ("j")
					Nysiis.compute("jj").get should equal ("jj")

					// k
					Nysiis.compute("k").get should equal ("c")
					Nysiis.compute("kk").get should equal ("cc")

					// l
					Nysiis.compute("l").get should equal ("l")
					Nysiis.compute("ll").get should equal ("ll")

					// m
					Nysiis.compute("m").get should equal ("m")
					Nysiis.compute("mm").get should equal ("mn")

					// n
					Nysiis.compute("n").get should equal ("n")
					Nysiis.compute("nn").get should equal ("nn")

					// o
					Nysiis.compute("o").get should equal ("o")
					Nysiis.compute("oo").get should equal ("o")

					// p
					Nysiis.compute("p").get should equal ("p")
					Nysiis.compute("pp").get should equal ("pp")

					// q
					Nysiis.compute("q").get should equal ("q")
					Nysiis.compute("qq").get should equal ("qg")

					// r
					Nysiis.compute("r").get should equal ("r")
					Nysiis.compute("rr").get should equal ("rr")

					// s
					Nysiis.compute("s").get should equal ("s")
					Nysiis.compute("ss").get should equal ("s")

					// t
					Nysiis.compute("t").get should equal ("t")
					Nysiis.compute("tt").get should equal ("tt")

					// u
					Nysiis.compute("u").get should equal ("u")
					Nysiis.compute("uu").get should equal ("u")

					// v
					Nysiis.compute("v").get should equal ("v")
					Nysiis.compute("vv").get should equal ("vv")

					// w
					Nysiis.compute("w").get should equal ("w")
					Nysiis.compute("ww").get should equal ("ww")

					// x
					Nysiis.compute("x").get should equal ("x")
					Nysiis.compute("xx").get should equal ("xx")

					// y
					Nysiis.compute("y").get should equal ("y")
					Nysiis.compute("yy").get should equal ("yy")

					// z
					Nysiis.compute("z").get should equal ("z")
					Nysiis.compute("zz").get should equal ("z")

					// Head cases.
					Nysiis.compute("mac").get should equal ("mc")
					Nysiis.compute("kn").get should equal ("nn")
					Nysiis.compute("k").get should equal ("c")
					Nysiis.compute("ph").get should equal ("ff")
					Nysiis.compute("pf").get should equal ("ff")
					Nysiis.compute("sch").get should equal ("s") // dropby wrongly says ss

					// Last cases.
					Nysiis.compute("ee").get should equal ("y")
					Nysiis.compute("ie").get should equal ("y")
					Nysiis.compute("dt").get should equal ("d")
					Nysiis.compute("rt").get should equal ("d")
					Nysiis.compute("rd").get should equal ("d")
					Nysiis.compute("nt").get should equal ("d")
					Nysiis.compute("nd").get should equal ("d")

					// Core cases.
					Nysiis.compute("eev").get should equal ("yv") //dropby wrongly says eaf
					Nysiis.compute("zev").get should equal ("zaf")
					Nysiis.compute("kkn").get should equal ("cn")
					Nysiis.compute("sschn").get should equal ("ssn")
					Nysiis.compute("pph").get should equal ("pf")

					// Miscellaneous.
					Nysiis.compute("macdonald").get should equal ("mcdanald")
					Nysiis.compute("phone").get should equal ("ffan")
					Nysiis.compute("aggregate").get should equal ("agragat")
					Nysiis.compute("accuracy").get should equal ("acaracy")
					Nysiis.compute("encyclopedia").get should equal ("encyclapad")
					Nysiis.compute("honorificabilitudinitatibus").get should equal ("hanarafacabalatadanatatab")
					Nysiis.compute("antidisestablishmentarianism").get should equal ("antadasastablasnantaranasn")
				}
			}
		}
	}
}