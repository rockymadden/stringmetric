package com.rockymadden.stringmetric

import com.google.caliper.SimpleBenchmark

trait CaliperBenchmark extends SimpleBenchmark {
	def run(reps: Int)(code: => Unit) = (0 until reps).foreach(i => code)
}