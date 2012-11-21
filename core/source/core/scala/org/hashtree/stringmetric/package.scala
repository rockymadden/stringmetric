package org.hashtree

import org.hashtree.stringmetric.filter.StringFilterDelegate

/** Provides core string metric functionality. */
package object stringmetric {
	type CompareTuple[T] = Tuple2[Array[T], Array[T]]

	type MatchTuple[T] = Tuple2[Array[T], Array[T]]
}