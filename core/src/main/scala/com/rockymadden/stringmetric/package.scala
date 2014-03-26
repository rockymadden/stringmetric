package com.rockymadden

package object stringmetric {
	import scala.language.implicitConversions

	type CompareTuple[T] = (Array[T], Array[T])
	type MatchTuple[T] = (Array[T], Array[T])
	type StringTransform = Transform[Array[Char]]
	type Transform[A] = (A => A)

	implicit def stringToCharArray(s: String): Array[Char] = s.toCharArray
}
