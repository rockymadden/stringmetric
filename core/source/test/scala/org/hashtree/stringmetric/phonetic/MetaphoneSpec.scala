package org.hashtree.stringmetric.phonetic

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class MetaphoneSpec extends ScalaTest {
	"Metaphone" should provide {
		"compute method" when passed {
			"empty argument" should returns {
				"None" in {
					Metaphone.compute("").isDefined should be (false)
				}
			}
			"non-phonetic argument" should returns {
				"None" in {
					Metaphone.compute("123").isDefined should be (false)
				}
			}
			"phonetic argument" should returns {
				"Some" in {
					// z
					Metaphone.compute("z").get should equal ("s")
					Metaphone.compute("zz").get should equal ("s")

					// y
					Metaphone.compute("zy").get should equal ("s")
					Metaphone.compute("zyz").get should equal ("ss")
					Metaphone.compute("zya").get should equal ("sy")

					// x
					Metaphone.compute("zx").get should equal ("sks")
					Metaphone.compute("zxz").get should equal ("skss")

					// w
					Metaphone.compute("zw").get should equal ("s")
					Metaphone.compute("zwz").get should equal ("ss")
					Metaphone.compute("zwa").get should equal ("sw")

					// v
					Metaphone.compute("zv").get should equal ("sf")
					Metaphone.compute("zvz").get should equal ("sfs")

					// t
					Metaphone.compute("ztiaz").get should equal ("sxs")
					Metaphone.compute("ztioz").get should equal ("sxs")
					Metaphone.compute("zthz").get should equal ("s0s")
					Metaphone.compute("ztchz").get should equal ("sxs")
					Metaphone.compute("ztz").get should equal ("sts")

					// s
					Metaphone.compute("zshz").get should equal ("sxs")
					Metaphone.compute("zsioz").get should equal ("sxs")
					Metaphone.compute("zsiaz").get should equal ("sxs")
					Metaphone.compute("zs").get should equal ("ss")
					Metaphone.compute("zsz").get should equal ("sss")

					// r
					Metaphone.compute("zr").get should equal ("sr")
					Metaphone.compute("zrz").get should equal ("srs")

					// q
					Metaphone.compute("zq").get should equal ("sk")
					Metaphone.compute("zqz").get should equal ("sks")

					// p
					Metaphone.compute("zph").get should equal ("sf")
					Metaphone.compute("zp").get should equal ("sp")
					Metaphone.compute("zpz").get should equal ("sps")

					// n
					Metaphone.compute("zn").get should equal ("sn")
					Metaphone.compute("znz").get should equal ("sns")

					// m
					Metaphone.compute("zm").get should equal ("sm")
					Metaphone.compute("zmz").get should equal ("sms")

					// l
					Metaphone.compute("zl").get should equal ("sl")
					Metaphone.compute("zlz").get should equal ("sls")

					// k
					Metaphone.compute("zck").get should equal ("sk")
					Metaphone.compute("zk").get should equal ("sk")

					// j
					Metaphone.compute("zj").get should equal ("sj")
					Metaphone.compute("zjz").get should equal ("sjs")

					// h
					Metaphone.compute("zh").get should equal ("sh") // php wrongly says s
					Metaphone.compute("zah").get should equal ("s")
					Metaphone.compute("zchh").get should equal ("sx")
					Metaphone.compute("ha").get should equal ("h")

					// g
					Metaphone.compute("zgh").get should equal ("skh") // php wrongly says sf
					Metaphone.compute("zghz").get should equal ("shs") // php wrongly says sfs
					Metaphone.compute("zgha").get should equal ("sh") // php wrongly says sf others wrongly say skh
					Metaphone.compute("zgn").get should equal ("sn")
					Metaphone.compute("zgns").get should equal ("skns")
					Metaphone.compute("zgned").get should equal ("snt") // others wrongly says sknt
					Metaphone.compute("zgneds").get should equal ("sknts") // php wrongly says snts
					Metaphone.compute("zgi").get should equal ("sj")
					Metaphone.compute("zgiz").get should equal ("sjs")
					Metaphone.compute("zge").get should equal ("sj")
					Metaphone.compute("zgez").get should equal ("sjs")
					Metaphone.compute("zgy").get should equal ("sj")
					Metaphone.compute("zgyz").get should equal ("sjs")
					Metaphone.compute("zg").get should equal ("sk")
					Metaphone.compute("zgz").get should equal ("sks")

					// f
					Metaphone.compute("zf").get should equal ("sf")
					Metaphone.compute("zfz").get should equal ("sfs")

					// d
					Metaphone.compute("fudge").get should equal ("fjj") // php wrongly says fj
					Metaphone.compute("dodgy").get should equal ("tjj") // php wrongly says tj others wrongly say tjjy
					Metaphone.compute("dodgi").get should equal ("tjj") // php wrongly says tj
					Metaphone.compute("zd").get should equal ("st")
					Metaphone.compute("zdz").get should equal ("sts")

					// c
					Metaphone.compute("zcia").get should equal ("sx")
					Metaphone.compute("zciaz").get should equal ("sxs")
					Metaphone.compute("zch").get should equal ("sx")
					Metaphone.compute("zchz").get should equal ("sxs")
					Metaphone.compute("zci").get should equal ("ss")
					Metaphone.compute("zciz").get should equal ("sss")
					Metaphone.compute("zce").get should equal ("ss")
					Metaphone.compute("zcez").get should equal ("sss")
					Metaphone.compute("zcy").get should equal ("ss")
					Metaphone.compute("zcyz").get should equal ("sss")
					Metaphone.compute("zsci").get should equal ("ss")
					Metaphone.compute("zsciz").get should equal ("sss")
					Metaphone.compute("zsce").get should equal ("ss")
					Metaphone.compute("zscez").get should equal ("sss")
					Metaphone.compute("zscy").get should equal ("ss")
					Metaphone.compute("zscyz").get should equal ("sss")
					Metaphone.compute("zsch").get should equal ("sskh") // php wrongly says ssx
					Metaphone.compute("zc").get should equal ("sk")
					Metaphone.compute("zcz").get should equal ("sks")

					// b
					Metaphone.compute("zb").get should equal ("sb")
					Metaphone.compute("zbz").get should equal ("sbs")
					Metaphone.compute("zmb").get should equal ("sm")

					// Miscellaneous.
					Metaphone.compute("dumb").get should equal ("tm")
					Metaphone.compute("smith").get should equal ("sm0")
					Metaphone.compute("school").get should equal ("skhl") // php wrongly says sxl
					Metaphone.compute("merci").get should equal ("mrs")
					Metaphone.compute("cool").get should equal ("kl")
					Metaphone.compute("aebersold").get should equal ("ebrslt")
					Metaphone.compute("gnagy").get should equal ("nj")
					Metaphone.compute("knuth").get should equal ("n0")
					Metaphone.compute("pniewski").get should equal ("nsk")
					Metaphone.compute("wright").get should equal ("rht") // php wrongly says rft
					Metaphone.compute("phone").get should equal ("fn")
					Metaphone.compute("aggregate").get should equal ("akrkt")
					Metaphone.compute("accuracy").get should equal ("akkrs")
					Metaphone.compute("encyclopedia").get should equal ("ensklpt")
					Metaphone.compute("honorificabilitudinitatibus").get should equal ("hnrfkblttnttbs")
					Metaphone.compute("antidisestablishmentarianism").get should equal ("anttsstblxmntrnsm")
				}
			}
		}
	}
}