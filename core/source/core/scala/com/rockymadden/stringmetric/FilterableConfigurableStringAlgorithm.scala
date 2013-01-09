package com.rockymadden.stringmetric

/**
 * Marks those which leverage traits of a string based [[com.rockymadden.stringmetric.FilterableConfigurableAlgorithm]].
 */
trait FilterableConfigurableStringAlgorithm[O]
	extends FilterableConfigurableAlgorithm[String, O, StringFilter] with StringAlgorithm {

	def compute(charArray: Array[Char])(o: O)(implicit stringFilter: StringFilter): Option[Array[_]]
}
