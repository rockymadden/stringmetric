package com.rockymadden

package object stringmetric {
	import scala.language.implicitConversions
	import com.rockymadden.stringmetric.Algorithm._
	import com.rockymadden.stringmetric.Metric._

	type CompareTuple[T] = (Array[T], Array[T])
	type MatchTuple[T] = (Array[T], Array[T])

	implicit def stringToCharArray(s: String): Array[Char] =
		s.toCharArray
	implicit def stringAlgorithmToDecoratedStringAlgorithm(sa: StringAlgorithm): StringAlgorithmDecorator =
		new StringAlgorithmDecorator(sa)
	implicit def stringMetricToDecoratedStringMetric[A](sa: StringMetric[A]): StringMetricDecorator[A] =
		new StringMetricDecorator[A](sa)
}
