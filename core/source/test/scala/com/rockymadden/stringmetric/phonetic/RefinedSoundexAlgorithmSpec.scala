package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class RefinedSoundexAlgorithmSpec extends ScalaTest {
	import RefinedSoundexAlgorithmSpec.Algorithm

	"RefinedSoundexAlgorithm" should provide {
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
					Algorithm.compute("a").get should equal ("a0")
					Algorithm.compute("aa").get should equal ("a0")

					// b
					Algorithm.compute("b").get should equal ("b1")
					Algorithm.compute("bb").get should equal ("b1")

					// c
					Algorithm.compute("c").get should equal ("c3")
					Algorithm.compute("cc").get should equal ("c3")

					// d
					Algorithm.compute("d").get should equal ("d6")
					Algorithm.compute("dd").get should equal ("d6")

					// e
					Algorithm.compute("e").get should equal ("e0")
					Algorithm.compute("ee").get should equal ("e0")

					// f
					Algorithm.compute("f").get should equal ("f2")
					Algorithm.compute("ff").get should equal ("f2")

					// g
					Algorithm.compute("g").get should equal ("g4")
					Algorithm.compute("gg").get should equal ("g4")

					// h
					Algorithm.compute("h").get should equal ("h0")
					Algorithm.compute("hh").get should equal ("h0")

					// i
					Algorithm.compute("i").get should equal ("i0")
					Algorithm.compute("ii").get should equal ("i0")

					// j
					Algorithm.compute("j").get should equal ("j4")
					Algorithm.compute("jj").get should equal ("j4")

					// k
					Algorithm.compute("k").get should equal ("k3")
					Algorithm.compute("kk").get should equal ("k3")

					// l
					Algorithm.compute("l").get should equal ("l7")
					Algorithm.compute("ll").get should equal ("l7")

					// m
					Algorithm.compute("m").get should equal ("m8")
					Algorithm.compute("mm").get should equal ("m8")

					// n
					Algorithm.compute("n").get should equal ("n8")
					Algorithm.compute("nn").get should equal ("n8")

					// o
					Algorithm.compute("o").get should equal ("o0")
					Algorithm.compute("oo").get should equal ("o0")

					// p
					Algorithm.compute("p").get should equal ("p1")
					Algorithm.compute("pp").get should equal ("p1")

					// q
					Algorithm.compute("q").get should equal ("q5")
					Algorithm.compute("qq").get should equal ("q5")

					// r
					Algorithm.compute("r").get should equal ("r9")
					Algorithm.compute("rr").get should equal ("r9")

					// s
					Algorithm.compute("s").get should equal ("s3")
					Algorithm.compute("ss").get should equal ("s3")

					// t
					Algorithm.compute("t").get should equal ("t6")
					Algorithm.compute("tt").get should equal ("t6")

					// u
					Algorithm.compute("u").get should equal ("u0")
					Algorithm.compute("uu").get should equal ("u0")

					// v
					Algorithm.compute("v").get should equal ("v2")
					Algorithm.compute("vv").get should equal ("v2")

					// w
					Algorithm.compute("w").get should equal ("w0")
					Algorithm.compute("ww").get should equal ("w0")

					// x
					Algorithm.compute("x").get should equal ("x5")
					Algorithm.compute("xx").get should equal ("x5")

					// y
					Algorithm.compute("y").get should equal ("y0")
					Algorithm.compute("yy").get should equal ("y0")

					// z
					Algorithm.compute("z").get should equal ("z5")
					Algorithm.compute("zz").get should equal ("z5")

					// Starting with letter then numbers.
					Algorithm.compute("x123456").get should equal ("x5")
					Algorithm.compute("a123456").get should equal ("a0")
					Algorithm.compute("f123456").get should equal ("f2")

					// Miscellaneous.
					Algorithm.compute("braz").get should equal ("b1905")
					Algorithm.compute("broz").get should equal ("b1905")
					Algorithm.compute("caren").get should equal ("c30908")
					Algorithm.compute("carren").get should equal ("c30908")
					Algorithm.compute("coram").get should equal ("c30908")
					Algorithm.compute("corran").get should equal ("c30908")
					Algorithm.compute("curreen").get should equal ("c30908")
					Algorithm.compute("curwen").get should equal ("c30908")
					Algorithm.compute("hairs").get should equal ("h093")
					Algorithm.compute("hark").get should equal ("h093")
					Algorithm.compute("hars").get should equal ("h093")
					Algorithm.compute("hayers").get should equal ("h093")
					Algorithm.compute("heers").get should equal ("h093")
					Algorithm.compute("hiers").get should equal ("h093")
					Algorithm.compute("lambard").get should equal ("l7081096")
					Algorithm.compute("lambart").get should equal ("l7081096")
					Algorithm.compute("lambert").get should equal ("l7081096")
					Algorithm.compute("lambird").get should equal ("l7081096")
					Algorithm.compute("lampaert").get should equal ("l7081096")
					Algorithm.compute("lampart").get should equal ("l7081096")
					Algorithm.compute("lamport").get should equal ("l7081096")
					Algorithm.compute("limbert").get should equal ("l7081096")
					Algorithm.compute("lombard").get should equal ("l7081096")
					Algorithm.compute("nolton").get should equal ("n807608")
					Algorithm.compute("noulton").get should equal ("n807608")
				}
			}
		}
	}
	"RefinedSoundexAlgorithm companion object" should provide {
		"pass-through compute method" should returns {
			"same value as class" in {
				RefinedSoundexAlgorithm.compute("braz").get should equal ("b1905")
			}
		}
	}
}

object RefinedSoundexAlgorithmSpec {
	final private val Algorithm = RefinedSoundexAlgorithm()
}
