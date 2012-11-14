package org.hashtree.stringmetric

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.FilterableConfigurableAlgorithm]]. */
trait FilterableConfigurableStringAlgorithm[O] extends
	FilterableConfigurableAlgorithm[String, O, StringFilter] with StringAlgorithm {

	def compute(charArray: Array[Char])(o: O)(implicit stringFilter: StringFilter): Option[Array[_]]
}