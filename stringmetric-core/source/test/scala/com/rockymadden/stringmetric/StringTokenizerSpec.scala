package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.tokenization.NGramTokenizer
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class StringTokenizerSpec extends ScalaTest {
	"StringTokenizer standalone object" should provide {
		"tokenize method, type, and companion object pass-throughs" in {
			val nGram: StringTokenizer.NGram = StringTokenizer.NGram()

			nGram.tokenize("testone")(1).get should
				equal (StringTokenizer.tokenizeWithNGram("testone")(1).get)
			nGram.tokenize("testone".toCharArray)(1).get should
				equal (StringTokenizer.tokenizeWithNGram("testone".toCharArray)(1).get)
			nGram.tokenize("testone".toCharArray)(1).get should
				equal (NGramTokenizer.tokenize("testone".toCharArray)(1).get)
		}
	}
}


