package com.rockymadden.stringmetric.phonetic

object MetaphoneAlgorithmSpec extends org.specs2.mutable.Specification {
	"MetaphoneAlgorithm compute()" should {
		"return None with empty argument" in {
			MetaphoneAlgorithm.compute("").isDefined must beFalse
		}
		"return None with non-phonetic argument" in {
			MetaphoneAlgorithm.compute("123").isDefined must beFalse
		}
		"return Some with phonetic argument" in {
			// z
			MetaphoneAlgorithm.compute("z").get must beEqualTo("s")
			MetaphoneAlgorithm.compute("zz").get must beEqualTo("s")

			// y
			MetaphoneAlgorithm.compute("y").isDefined must beFalse
			MetaphoneAlgorithm.compute("zy").get must beEqualTo("s")
			MetaphoneAlgorithm.compute("zyz").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zya").get must beEqualTo("sy")

			// x
			MetaphoneAlgorithm.compute("x").get must beEqualTo("s")
			MetaphoneAlgorithm.compute("zx").get must beEqualTo("sks")
			MetaphoneAlgorithm.compute("zxz").get must beEqualTo("skss")

			// w
			MetaphoneAlgorithm.compute("w").isDefined must beFalse
			MetaphoneAlgorithm.compute("zw").get must beEqualTo("s")
			MetaphoneAlgorithm.compute("zwz").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zwa").get must beEqualTo("sw")

			// v
			MetaphoneAlgorithm.compute("v").get must beEqualTo("f")
			MetaphoneAlgorithm.compute("zv").get must beEqualTo("sf")
			MetaphoneAlgorithm.compute("zvz").get must beEqualTo("sfs")

			// u
			MetaphoneAlgorithm.compute("u").get must beEqualTo("u")
			MetaphoneAlgorithm.compute("zu").get must beEqualTo("s")

			// t
			MetaphoneAlgorithm.compute("t").get must beEqualTo("t")
			MetaphoneAlgorithm.compute("ztiaz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("ztioz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("zthz").get must beEqualTo("s0s")
			MetaphoneAlgorithm.compute("ztchz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("ztz").get must beEqualTo("sts")

			// s
			MetaphoneAlgorithm.compute("s").get must beEqualTo("s")
			MetaphoneAlgorithm.compute("zshz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("zsioz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("zsiaz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("zs").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zsz").get must beEqualTo("sss")

			// r
			MetaphoneAlgorithm.compute("r").get must beEqualTo("r")
			MetaphoneAlgorithm.compute("zr").get must beEqualTo("sr")
			MetaphoneAlgorithm.compute("zrz").get must beEqualTo("srs")

			// q
			MetaphoneAlgorithm.compute("q").get must beEqualTo("k")
			MetaphoneAlgorithm.compute("zq").get must beEqualTo("sk")
			MetaphoneAlgorithm.compute("zqz").get must beEqualTo("sks")

			// p
			MetaphoneAlgorithm.compute("p").get must beEqualTo("p")
			MetaphoneAlgorithm.compute("zp").get must beEqualTo("sp")
			MetaphoneAlgorithm.compute("zph").get must beEqualTo("sf")
			MetaphoneAlgorithm.compute("zpz").get must beEqualTo("sps")

			// o
			MetaphoneAlgorithm.compute("o").get must beEqualTo("o")
			MetaphoneAlgorithm.compute("zo").get must beEqualTo("s")

			// n
			MetaphoneAlgorithm.compute("n").get must beEqualTo("n")
			MetaphoneAlgorithm.compute("zn").get must beEqualTo("sn")
			MetaphoneAlgorithm.compute("znz").get must beEqualTo("sns")

			// m
			MetaphoneAlgorithm.compute("m").get must beEqualTo("m")
			MetaphoneAlgorithm.compute("zm").get must beEqualTo("sm")
			MetaphoneAlgorithm.compute("zmz").get must beEqualTo("sms")

			// l
			MetaphoneAlgorithm.compute("l").get must beEqualTo("l")
			MetaphoneAlgorithm.compute("zl").get must beEqualTo("sl")
			MetaphoneAlgorithm.compute("zlz").get must beEqualTo("sls")

			// k
			MetaphoneAlgorithm.compute("k").get must beEqualTo("k")
			MetaphoneAlgorithm.compute("zk").get must beEqualTo("sk")
			MetaphoneAlgorithm.compute("zck").get must beEqualTo("sk")

			// j
			MetaphoneAlgorithm.compute("j").get must beEqualTo("j")
			MetaphoneAlgorithm.compute("zj").get must beEqualTo("sj")
			MetaphoneAlgorithm.compute("zjz").get must beEqualTo("sjs")

			// i
			MetaphoneAlgorithm.compute("i").get must beEqualTo("i")
			MetaphoneAlgorithm.compute("zi").get must beEqualTo("s")

			// h
			MetaphoneAlgorithm.compute("h").get must beEqualTo("h") // php wrongly says nothing
			MetaphoneAlgorithm.compute("zh").get must beEqualTo("sh") // php wrongly says s
			MetaphoneAlgorithm.compute("zah").get must beEqualTo("s")
			MetaphoneAlgorithm.compute("zchh").get must beEqualTo("sx")
			MetaphoneAlgorithm.compute("ha").get must beEqualTo("h")

			// g
			MetaphoneAlgorithm.compute("g").get must beEqualTo("k")
			MetaphoneAlgorithm.compute("zg").get must beEqualTo("sk")
			MetaphoneAlgorithm.compute("zgh").get must beEqualTo("skh") // php wrongly says sf
			MetaphoneAlgorithm.compute("zghz").get must beEqualTo("shs") // php wrongly says sfs
			MetaphoneAlgorithm.compute("zgha").get must beEqualTo("sh") // php wrongly says sf others wrongly say skh
			MetaphoneAlgorithm.compute("zgn").get must beEqualTo("sn")
			MetaphoneAlgorithm.compute("zgns").get must beEqualTo("skns")
			MetaphoneAlgorithm.compute("zgned").get must beEqualTo("snt") // others wrongly says sknt
			MetaphoneAlgorithm.compute("zgneds").get must beEqualTo("sknts") // php wrongly says snts
			MetaphoneAlgorithm.compute("zgi").get must beEqualTo("sj")
			MetaphoneAlgorithm.compute("zgiz").get must beEqualTo("sjs")
			MetaphoneAlgorithm.compute("zge").get must beEqualTo("sj")
			MetaphoneAlgorithm.compute("zgez").get must beEqualTo("sjs")
			MetaphoneAlgorithm.compute("zgy").get must beEqualTo("sj")
			MetaphoneAlgorithm.compute("zgyz").get must beEqualTo("sjs")
			MetaphoneAlgorithm.compute("zgz").get must beEqualTo("sks")

			// f
			MetaphoneAlgorithm.compute("f").get must beEqualTo("f")
			MetaphoneAlgorithm.compute("zf").get must beEqualTo("sf")
			MetaphoneAlgorithm.compute("zfz").get must beEqualTo("sfs")

			// e
			MetaphoneAlgorithm.compute("e").get must beEqualTo("e")
			MetaphoneAlgorithm.compute("ze").get must beEqualTo("s")

			// d
			MetaphoneAlgorithm.compute("d").get must beEqualTo("t")
			MetaphoneAlgorithm.compute("fudge").get must beEqualTo("fjj") // php wrongly says fj
			MetaphoneAlgorithm.compute("dodgy").get must beEqualTo("tjj") // php wrongly says tj others wrongly say tjjy
			MetaphoneAlgorithm.compute("dodgi").get must beEqualTo("tjj") // php wrongly says tj
			MetaphoneAlgorithm.compute("zd").get must beEqualTo("st")
			MetaphoneAlgorithm.compute("zdz").get must beEqualTo("sts")

			// c
			MetaphoneAlgorithm.compute("c").get must beEqualTo("k")
			MetaphoneAlgorithm.compute("zcia").get must beEqualTo("sx")
			MetaphoneAlgorithm.compute("zciaz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("zch").get must beEqualTo("sx")
			MetaphoneAlgorithm.compute("zchz").get must beEqualTo("sxs")
			MetaphoneAlgorithm.compute("zci").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zciz").get must beEqualTo("sss")
			MetaphoneAlgorithm.compute("zce").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zcez").get must beEqualTo("sss")
			MetaphoneAlgorithm.compute("zcy").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zcyz").get must beEqualTo("sss")
			MetaphoneAlgorithm.compute("zsci").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zsciz").get must beEqualTo("sss")
			MetaphoneAlgorithm.compute("zsce").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zscez").get must beEqualTo("sss")
			MetaphoneAlgorithm.compute("zscy").get must beEqualTo("ss")
			MetaphoneAlgorithm.compute("zscyz").get must beEqualTo("sss")
			MetaphoneAlgorithm.compute("zsch").get must beEqualTo("sskh") // php wrongly says ssx
			MetaphoneAlgorithm.compute("zc").get must beEqualTo("sk")
			MetaphoneAlgorithm.compute("zcz").get must beEqualTo("sks")

			// b
			MetaphoneAlgorithm.compute("b").get must beEqualTo("b")
			MetaphoneAlgorithm.compute("zb").get must beEqualTo("sb")
			MetaphoneAlgorithm.compute("zbz").get must beEqualTo("sbs")
			MetaphoneAlgorithm.compute("zmb").get must beEqualTo("sm")

			// a
			MetaphoneAlgorithm.compute("a").get must beEqualTo("a")
			MetaphoneAlgorithm.compute("za").get must beEqualTo("s")

			// Miscellaneous.
			MetaphoneAlgorithm.compute("dumb").get must beEqualTo("tm")
			MetaphoneAlgorithm.compute("smith").get must beEqualTo("sm0")
			MetaphoneAlgorithm.compute("school").get must beEqualTo("skhl") // php wrongly says sxl
			MetaphoneAlgorithm.compute("merci").get must beEqualTo("mrs")
			MetaphoneAlgorithm.compute("cool").get must beEqualTo("kl")
			MetaphoneAlgorithm.compute("aebersold").get must beEqualTo("ebrslt")
			MetaphoneAlgorithm.compute("gnagy").get must beEqualTo("nj")
			MetaphoneAlgorithm.compute("knuth").get must beEqualTo("n0")
			MetaphoneAlgorithm.compute("pniewski").get must beEqualTo("nsk")
			MetaphoneAlgorithm.compute("wright").get must beEqualTo("rht") // php wrongly says rft
			MetaphoneAlgorithm.compute("phone").get must beEqualTo("fn")
			MetaphoneAlgorithm.compute("aggregate").get must beEqualTo("akrkt")
			MetaphoneAlgorithm.compute("accuracy").get must beEqualTo("akkrs")
			MetaphoneAlgorithm.compute("encyclopedia").get must beEqualTo("ensklpt")
			MetaphoneAlgorithm.compute("honorificabilitudinitatibus").get must beEqualTo("hnrfkblttnttbs")
			MetaphoneAlgorithm.compute("antidisestablishmentarianism").get must beEqualTo("anttsstblxmntrnsm")
		}
	}
}
