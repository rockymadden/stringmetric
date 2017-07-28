package com.rockymadden.stringmetric.phonetic

object SoundexAlgorithmSpec extends org.specs2.mutable.Specification {
	"SoundexAlgorithm compute()" should {
		"return None with empty argument" in {
			SoundexAlgorithm.compute("").isDefined must beFalse
		}
		"return None with non-phonetic argument" in {
			SoundexAlgorithm.compute("123").isDefined must beFalse
		}
		"return Some with phonetic argument" in {
			// a
			SoundexAlgorithm.compute("a").get must beEqualTo("a000")
			SoundexAlgorithm.compute("aa").get must beEqualTo("a000")

			// b
			SoundexAlgorithm.compute("b").get must beEqualTo("b000")
			SoundexAlgorithm.compute("bb").get must beEqualTo("b000")

			// c
			SoundexAlgorithm.compute("c").get must beEqualTo("c000")
			SoundexAlgorithm.compute("cc").get must beEqualTo("c000")

			// d
			SoundexAlgorithm.compute("d").get must beEqualTo("d000")
			SoundexAlgorithm.compute("dd").get must beEqualTo("d000")

			// e
			SoundexAlgorithm.compute("e").get must beEqualTo("e000")
			SoundexAlgorithm.compute("ee").get must beEqualTo("e000")

			// f
			SoundexAlgorithm.compute("f").get must beEqualTo("f000")
			SoundexAlgorithm.compute("ff").get must beEqualTo("f000")

			// g
			SoundexAlgorithm.compute("g").get must beEqualTo("g000")
			SoundexAlgorithm.compute("gg").get must beEqualTo("g000")

			// h
			SoundexAlgorithm.compute("h").get must beEqualTo("h000")
			SoundexAlgorithm.compute("hh").get must beEqualTo("h000")

			// i
			SoundexAlgorithm.compute("i").get must beEqualTo("i000")
			SoundexAlgorithm.compute("ii").get must beEqualTo("i000")

			// j
			SoundexAlgorithm.compute("j").get must beEqualTo("j000")
			SoundexAlgorithm.compute("jj").get must beEqualTo("j000")

			// k
			SoundexAlgorithm.compute("k").get must beEqualTo("k000")
			SoundexAlgorithm.compute("kk").get must beEqualTo("k000")

			// l
			SoundexAlgorithm.compute("l").get must beEqualTo("l000")
			SoundexAlgorithm.compute("ll").get must beEqualTo("l000")

			// m
			SoundexAlgorithm.compute("m").get must beEqualTo("m000")
			SoundexAlgorithm.compute("mm").get must beEqualTo("m000")

			// n
			SoundexAlgorithm.compute("n").get must beEqualTo("n000")
			SoundexAlgorithm.compute("nn").get must beEqualTo("n000")

			// o
			SoundexAlgorithm.compute("o").get must beEqualTo("o000")
			SoundexAlgorithm.compute("oo").get must beEqualTo("o000")

			// p
			SoundexAlgorithm.compute("p").get must beEqualTo("p000")
			SoundexAlgorithm.compute("pp").get must beEqualTo("p000")

			// q
			SoundexAlgorithm.compute("q").get must beEqualTo("q000")
			SoundexAlgorithm.compute("qq").get must beEqualTo("q000")

			// r
			SoundexAlgorithm.compute("r").get must beEqualTo("r000")
			SoundexAlgorithm.compute("rr").get must beEqualTo("r000")

			// s
			SoundexAlgorithm.compute("s").get must beEqualTo("s000")
			SoundexAlgorithm.compute("ss").get must beEqualTo("s000")

			// t
			SoundexAlgorithm.compute("t").get must beEqualTo("t000")
			SoundexAlgorithm.compute("tt").get must beEqualTo("t000")

			// u
			SoundexAlgorithm.compute("u").get must beEqualTo("u000")
			SoundexAlgorithm.compute("uu").get must beEqualTo("u000")

			// v
			SoundexAlgorithm.compute("v").get must beEqualTo("v000")
			SoundexAlgorithm.compute("vv").get must beEqualTo("v000")

			// w
			SoundexAlgorithm.compute("w").get must beEqualTo("w000")
			SoundexAlgorithm.compute("ww").get must beEqualTo("w000")

			// x
			SoundexAlgorithm.compute("x").get must beEqualTo("x000")
			SoundexAlgorithm.compute("xx").get must beEqualTo("x000")

			// y
			SoundexAlgorithm.compute("y").get must beEqualTo("y000")
			SoundexAlgorithm.compute("yy").get must beEqualTo("y000")

			// z
			SoundexAlgorithm.compute("z").get must beEqualTo("z000")
			SoundexAlgorithm.compute("zz").get must beEqualTo("z000")

			// Starting with letter then numbers.
			SoundexAlgorithm.compute("x123456").get must beEqualTo("x000")
			SoundexAlgorithm.compute("a123456").get must beEqualTo("a000")
			SoundexAlgorithm.compute("f123456").get must beEqualTo("f000")

			// Miscellaneous.
			SoundexAlgorithm.compute("abc").get must beEqualTo("a120")
			SoundexAlgorithm.compute("xyz").get must beEqualTo("x200")
			SoundexAlgorithm.compute("robert").get must beEqualTo("r163")
			SoundexAlgorithm.compute("rupert").get must beEqualTo("r163")
			SoundexAlgorithm.compute("rubin").get must beEqualTo("r150")
			SoundexAlgorithm.compute("ashcraft").get must beEqualTo("a261")
			SoundexAlgorithm.compute("tymczak").get must beEqualTo("t522")
			SoundexAlgorithm.compute("pfister").get must beEqualTo("p236")
			SoundexAlgorithm.compute("euler").get must beEqualTo("e460")
			SoundexAlgorithm.compute("gauss").get must beEqualTo("g200")
			SoundexAlgorithm.compute("hilbert").get must beEqualTo("h416")
			SoundexAlgorithm.compute("knuth").get must beEqualTo("k530")
			SoundexAlgorithm.compute("lloyd").get must beEqualTo("l300")
			SoundexAlgorithm.compute("lukasiewicz").get must beEqualTo("l222")
			SoundexAlgorithm.compute("ashcroft").get must beEqualTo("a261")
			SoundexAlgorithm.compute("tymczak").get must beEqualTo("t522")
			SoundexAlgorithm.compute("pfister").get must beEqualTo("p236")
			SoundexAlgorithm.compute("ellery").get must beEqualTo("e460")
			SoundexAlgorithm.compute("ghosh").get must beEqualTo("g200")
			SoundexAlgorithm.compute("heilbronn").get must beEqualTo("h416")
			SoundexAlgorithm.compute("kant").get must beEqualTo("k530")
			SoundexAlgorithm.compute("ladd").get must beEqualTo("l300")
			SoundexAlgorithm.compute("lissajous").get must beEqualTo("l222")
			SoundexAlgorithm.compute("fusedale").get must beEqualTo("f234")
		}
	}
}
