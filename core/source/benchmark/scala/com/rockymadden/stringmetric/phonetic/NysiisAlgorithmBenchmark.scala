package com.rockymadden.stringmetric.phonetic

import com.google.caliper.Param
import com.rockymadden.stringmetric.{ CaliperBenchmark, CaliperRunner, StringFilter }
import scala.util.Random

final class NysiisAlgorithmBenchmark extends CaliperBenchmark {
	import NysiisAlgorithmBenchmark.Algorithm

	@Param(Array("0", "1", "2", "4", "8", "16"))
	var length: Int = _

	var string: String = _
	var charArray: Array[Char] = _

	override protected def setUp() {
		string = Random.alphanumeric.filter(_ > '9').take(length).mkString
		charArray = string.toCharArray
	}

	def timeComputeWithCharArray(reps: Int) = run(reps) {
		Algorithm.compute(charArray)
	}

	def timeComputeWithString(reps: Int) = run(reps) {
		Algorithm.compute(string)
	}
}

object NysiisAlgorithmBenchmark extends CaliperRunner(classOf[NysiisAlgorithmBenchmark]) {
	private final val Algorithm = NysiisAlgorithm()
}
