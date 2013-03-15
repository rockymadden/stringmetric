package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.similarity._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class ConfigurableStringAlgorithmSpec extends ScalaTest {
	"StringAlgorithm standalone object" should provide {
		"compute method, type, and companion object pass-throughs" in {
			val nGram: ConfigurableStringAlgorithm.NGram = ConfigurableStringAlgorithm.NGram()

			nGram.compute("testone")(1).get should
				equal (ConfigurableStringAlgorithm.computeWithNGram("testone")(1).get)
			nGram.compute("testone".toCharArray)(1).get should
				equal (ConfigurableStringAlgorithm.computeWithNGram("testone".toCharArray)(1).get)
			nGram.compute("testone".toCharArray)(1).get should
				equal (NGramAlgorithm.compute("testone".toCharArray)(1).get)
		}
	}
}


