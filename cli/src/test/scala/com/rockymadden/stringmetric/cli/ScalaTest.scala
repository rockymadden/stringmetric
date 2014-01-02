package com.rockymadden.stringmetric.cli

import org.scalatest.{BeforeAndAfter, ParallelTestExecution, WordSpec}
import org.scalatest.matchers.ShouldMatchers

trait ScalaTest extends WordSpec with ShouldMatchers with BeforeAndAfter with ParallelTestExecution {
	def allows = afterWord("allow")

	def executes = afterWord("execute")

	def passed = afterWord("passed")

	def provide = afterWord("provide")

	def returns = afterWord("return")

	def throws = afterWord("throw")
}
