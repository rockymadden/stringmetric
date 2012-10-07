package org.hashtree.stringmetric.cli

/** Provides core command functionality. */
package object command {
	implicit val optionMap: OptionMap = OptionMapUtility.toOptionMap(Array("--unitTest=false"))
}