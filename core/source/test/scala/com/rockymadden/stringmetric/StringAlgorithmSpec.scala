package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class StringAlgorithmSpec extends ScalaTest {
	"StringAlgorithm standalone object" should provide {
		"compute method, type, and companion object pass-throughs" in {
			val metaphone: StringAlgorithm.Metaphone = StringAlgorithm.Metaphone()

			metaphone.compute("testone").get should
				equal (StringAlgorithm.computeWithMetaphone("testone").get)
			metaphone.compute("testone".toCharArray).get should
				equal (StringAlgorithm.computeWithMetaphone("testone".toCharArray).get)
			metaphone.compute("testone".toCharArray).get should
				equal (MetaphoneAlgorithm.compute("testone".toCharArray).get)

			val nysiis: StringAlgorithm.Nysiis = StringAlgorithm.Nysiis()

			nysiis.compute("testone").get should
				equal (StringAlgorithm.computeWithNysiis("testone").get)
			nysiis.compute("testone".toCharArray).get should
				equal (StringAlgorithm.computeWithNysiis("testone".toCharArray).get)
			nysiis.compute("testone".toCharArray).get should
				equal (NysiisAlgorithm.compute("testone".toCharArray).get)

			val refinedNysiis: StringAlgorithm.RefinedNysiis = StringAlgorithm.RefinedNysiis()

			refinedNysiis.compute("testone").get should
				equal (StringAlgorithm.computeWithRefinedNysiis("testone").get)
			refinedNysiis.compute("testone".toCharArray).get should
				equal (StringAlgorithm.computeWithRefinedNysiis("testone".toCharArray).get)
			refinedNysiis.compute("testone".toCharArray).get should
				equal (RefinedNysiisAlgorithm.compute("testone".toCharArray).get)

			val refinedSoundex: StringAlgorithm.RefinedSoundex = StringAlgorithm.RefinedSoundex()

			refinedSoundex.compute("testone").get should
				equal (StringAlgorithm.computeWithRefinedSoundex("testone").get)
			refinedSoundex.compute("testone".toCharArray).get should
				equal (StringAlgorithm.computeWithRefinedSoundex("testone".toCharArray).get)
			refinedSoundex.compute("testone".toCharArray).get should
				equal (RefinedSoundexAlgorithm.compute("testone".toCharArray).get)

			val soundex: StringAlgorithm.Soundex = StringAlgorithm.Soundex()

			soundex.compute("testone").get should
				equal (StringAlgorithm.computeWithSoundex("testone").get)
			soundex.compute("testone".toCharArray).get should
				equal (StringAlgorithm.computeWithSoundex("testone".toCharArray).get)
			soundex.compute("testone".toCharArray).get should
				equal (SoundexAlgorithm.compute("testone".toCharArray).get)
		}
	}
}


