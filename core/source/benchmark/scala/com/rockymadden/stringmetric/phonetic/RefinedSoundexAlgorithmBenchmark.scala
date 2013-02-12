package com.rockymadden.stringmetric.phonetic

import com.google.caliper.Param
import com.rockymadden.stringmetric.{ CaliperBenchmark, CaliperRunner }
import scala.util.Random

final class RefinedSoundexAlgorithmBenchmark extends CaliperBenchmark {
	import RefinedSoundexAlgorithmBenchmark._

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

object RefinedSoundexAlgorithmBenchmark extends CaliperRunner(classOf[RefinedSoundexAlgorithmBenchmark]) {
	private final val Algorithm = new RefinedSoundexAlgorithm
}
