package org.hashtree.stringmetric

import com.google.caliper.{ Benchmark, Runner }

abstract class CaliperRunner(private[this] val suite: java.lang.Class[_ <: Benchmark]) {
	def main(args: Array[String]): Unit = Runner.main(suite, args)
}