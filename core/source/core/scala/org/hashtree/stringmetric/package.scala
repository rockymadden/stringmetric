package org.hashtree

/** Provides core string metric functionality. */
package object stringmetric {
	type CompareTuple = Tuple2[Array[Char], Array[Char]]

	type MatchTuple = CompareTuple

	implicit val stringCleaner = new StringCleanerDelegate with CaseStringCleaner with SpaceStringCleaner
}