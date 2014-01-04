package com.rockymadden.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AlgorithmSpec extends ScalaTest {
	import phonetic._
	import Algorithm._
	import Transform._

	"StringAlgorithm" should provide {
		"compute method and companion object pass through" in {
			StringAlgorithm.computeWithMetaphone("testone").get should
				equal (MetaphoneAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithNysiis("testone").get should
				equal (NysiisAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithRefinedNysiis("testone").get should
				equal (RefinedNysiisAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithRefinedSoundex("testone").get should
				equal (RefinedSoundexAlgorithm.compute("testone".toCharArray).get)
			StringAlgorithm.computeWithSoundex("testone").get should
				equal (SoundexAlgorithm.compute("testone".toCharArray).get)
		}
	}

	"StringAlgorithmDecorator" should provide {
		"withMemoization()" in {
			val memo = MetaphoneAlgorithm withMemoization

			(0 until 1000000) foreach { i =>
				memo.compute("abc123")
				memo.compute("abc456")
			}
		}

		"withTransform()" in {
			(MetaphoneAlgorithm withTransform StringTransform.filterAlpha).compute("abc123").get should
				equal (MetaphoneAlgorithm.compute("abc").get)
		}
	}
}

