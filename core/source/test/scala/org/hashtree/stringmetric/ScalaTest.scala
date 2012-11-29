package org.hashtree.stringmetric

import org.scalatest.{ BeforeAndAfter, WordSpec }
import org.scalatest.matchers.ShouldMatchers

trait ScalaTest extends WordSpec with ShouldMatchers with BeforeAndAfter {
	def allows = afterWord("allow")

	def executes = afterWord("execute")

	def passed = afterWord("passed")

	def provide = afterWord("provide")

	def returns = afterWord("return")

	def throws = afterWord("throw")
}