package org.hashtree.stringmetric.cli

/** Provides core phonetic CLI functionality. */
package object phonetic {
	implicit val optionMap: OptionMap = OptionMapUtility.toOptionMap(Array("--unitTest=false"))
}