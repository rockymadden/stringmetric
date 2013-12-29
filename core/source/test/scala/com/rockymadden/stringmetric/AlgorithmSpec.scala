package com.rockymadden.stringmetric

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class AlgorithmSpec extends ScalaTest { "StringAlgorithm standalone object" should provide {
	import com.rockymadden.stringmetric.phonetic._
	import com.rockymadden.stringmetric.Algorithm._

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
}}

