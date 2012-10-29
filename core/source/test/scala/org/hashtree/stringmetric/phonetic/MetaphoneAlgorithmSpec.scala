package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class MetaphoneAlgorithmSpec extends ScalaTest {
	"MetaphoneAlgorithm" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					MetaphoneAlgorithm.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					MetaphoneAlgorithm.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// z
					MetaphoneAlgorithm.compute("z").get should equal ("s")
					MetaphoneAlgorithm.compute("zz").get should equal ("s")

					// y
					MetaphoneAlgorithm.compute("y").isDefined should be (false)
					MetaphoneAlgorithm.compute("zy").get should equal ("s")
					MetaphoneAlgorithm.compute("zyz").get should equal ("ss")
					MetaphoneAlgorithm.compute("zya").get should equal ("sy")

					// x
					MetaphoneAlgorithm.compute("x").get should equal ("s")
					MetaphoneAlgorithm.compute("zx").get should equal ("sks")
					MetaphoneAlgorithm.compute("zxz").get should equal ("skss")

					// w
					MetaphoneAlgorithm.compute("w").isDefined should be (false)
					MetaphoneAlgorithm.compute("zw").get should equal ("s")
					MetaphoneAlgorithm.compute("zwz").get should equal ("ss")
					MetaphoneAlgorithm.compute("zwa").get should equal ("sw")

					// v
					MetaphoneAlgorithm.compute("v").get should equal ("f")
					MetaphoneAlgorithm.compute("zv").get should equal ("sf")
					MetaphoneAlgorithm.compute("zvz").get should equal ("sfs")

					// u
					MetaphoneAlgorithm.compute("u").get should equal ("u")
					MetaphoneAlgorithm.compute("zu").get should equal ("s")

					// t
					MetaphoneAlgorithm.compute("t").get should equal ("t")
					MetaphoneAlgorithm.compute("ztiaz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("ztioz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("zthz").get should equal ("s0s")
					MetaphoneAlgorithm.compute("ztchz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("ztz").get should equal ("sts")

					// s
					MetaphoneAlgorithm.compute("s").get should equal ("s")
					MetaphoneAlgorithm.compute("zshz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("zsioz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("zsiaz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("zs").get should equal ("ss")
					MetaphoneAlgorithm.compute("zsz").get should equal ("sss")

					// r
					MetaphoneAlgorithm.compute("r").get should equal ("r")
					MetaphoneAlgorithm.compute("zr").get should equal ("sr")
					MetaphoneAlgorithm.compute("zrz").get should equal ("srs")

					// q
					MetaphoneAlgorithm.compute("q").get should equal ("k")
					MetaphoneAlgorithm.compute("zq").get should equal ("sk")
					MetaphoneAlgorithm.compute("zqz").get should equal ("sks")

					// p
					MetaphoneAlgorithm.compute("p").get should equal ("p")
					MetaphoneAlgorithm.compute("zp").get should equal ("sp")
					MetaphoneAlgorithm.compute("zph").get should equal ("sf")
					MetaphoneAlgorithm.compute("zpz").get should equal ("sps")

					// o
					MetaphoneAlgorithm.compute("o").get should equal ("o")
					MetaphoneAlgorithm.compute("zo").get should equal ("s")

					// n
					MetaphoneAlgorithm.compute("n").get should equal ("n")
					MetaphoneAlgorithm.compute("zn").get should equal ("sn")
					MetaphoneAlgorithm.compute("znz").get should equal ("sns")

					// m
					MetaphoneAlgorithm.compute("m").get should equal ("m")
					MetaphoneAlgorithm.compute("zm").get should equal ("sm")
					MetaphoneAlgorithm.compute("zmz").get should equal ("sms")

					// l
					MetaphoneAlgorithm.compute("l").get should equal ("l")
					MetaphoneAlgorithm.compute("zl").get should equal ("sl")
					MetaphoneAlgorithm.compute("zlz").get should equal ("sls")

					// k
					MetaphoneAlgorithm.compute("k").get should equal ("k")
					MetaphoneAlgorithm.compute("zk").get should equal ("sk")
					MetaphoneAlgorithm.compute("zck").get should equal ("sk")

					// j
					MetaphoneAlgorithm.compute("j").get should equal ("j")
					MetaphoneAlgorithm.compute("zj").get should equal ("sj")
					MetaphoneAlgorithm.compute("zjz").get should equal ("sjs")

					// i
					MetaphoneAlgorithm.compute("i").get should equal ("i")
					MetaphoneAlgorithm.compute("zi").get should equal ("s")

					// h
					MetaphoneAlgorithm.compute("h").get should equal ("h") // php wrongly says nothing
					MetaphoneAlgorithm.compute("zh").get should equal ("sh") // php wrongly says s
					MetaphoneAlgorithm.compute("zah").get should equal ("s")
					MetaphoneAlgorithm.compute("zchh").get should equal ("sx")
					MetaphoneAlgorithm.compute("ha").get should equal ("h")

					// g
					MetaphoneAlgorithm.compute("g").get should equal ("k")
					MetaphoneAlgorithm.compute("zg").get should equal ("sk")
					MetaphoneAlgorithm.compute("zgh").get should equal ("skh") // php wrongly says sf
					MetaphoneAlgorithm.compute("zghz").get should equal ("shs") // php wrongly says sfs
					MetaphoneAlgorithm.compute("zgha").get should equal ("sh") // php wrongly says sf others wrongly say skh
					MetaphoneAlgorithm.compute("zgn").get should equal ("sn")
					MetaphoneAlgorithm.compute("zgns").get should equal ("skns")
					MetaphoneAlgorithm.compute("zgned").get should equal ("snt") // others wrongly says sknt
					MetaphoneAlgorithm.compute("zgneds").get should equal ("sknts") // php wrongly says snts
					MetaphoneAlgorithm.compute("zgi").get should equal ("sj")
					MetaphoneAlgorithm.compute("zgiz").get should equal ("sjs")
					MetaphoneAlgorithm.compute("zge").get should equal ("sj")
					MetaphoneAlgorithm.compute("zgez").get should equal ("sjs")
					MetaphoneAlgorithm.compute("zgy").get should equal ("sj")
					MetaphoneAlgorithm.compute("zgyz").get should equal ("sjs")
					MetaphoneAlgorithm.compute("zgz").get should equal ("sks")

					// f
					MetaphoneAlgorithm.compute("f").get should equal ("f")
					MetaphoneAlgorithm.compute("zf").get should equal ("sf")
					MetaphoneAlgorithm.compute("zfz").get should equal ("sfs")

					// e
					MetaphoneAlgorithm.compute("e").get should equal ("e")
					MetaphoneAlgorithm.compute("ze").get should equal ("s")

					// d
					MetaphoneAlgorithm.compute("d").get should equal ("t")
					MetaphoneAlgorithm.compute("fudge").get should equal ("fjj") // php wrongly says fj
					MetaphoneAlgorithm.compute("dodgy").get should equal ("tjj") // php wrongly says tj others wrongly say tjjy
					MetaphoneAlgorithm.compute("dodgi").get should equal ("tjj") // php wrongly says tj
					MetaphoneAlgorithm.compute("zd").get should equal ("st")
					MetaphoneAlgorithm.compute("zdz").get should equal ("sts")

					// c
					MetaphoneAlgorithm.compute("c").get should equal ("k")
					MetaphoneAlgorithm.compute("zcia").get should equal ("sx")
					MetaphoneAlgorithm.compute("zciaz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("zch").get should equal ("sx")
					MetaphoneAlgorithm.compute("zchz").get should equal ("sxs")
					MetaphoneAlgorithm.compute("zci").get should equal ("ss")
					MetaphoneAlgorithm.compute("zciz").get should equal ("sss")
					MetaphoneAlgorithm.compute("zce").get should equal ("ss")
					MetaphoneAlgorithm.compute("zcez").get should equal ("sss")
					MetaphoneAlgorithm.compute("zcy").get should equal ("ss")
					MetaphoneAlgorithm.compute("zcyz").get should equal ("sss")
					MetaphoneAlgorithm.compute("zsci").get should equal ("ss")
					MetaphoneAlgorithm.compute("zsciz").get should equal ("sss")
					MetaphoneAlgorithm.compute("zsce").get should equal ("ss")
					MetaphoneAlgorithm.compute("zscez").get should equal ("sss")
					MetaphoneAlgorithm.compute("zscy").get should equal ("ss")
					MetaphoneAlgorithm.compute("zscyz").get should equal ("sss")
					MetaphoneAlgorithm.compute("zsch").get should equal ("sskh") // php wrongly says ssx
					MetaphoneAlgorithm.compute("zc").get should equal ("sk")
					MetaphoneAlgorithm.compute("zcz").get should equal ("sks")

					// b
					MetaphoneAlgorithm.compute("b").get should equal ("b")
					MetaphoneAlgorithm.compute("zb").get should equal ("sb")
					MetaphoneAlgorithm.compute("zbz").get should equal ("sbs")
					MetaphoneAlgorithm.compute("zmb").get should equal ("sm")

					// a
					MetaphoneAlgorithm.compute("a").get should equal ("a")
					MetaphoneAlgorithm.compute("za").get should equal ("s")

					// Miscellaneous.
					MetaphoneAlgorithm.compute("dumb").get should equal ("tm")
					MetaphoneAlgorithm.compute("smith").get should equal ("sm0")
					MetaphoneAlgorithm.compute("school").get should equal ("skhl") // php wrongly says sxl
					MetaphoneAlgorithm.compute("merci").get should equal ("mrs")
					MetaphoneAlgorithm.compute("cool").get should equal ("kl")
					MetaphoneAlgorithm.compute("aebersold").get should equal ("ebrslt")
					MetaphoneAlgorithm.compute("gnagy").get should equal ("nj")
					MetaphoneAlgorithm.compute("knuth").get should equal ("n0")
					MetaphoneAlgorithm.compute("pniewski").get should equal ("nsk")
					MetaphoneAlgorithm.compute("wright").get should equal ("rht") // php wrongly says rft
					MetaphoneAlgorithm.compute("phone").get should equal ("fn")
					MetaphoneAlgorithm.compute("aggregate").get should equal ("akrkt")
					MetaphoneAlgorithm.compute("accuracy").get should equal ("akkrs")
					MetaphoneAlgorithm.compute("encyclopedia").get should equal ("ensklpt")
					MetaphoneAlgorithm.compute("honorificabilitudinitatibus").get should equal ("hnrfkblttnttbs")
					MetaphoneAlgorithm.compute("antidisestablishmentarianism").get should equal ("anttsstblxmntrnsm")
				}
			}
		}
	}
}