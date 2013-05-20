package com.rockymadden.stringmetric.phonetic

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class MetaphoneAlgorithmSpec extends ScalaTest {
	import MetaphoneAlgorithmSpec.Algorithm

	"MetaphoneAlgorithm" should provide {
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
					// z
					Algorithm.compute("z").get should equal ("s")
					Algorithm.compute("zz").get should equal ("s")

					// y
					Algorithm.compute("y").isDefined should be (false)
					Algorithm.compute("zy").get should equal ("s")
					Algorithm.compute("zyz").get should equal ("ss")
					Algorithm.compute("zya").get should equal ("sy")

					// x
					Algorithm.compute("x").get should equal ("s")
					Algorithm.compute("zx").get should equal ("sks")
					Algorithm.compute("zxz").get should equal ("skss")

					// w
					Algorithm.compute("w").isDefined should be (false)
					Algorithm.compute("zw").get should equal ("s")
					Algorithm.compute("zwz").get should equal ("ss")
					Algorithm.compute("zwa").get should equal ("sw")

					// v
					Algorithm.compute("v").get should equal ("f")
					Algorithm.compute("zv").get should equal ("sf")
					Algorithm.compute("zvz").get should equal ("sfs")

					// u
					Algorithm.compute("u").get should equal ("u")
					Algorithm.compute("zu").get should equal ("s")

					// t
					Algorithm.compute("t").get should equal ("t")
					Algorithm.compute("ztiaz").get should equal ("sxs")
					Algorithm.compute("ztioz").get should equal ("sxs")
					Algorithm.compute("zthz").get should equal ("s0s")
					Algorithm.compute("ztchz").get should equal ("sxs")
					Algorithm.compute("ztz").get should equal ("sts")

					// s
					Algorithm.compute("s").get should equal ("s")
					Algorithm.compute("zshz").get should equal ("sxs")
					Algorithm.compute("zsioz").get should equal ("sxs")
					Algorithm.compute("zsiaz").get should equal ("sxs")
					Algorithm.compute("zs").get should equal ("ss")
					Algorithm.compute("zsz").get should equal ("sss")

					// r
					Algorithm.compute("r").get should equal ("r")
					Algorithm.compute("zr").get should equal ("sr")
					Algorithm.compute("zrz").get should equal ("srs")

					// q
					Algorithm.compute("q").get should equal ("k")
					Algorithm.compute("zq").get should equal ("sk")
					Algorithm.compute("zqz").get should equal ("sks")

					// p
					Algorithm.compute("p").get should equal ("p")
					Algorithm.compute("zp").get should equal ("sp")
					Algorithm.compute("zph").get should equal ("sf")
					Algorithm.compute("zpz").get should equal ("sps")

					// o
					Algorithm.compute("o").get should equal ("o")
					Algorithm.compute("zo").get should equal ("s")

					// n
					Algorithm.compute("n").get should equal ("n")
					Algorithm.compute("zn").get should equal ("sn")
					Algorithm.compute("znz").get should equal ("sns")

					// m
					Algorithm.compute("m").get should equal ("m")
					Algorithm.compute("zm").get should equal ("sm")
					Algorithm.compute("zmz").get should equal ("sms")

					// l
					Algorithm.compute("l").get should equal ("l")
					Algorithm.compute("zl").get should equal ("sl")
					Algorithm.compute("zlz").get should equal ("sls")

					// k
					Algorithm.compute("k").get should equal ("k")
					Algorithm.compute("zk").get should equal ("sk")
					Algorithm.compute("zck").get should equal ("sk")

					// j
					Algorithm.compute("j").get should equal ("j")
					Algorithm.compute("zj").get should equal ("sj")
					Algorithm.compute("zjz").get should equal ("sjs")

					// i
					Algorithm.compute("i").get should equal ("i")
					Algorithm.compute("zi").get should equal ("s")

					// h
					Algorithm.compute("h").get should equal ("h") // php wrongly says nothing
					Algorithm.compute("zh").get should equal ("sh") // php wrongly says s
					Algorithm.compute("zah").get should equal ("s")
					Algorithm.compute("zchh").get should equal ("sx")
					Algorithm.compute("ha").get should equal ("h")

					// g
					Algorithm.compute("g").get should equal ("k")
					Algorithm.compute("zg").get should equal ("sk")
					Algorithm.compute("zgh").get should equal ("skh") // php wrongly says sf
					Algorithm.compute("zghz").get should equal ("shs") // php wrongly says sfs
					Algorithm.compute("zgha").get should equal ("sh") // php wrongly says sf others wrongly say skh
					Algorithm.compute("zgn").get should equal ("sn")
					Algorithm.compute("zgns").get should equal ("skns")
					Algorithm.compute("zgned").get should equal ("snt") // others wrongly says sknt
					Algorithm.compute("zgneds").get should equal ("sknts") // php wrongly says snts
					Algorithm.compute("zgi").get should equal ("sj")
					Algorithm.compute("zgiz").get should equal ("sjs")
					Algorithm.compute("zge").get should equal ("sj")
					Algorithm.compute("zgez").get should equal ("sjs")
					Algorithm.compute("zgy").get should equal ("sj")
					Algorithm.compute("zgyz").get should equal ("sjs")
					Algorithm.compute("zgz").get should equal ("sks")

					// f
					Algorithm.compute("f").get should equal ("f")
					Algorithm.compute("zf").get should equal ("sf")
					Algorithm.compute("zfz").get should equal ("sfs")

					// e
					Algorithm.compute("e").get should equal ("e")
					Algorithm.compute("ze").get should equal ("s")

					// d
					Algorithm.compute("d").get should equal ("t")
					Algorithm.compute("fudge").get should equal ("fjj") // php wrongly says fj
					Algorithm.compute("dodgy").get should equal ("tjj") // php wrongly says tj others wrongly say tjjy
					Algorithm.compute("dodgi").get should equal ("tjj") // php wrongly says tj
					Algorithm.compute("zd").get should equal ("st")
					Algorithm.compute("zdz").get should equal ("sts")

					// c
					Algorithm.compute("c").get should equal ("k")
					Algorithm.compute("zcia").get should equal ("sx")
					Algorithm.compute("zciaz").get should equal ("sxs")
					Algorithm.compute("zch").get should equal ("sx")
					Algorithm.compute("zchz").get should equal ("sxs")
					Algorithm.compute("zci").get should equal ("ss")
					Algorithm.compute("zciz").get should equal ("sss")
					Algorithm.compute("zce").get should equal ("ss")
					Algorithm.compute("zcez").get should equal ("sss")
					Algorithm.compute("zcy").get should equal ("ss")
					Algorithm.compute("zcyz").get should equal ("sss")
					Algorithm.compute("zsci").get should equal ("ss")
					Algorithm.compute("zsciz").get should equal ("sss")
					Algorithm.compute("zsce").get should equal ("ss")
					Algorithm.compute("zscez").get should equal ("sss")
					Algorithm.compute("zscy").get should equal ("ss")
					Algorithm.compute("zscyz").get should equal ("sss")
					Algorithm.compute("zsch").get should equal ("sskh") // php wrongly says ssx
					Algorithm.compute("zc").get should equal ("sk")
					Algorithm.compute("zcz").get should equal ("sks")

					// b
					Algorithm.compute("b").get should equal ("b")
					Algorithm.compute("zb").get should equal ("sb")
					Algorithm.compute("zbz").get should equal ("sbs")
					Algorithm.compute("zmb").get should equal ("sm")

					// a
					Algorithm.compute("a").get should equal ("a")
					Algorithm.compute("za").get should equal ("s")

					// Miscellaneous.
					Algorithm.compute("dumb").get should equal ("tm")
					Algorithm.compute("smith").get should equal ("sm0")
					Algorithm.compute("school").get should equal ("skhl") // php wrongly says sxl
					Algorithm.compute("merci").get should equal ("mrs")
					Algorithm.compute("cool").get should equal ("kl")
					Algorithm.compute("aebersold").get should equal ("ebrslt")
					Algorithm.compute("gnagy").get should equal ("nj")
					Algorithm.compute("knuth").get should equal ("n0")
					Algorithm.compute("pniewski").get should equal ("nsk")
					Algorithm.compute("wright").get should equal ("rht") // php wrongly says rft
					Algorithm.compute("phone").get should equal ("fn")
					Algorithm.compute("aggregate").get should equal ("akrkt")
					Algorithm.compute("accuracy").get should equal ("akkrs")
					Algorithm.compute("encyclopedia").get should equal ("ensklpt")
					Algorithm.compute("honorificabilitudinitatibus").get should equal ("hnrfkblttnttbs")
					Algorithm.compute("antidisestablishmentarianism").get should equal ("anttsstblxmntrnsm")
				}
			}
		}
	}
	"MetaphoneAlgorithm companion object" should provide {
		"pass-through compute method" should returns {
			"same value as class" in {
				MetaphoneAlgorithm.compute("dumb").get should equal ("tm")
			}
		}
	}
}

object MetaphoneAlgorithmSpec {
	final private val Algorithm = MetaphoneAlgorithm()
}
