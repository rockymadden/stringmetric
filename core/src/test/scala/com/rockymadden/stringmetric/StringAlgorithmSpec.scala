package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic._
import com.rockymadden.stringmetric.transform._

object StringAlgorithmSpec extends org.specs2.mutable.Specification {
	"StringAlgorithm convenience methods" should {
		"pass through" in {
			StringAlgorithm.computeWithMetaphone("testone").get must
				beEqualTo(MetaphoneAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithNysiis("testone").get must
				beEqualTo(NysiisAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithRefinedNysiis("testone").get must
				beEqualTo(RefinedNysiisAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithRefinedSoundex("testone").get must
				beEqualTo(RefinedSoundexAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithSoundex("testone").get must
				beEqualTo(SoundexAlgorithm.compute("testone".toCharArray).get)
		}
	}

	"StringAlgorithmDecorator withMemoization()" should {
		"memoize" in {
			val memo = MetaphoneAlgorithm withMemoization

			(0 until 1000000) foreach { i =>
				memo.compute("abc123")
				memo.compute("abc456")
			}

			true must beTrue
		}
	}

	"StringAlgorithmDecorator withTransform()" should {
		"transform" in {
			(MetaphoneAlgorithm withTransform filterAlpha).compute("abc123").get must
				beEqualTo(MetaphoneAlgorithm.compute("abc").get)
		}
	}
}
