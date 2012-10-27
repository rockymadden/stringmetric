package org.hashtree

/** Provides core string metric functionality. */
package object stringmetric {
	type CompareTuple[T] = Tuple2[Array[T], Array[T]]

	type MatchTuple[T] = Tuple2[Array[T], Array[T]]

	implicit val stringFilter = new StringFilterDelegate
}