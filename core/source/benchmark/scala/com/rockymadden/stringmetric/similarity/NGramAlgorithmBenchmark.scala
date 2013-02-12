package com.rockymadden.stringmetric.similarity

import com.google.caliper.Param
import com.rockymadden.stringmetric.{ CaliperBenchmark, CaliperRunner }
import scala.util.Random

final class NGramAlgorithmBenchmark extends CaliperBenchmark {
	import NGramAlgorithmBenchmark._

	@Param(Array("0", "1", "2", "4", "8", "16"))
	var length: Int = _

	@Param(Array("2", "3"))
	var n: Int = _

	var string: String = _
	var charArray: Array[Char] = _

	override protected def setUp() {
		string = Random.alphanumeric.take(length).mkString
		charArray = string.toCharArray
	}

	def timeComputeWithCharArray(reps: Int) = run(reps) {
		Algorithm.compute(charArray)(n)
	}

	def timeComputeWithString(reps: Int) = run(reps) {
		Algorithm.compute(string)(n)
	}
}

object NGramAlgorithmBenchmark extends CaliperRunner(classOf[NGramAlgorithmBenchmark]) {
	private final val Algorithm = new NGramAlgorithm
}
