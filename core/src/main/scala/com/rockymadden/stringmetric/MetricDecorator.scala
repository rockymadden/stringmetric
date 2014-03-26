package com.rockymadden.stringmetric

import scala.collection.immutable.Map

sealed trait MetricDecorator[A, B] {
	val withMemoization: Metric[A, B]

	val withTransform: (Transform[A] => Metric[A, B])
}

final case class StringMetricDecorator[A](sm: StringMetric[A]) extends MetricDecorator[Array[Char], A] {
	override val withMemoization: StringMetric[A] = new StringMetric[A] {
		private val base: StringMetric[A] = sm
		private var memo: Map[(String, String), Option[A]] = Map()

		override def compare(a: Array[Char], b: Array[Char]): Option[A] = compare(a.toString, b.toString)

		override def compare(a: String, b: String): Option[A] = {
			val t = (a, b)

			if (memo.contains(t)) memo(t)
			else {
				memo = memo + (t -> base.compare(a, b))
				memo(t)
			}
		}
	}

	override val withTransform: (StringTransform => StringMetric[A]) = (st) => new StringMetric[A] {
		private val base: StringMetric[A] = sm
		private val transform: StringTransform = st

		override def compare(a: Array[Char], b: Array[Char]): Option[A] = base.compare(transform(a), transform(b))

		override def compare(a: String, b: String): Option[A] = compare(a.toCharArray, b.toCharArray)
	}
}
