package com.rockymadden.stringmetric.phonetic

object RefinedSoundexAlgorithmSpec extends org.specs2.mutable.Specification {
	"compute method" should {
		"return None with empty argument" in {
			RefinedSoundexAlgorithm.compute("").isDefined must beFalse
		}
		"return None with non-phonetic argument" in {
			RefinedSoundexAlgorithm.compute("123").isDefined must beFalse
		}
		"return Some with phonetic argument" in {
			// a
			RefinedSoundexAlgorithm.compute("a").get must beEqualTo("a0")
			RefinedSoundexAlgorithm.compute("aa").get must beEqualTo("a0")

			// b
			RefinedSoundexAlgorithm.compute("b").get must beEqualTo("b1")
			RefinedSoundexAlgorithm.compute("bb").get must beEqualTo("b1")

			// c
			RefinedSoundexAlgorithm.compute("c").get must beEqualTo("c3")
			RefinedSoundexAlgorithm.compute("cc").get must beEqualTo("c3")

			// d
			RefinedSoundexAlgorithm.compute("d").get must beEqualTo("d6")
			RefinedSoundexAlgorithm.compute("dd").get must beEqualTo("d6")

			// e
			RefinedSoundexAlgorithm.compute("e").get must beEqualTo("e0")
			RefinedSoundexAlgorithm.compute("ee").get must beEqualTo("e0")

			// f
			RefinedSoundexAlgorithm.compute("f").get must beEqualTo("f2")
			RefinedSoundexAlgorithm.compute("ff").get must beEqualTo("f2")

			// g
			RefinedSoundexAlgorithm.compute("g").get must beEqualTo("g4")
			RefinedSoundexAlgorithm.compute("gg").get must beEqualTo("g4")

			// h
			RefinedSoundexAlgorithm.compute("h").get must beEqualTo("h0")
			RefinedSoundexAlgorithm.compute("hh").get must beEqualTo("h0")

			// i
			RefinedSoundexAlgorithm.compute("i").get must beEqualTo("i0")
			RefinedSoundexAlgorithm.compute("ii").get must beEqualTo("i0")

			// j
			RefinedSoundexAlgorithm.compute("j").get must beEqualTo("j4")
			RefinedSoundexAlgorithm.compute("jj").get must beEqualTo("j4")

			// k
			RefinedSoundexAlgorithm.compute("k").get must beEqualTo("k3")
			RefinedSoundexAlgorithm.compute("kk").get must beEqualTo("k3")

			// l
			RefinedSoundexAlgorithm.compute("l").get must beEqualTo("l7")
			RefinedSoundexAlgorithm.compute("ll").get must beEqualTo("l7")

			// m
			RefinedSoundexAlgorithm.compute("m").get must beEqualTo("m8")
			RefinedSoundexAlgorithm.compute("mm").get must beEqualTo("m8")

			// n
			RefinedSoundexAlgorithm.compute("n").get must beEqualTo("n8")
			RefinedSoundexAlgorithm.compute("nn").get must beEqualTo("n8")

			// o
			RefinedSoundexAlgorithm.compute("o").get must beEqualTo("o0")
			RefinedSoundexAlgorithm.compute("oo").get must beEqualTo("o0")

			// p
			RefinedSoundexAlgorithm.compute("p").get must beEqualTo("p1")
			RefinedSoundexAlgorithm.compute("pp").get must beEqualTo("p1")

			// q
			RefinedSoundexAlgorithm.compute("q").get must beEqualTo("q5")
			RefinedSoundexAlgorithm.compute("qq").get must beEqualTo("q5")

			// r
			RefinedSoundexAlgorithm.compute("r").get must beEqualTo("r9")
			RefinedSoundexAlgorithm.compute("rr").get must beEqualTo("r9")

			// s
			RefinedSoundexAlgorithm.compute("s").get must beEqualTo("s3")
			RefinedSoundexAlgorithm.compute("ss").get must beEqualTo("s3")

			// t
			RefinedSoundexAlgorithm.compute("t").get must beEqualTo("t6")
			RefinedSoundexAlgorithm.compute("tt").get must beEqualTo("t6")

			// u
			RefinedSoundexAlgorithm.compute("u").get must beEqualTo("u0")
			RefinedSoundexAlgorithm.compute("uu").get must beEqualTo("u0")

			// v
			RefinedSoundexAlgorithm.compute("v").get must beEqualTo("v2")
			RefinedSoundexAlgorithm.compute("vv").get must beEqualTo("v2")

			// w
			RefinedSoundexAlgorithm.compute("w").get must beEqualTo("w0")
			RefinedSoundexAlgorithm.compute("ww").get must beEqualTo("w0")

			// x
			RefinedSoundexAlgorithm.compute("x").get must beEqualTo("x5")
			RefinedSoundexAlgorithm.compute("xx").get must beEqualTo("x5")

			// y
			RefinedSoundexAlgorithm.compute("y").get must beEqualTo("y0")
			RefinedSoundexAlgorithm.compute("yy").get must beEqualTo("y0")

			// z
			RefinedSoundexAlgorithm.compute("z").get must beEqualTo("z5")
			RefinedSoundexAlgorithm.compute("zz").get must beEqualTo("z5")

			// Starting with letter then numbers.
			RefinedSoundexAlgorithm.compute("x123456").get must beEqualTo("x5")
			RefinedSoundexAlgorithm.compute("a123456").get must beEqualTo("a0")
			RefinedSoundexAlgorithm.compute("f123456").get must beEqualTo("f2")

			// Miscellaneous.
			RefinedSoundexAlgorithm.compute("braz").get must beEqualTo("b1905")
			RefinedSoundexAlgorithm.compute("broz").get must beEqualTo("b1905")
			RefinedSoundexAlgorithm.compute("caren").get must beEqualTo("c30908")
			RefinedSoundexAlgorithm.compute("carren").get must beEqualTo("c30908")
			RefinedSoundexAlgorithm.compute("coram").get must beEqualTo("c30908")
			RefinedSoundexAlgorithm.compute("corran").get must beEqualTo("c30908")
			RefinedSoundexAlgorithm.compute("curreen").get must beEqualTo("c30908")
			RefinedSoundexAlgorithm.compute("curwen").get must beEqualTo("c30908")
			RefinedSoundexAlgorithm.compute("hairs").get must beEqualTo("h093")
			RefinedSoundexAlgorithm.compute("hark").get must beEqualTo("h093")
			RefinedSoundexAlgorithm.compute("hars").get must beEqualTo("h093")
			RefinedSoundexAlgorithm.compute("hayers").get must beEqualTo("h093")
			RefinedSoundexAlgorithm.compute("heers").get must beEqualTo("h093")
			RefinedSoundexAlgorithm.compute("hiers").get must beEqualTo("h093")
			RefinedSoundexAlgorithm.compute("lambard").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("lambart").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("lambert").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("lambird").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("lampaert").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("lampart").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("lamport").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("limbert").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("lombard").get must beEqualTo("l7081096")
			RefinedSoundexAlgorithm.compute("nolton").get must beEqualTo("n807608")
			RefinedSoundexAlgorithm.compute("noulton").get must beEqualTo("n807608")
		}
	}
}
