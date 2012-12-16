package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexAlgorithmSpec extends ScalaTest {
	"SoundexAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					SoundexAlgorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					SoundexAlgorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// a
					SoundexAlgorithm.compute("a").get should equal ("a000")
					SoundexAlgorithm.compute("aa").get should equal ("a000")

					// b
					SoundexAlgorithm.compute("b").get should equal ("b000")
					SoundexAlgorithm.compute("bb").get should equal ("b000")

					// c
					SoundexAlgorithm.compute("c").get should equal ("c000")
					SoundexAlgorithm.compute("cc").get should equal ("c000")

					// d
					SoundexAlgorithm.compute("d").get should equal ("d000")
					SoundexAlgorithm.compute("dd").get should equal ("d000")

					// e
					SoundexAlgorithm.compute("e").get should equal ("e000")
					SoundexAlgorithm.compute("ee").get should equal ("e000")

					// f
					SoundexAlgorithm.compute("f").get should equal ("f000")
					SoundexAlgorithm.compute("ff").get should equal ("f000")

					// g
					SoundexAlgorithm.compute("g").get should equal ("g000")
					SoundexAlgorithm.compute("gg").get should equal ("g000")

					// h
					SoundexAlgorithm.compute("h").get should equal ("h000")
					SoundexAlgorithm.compute("hh").get should equal ("h000")

					// i
					SoundexAlgorithm.compute("i").get should equal ("i000")
					SoundexAlgorithm.compute("ii").get should equal ("i000")

					// j
					SoundexAlgorithm.compute("j").get should equal ("j000")
					SoundexAlgorithm.compute("jj").get should equal ("j000")

					// k
					SoundexAlgorithm.compute("k").get should equal ("k000")
					SoundexAlgorithm.compute("kk").get should equal ("k000")

					// l
					SoundexAlgorithm.compute("l").get should equal ("l000")
					SoundexAlgorithm.compute("ll").get should equal ("l000")

					// m
					SoundexAlgorithm.compute("m").get should equal ("m000")
					SoundexAlgorithm.compute("mm").get should equal ("m000")

					// n
					SoundexAlgorithm.compute("n").get should equal ("n000")
					SoundexAlgorithm.compute("nn").get should equal ("n000")

					// o
					SoundexAlgorithm.compute("o").get should equal ("o000")
					SoundexAlgorithm.compute("oo").get should equal ("o000")

					// p
					SoundexAlgorithm.compute("p").get should equal ("p000")
					SoundexAlgorithm.compute("pp").get should equal ("p000")

					// q
					SoundexAlgorithm.compute("q").get should equal ("q000")
					SoundexAlgorithm.compute("qq").get should equal ("q000")

					// r
					SoundexAlgorithm.compute("r").get should equal ("r000")
					SoundexAlgorithm.compute("rr").get should equal ("r000")

					// s
					SoundexAlgorithm.compute("s").get should equal ("s000")
					SoundexAlgorithm.compute("ss").get should equal ("s000")

					// t
					SoundexAlgorithm.compute("t").get should equal ("t000")
					SoundexAlgorithm.compute("tt").get should equal ("t000")

					// u
					SoundexAlgorithm.compute("u").get should equal ("u000")
					SoundexAlgorithm.compute("uu").get should equal ("u000")

					// v
					SoundexAlgorithm.compute("v").get should equal ("v000")
					SoundexAlgorithm.compute("vv").get should equal ("v000")

					// w
					SoundexAlgorithm.compute("w").get should equal ("w000")
					SoundexAlgorithm.compute("ww").get should equal ("w000")

					// x
					SoundexAlgorithm.compute("x").get should equal ("x000")
					SoundexAlgorithm.compute("xx").get should equal ("x000")

					// y
					SoundexAlgorithm.compute("y").get should equal ("y000")
					SoundexAlgorithm.compute("yy").get should equal ("y000")

					// z
					SoundexAlgorithm.compute("z").get should equal ("z000")
					SoundexAlgorithm.compute("zz").get should equal ("z000")

					// Starting with letter then numbers.
					SoundexAlgorithm.compute("x123456").get should equal ("x000")
					SoundexAlgorithm.compute("a123456").get should equal ("a000")
					SoundexAlgorithm.compute("f123456").get should equal ("f000")

					// Miscellaneous.
					SoundexAlgorithm.compute("abc").get should equal ("a120")
					SoundexAlgorithm.compute("xyz").get should equal ("x200")
					SoundexAlgorithm.compute("robert").get should equal ("r163")
					SoundexAlgorithm.compute("rupert").get should equal ("r163")
					SoundexAlgorithm.compute("rubin").get should equal ("r150")
					SoundexAlgorithm.compute("ashcraft").get should equal ("a261")
					SoundexAlgorithm.compute("tymczak").get should equal ("t522")
					SoundexAlgorithm.compute("pfister").get should equal ("p236")
					SoundexAlgorithm.compute("euler").get should equal ("e460")
					SoundexAlgorithm.compute("gauss").get should equal ("g200")
					SoundexAlgorithm.compute("hilbert").get should equal ("h416")
					SoundexAlgorithm.compute("knuth").get should equal ("k530")
					SoundexAlgorithm.compute("lloyd").get should equal ("l300")
					SoundexAlgorithm.compute("lukasiewicz").get should equal ("l222")
					SoundexAlgorithm.compute("ashcroft").get should equal ("a261")
					SoundexAlgorithm.compute("tymczak").get should equal ("t522")
					SoundexAlgorithm.compute("pfister").get should equal ("p236")
					SoundexAlgorithm.compute("ellery").get should equal ("e460")
					SoundexAlgorithm.compute("ghosh").get should equal ("g200")
					SoundexAlgorithm.compute("heilbronn").get should equal ("h416")
					SoundexAlgorithm.compute("kant").get should equal ("k530")
					SoundexAlgorithm.compute("ladd").get should equal ("l300")
					SoundexAlgorithm.compute("lissajous").get should equal ("l222")
					SoundexAlgorithm.compute("fusedale").get should equal ("f234")
				}
			}
		}
	}
}