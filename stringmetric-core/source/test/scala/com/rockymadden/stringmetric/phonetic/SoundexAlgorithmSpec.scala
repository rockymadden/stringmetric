package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class SoundexAlgorithmSpec extends ScalaTest {
	import SoundexAlgorithmSpec.Algorithm

	"SoundexAlgorithm" should provide {
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
					Algorithm.compute("a").get should equal ("a000")
					Algorithm.compute("aa").get should equal ("a000")

					// b
					Algorithm.compute("b").get should equal ("b000")
					Algorithm.compute("bb").get should equal ("b000")

					// c
					Algorithm.compute("c").get should equal ("c000")
					Algorithm.compute("cc").get should equal ("c000")

					// d
					Algorithm.compute("d").get should equal ("d000")
					Algorithm.compute("dd").get should equal ("d000")

					// e
					Algorithm.compute("e").get should equal ("e000")
					Algorithm.compute("ee").get should equal ("e000")

					// f
					Algorithm.compute("f").get should equal ("f000")
					Algorithm.compute("ff").get should equal ("f000")

					// g
					Algorithm.compute("g").get should equal ("g000")
					Algorithm.compute("gg").get should equal ("g000")

					// h
					Algorithm.compute("h").get should equal ("h000")
					Algorithm.compute("hh").get should equal ("h000")

					// i
					Algorithm.compute("i").get should equal ("i000")
					Algorithm.compute("ii").get should equal ("i000")

					// j
					Algorithm.compute("j").get should equal ("j000")
					Algorithm.compute("jj").get should equal ("j000")

					// k
					Algorithm.compute("k").get should equal ("k000")
					Algorithm.compute("kk").get should equal ("k000")

					// l
					Algorithm.compute("l").get should equal ("l000")
					Algorithm.compute("ll").get should equal ("l000")

					// m
					Algorithm.compute("m").get should equal ("m000")
					Algorithm.compute("mm").get should equal ("m000")

					// n
					Algorithm.compute("n").get should equal ("n000")
					Algorithm.compute("nn").get should equal ("n000")

					// o
					Algorithm.compute("o").get should equal ("o000")
					Algorithm.compute("oo").get should equal ("o000")

					// p
					Algorithm.compute("p").get should equal ("p000")
					Algorithm.compute("pp").get should equal ("p000")

					// q
					Algorithm.compute("q").get should equal ("q000")
					Algorithm.compute("qq").get should equal ("q000")

					// r
					Algorithm.compute("r").get should equal ("r000")
					Algorithm.compute("rr").get should equal ("r000")

					// s
					Algorithm.compute("s").get should equal ("s000")
					Algorithm.compute("ss").get should equal ("s000")

					// t
					Algorithm.compute("t").get should equal ("t000")
					Algorithm.compute("tt").get should equal ("t000")

					// u
					Algorithm.compute("u").get should equal ("u000")
					Algorithm.compute("uu").get should equal ("u000")

					// v
					Algorithm.compute("v").get should equal ("v000")
					Algorithm.compute("vv").get should equal ("v000")

					// w
					Algorithm.compute("w").get should equal ("w000")
					Algorithm.compute("ww").get should equal ("w000")

					// x
					Algorithm.compute("x").get should equal ("x000")
					Algorithm.compute("xx").get should equal ("x000")

					// y
					Algorithm.compute("y").get should equal ("y000")
					Algorithm.compute("yy").get should equal ("y000")

					// z
					Algorithm.compute("z").get should equal ("z000")
					Algorithm.compute("zz").get should equal ("z000")

					// Starting with letter then numbers.
					Algorithm.compute("x123456").get should equal ("x000")
					Algorithm.compute("a123456").get should equal ("a000")
					Algorithm.compute("f123456").get should equal ("f000")

					// Miscellaneous.
					Algorithm.compute("abc").get should equal ("a120")
					Algorithm.compute("xyz").get should equal ("x200")
					Algorithm.compute("robert").get should equal ("r163")
					Algorithm.compute("rupert").get should equal ("r163")
					Algorithm.compute("rubin").get should equal ("r150")
					Algorithm.compute("ashcraft").get should equal ("a261")
					Algorithm.compute("tymczak").get should equal ("t522")
					Algorithm.compute("pfister").get should equal ("p236")
					Algorithm.compute("euler").get should equal ("e460")
					Algorithm.compute("gauss").get should equal ("g200")
					Algorithm.compute("hilbert").get should equal ("h416")
					Algorithm.compute("knuth").get should equal ("k530")
					Algorithm.compute("lloyd").get should equal ("l300")
					Algorithm.compute("lukasiewicz").get should equal ("l222")
					Algorithm.compute("ashcroft").get should equal ("a261")
					Algorithm.compute("tymczak").get should equal ("t522")
					Algorithm.compute("pfister").get should equal ("p236")
					Algorithm.compute("ellery").get should equal ("e460")
					Algorithm.compute("ghosh").get should equal ("g200")
					Algorithm.compute("heilbronn").get should equal ("h416")
					Algorithm.compute("kant").get should equal ("k530")
					Algorithm.compute("ladd").get should equal ("l300")
					Algorithm.compute("lissajous").get should equal ("l222")
					Algorithm.compute("fusedale").get should equal ("f234")
				}
			}
		}
	}
	"SoundexAlgorithm companion object" should provide {
		"pass-through compute method" should returns {
			"same value as class" in {
				SoundexAlgorithm.compute("abc").get should equal ("a120")
			}
		}
	}
}

object SoundexAlgorithmSpec {
	final private val Algorithm = SoundexAlgorithm()
}
