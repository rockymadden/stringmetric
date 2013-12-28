package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedSoundexAlgorithmSpec extends ScalaTest {
	"RefinedSoundexAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					RefinedSoundexAlgorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					RefinedSoundexAlgorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// a
					RefinedSoundexAlgorithm.compute("a").get should equal ("a0")
					RefinedSoundexAlgorithm.compute("aa").get should equal ("a0")

					// b
					RefinedSoundexAlgorithm.compute("b").get should equal ("b1")
					RefinedSoundexAlgorithm.compute("bb").get should equal ("b1")

					// c
					RefinedSoundexAlgorithm.compute("c").get should equal ("c3")
					RefinedSoundexAlgorithm.compute("cc").get should equal ("c3")

					// d
					RefinedSoundexAlgorithm.compute("d").get should equal ("d6")
					RefinedSoundexAlgorithm.compute("dd").get should equal ("d6")

					// e
					RefinedSoundexAlgorithm.compute("e").get should equal ("e0")
					RefinedSoundexAlgorithm.compute("ee").get should equal ("e0")

					// f
					RefinedSoundexAlgorithm.compute("f").get should equal ("f2")
					RefinedSoundexAlgorithm.compute("ff").get should equal ("f2")

					// g
					RefinedSoundexAlgorithm.compute("g").get should equal ("g4")
					RefinedSoundexAlgorithm.compute("gg").get should equal ("g4")

					// h
					RefinedSoundexAlgorithm.compute("h").get should equal ("h0")
					RefinedSoundexAlgorithm.compute("hh").get should equal ("h0")

					// i
					RefinedSoundexAlgorithm.compute("i").get should equal ("i0")
					RefinedSoundexAlgorithm.compute("ii").get should equal ("i0")

					// j
					RefinedSoundexAlgorithm.compute("j").get should equal ("j4")
					RefinedSoundexAlgorithm.compute("jj").get should equal ("j4")

					// k
					RefinedSoundexAlgorithm.compute("k").get should equal ("k3")
					RefinedSoundexAlgorithm.compute("kk").get should equal ("k3")

					// l
					RefinedSoundexAlgorithm.compute("l").get should equal ("l7")
					RefinedSoundexAlgorithm.compute("ll").get should equal ("l7")

					// m
					RefinedSoundexAlgorithm.compute("m").get should equal ("m8")
					RefinedSoundexAlgorithm.compute("mm").get should equal ("m8")

					// n
					RefinedSoundexAlgorithm.compute("n").get should equal ("n8")
					RefinedSoundexAlgorithm.compute("nn").get should equal ("n8")

					// o
					RefinedSoundexAlgorithm.compute("o").get should equal ("o0")
					RefinedSoundexAlgorithm.compute("oo").get should equal ("o0")

					// p
					RefinedSoundexAlgorithm.compute("p").get should equal ("p1")
					RefinedSoundexAlgorithm.compute("pp").get should equal ("p1")

					// q
					RefinedSoundexAlgorithm.compute("q").get should equal ("q5")
					RefinedSoundexAlgorithm.compute("qq").get should equal ("q5")

					// r
					RefinedSoundexAlgorithm.compute("r").get should equal ("r9")
					RefinedSoundexAlgorithm.compute("rr").get should equal ("r9")

					// s
					RefinedSoundexAlgorithm.compute("s").get should equal ("s3")
					RefinedSoundexAlgorithm.compute("ss").get should equal ("s3")

					// t
					RefinedSoundexAlgorithm.compute("t").get should equal ("t6")
					RefinedSoundexAlgorithm.compute("tt").get should equal ("t6")

					// u
					RefinedSoundexAlgorithm.compute("u").get should equal ("u0")
					RefinedSoundexAlgorithm.compute("uu").get should equal ("u0")

					// v
					RefinedSoundexAlgorithm.compute("v").get should equal ("v2")
					RefinedSoundexAlgorithm.compute("vv").get should equal ("v2")

					// w
					RefinedSoundexAlgorithm.compute("w").get should equal ("w0")
					RefinedSoundexAlgorithm.compute("ww").get should equal ("w0")

					// x
					RefinedSoundexAlgorithm.compute("x").get should equal ("x5")
					RefinedSoundexAlgorithm.compute("xx").get should equal ("x5")

					// y
					RefinedSoundexAlgorithm.compute("y").get should equal ("y0")
					RefinedSoundexAlgorithm.compute("yy").get should equal ("y0")

					// z
					RefinedSoundexAlgorithm.compute("z").get should equal ("z5")
					RefinedSoundexAlgorithm.compute("zz").get should equal ("z5")

					// Starting with letter then numbers.
					RefinedSoundexAlgorithm.compute("x123456").get should equal ("x5")
					RefinedSoundexAlgorithm.compute("a123456").get should equal ("a0")
					RefinedSoundexAlgorithm.compute("f123456").get should equal ("f2")

					// Miscellaneous.
					RefinedSoundexAlgorithm.compute("braz").get should equal ("b1905")
					RefinedSoundexAlgorithm.compute("broz").get should equal ("b1905")
					RefinedSoundexAlgorithm.compute("caren").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("carren").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("coram").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("corran").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("curreen").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("curwen").get should equal ("c30908")
					RefinedSoundexAlgorithm.compute("hairs").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hark").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hars").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hayers").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("heers").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("hiers").get should equal ("h093")
					RefinedSoundexAlgorithm.compute("lambard").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lambart").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lambert").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lambird").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lampaert").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lampart").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lamport").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("limbert").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("lombard").get should equal ("l7081096")
					RefinedSoundexAlgorithm.compute("nolton").get should equal ("n807608")
					RefinedSoundexAlgorithm.compute("noulton").get should equal ("n807608")
				}
			}
		}
	}
}
