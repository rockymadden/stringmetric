package com.rockymadden

package object stringmetric {
	import scala.language.implicitConversions

	type CompareTuple[T] = (Array[T], Array[T])
	type MatchTuple[T] = (Array[T], Array[T])

	implicit def stringToArrayOfChar(s: String): Array[Char] = s.toCharArray
}
