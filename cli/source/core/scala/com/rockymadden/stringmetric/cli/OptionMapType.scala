package com.rockymadden.stringmetric.cli

import scala.language.implicitConversions

sealed abstract class OptionMapType[T](protected[this] val stringSelf: String) {
	def parse: T
}

final case class OptionMapArray(arrayString: String) extends OptionMapType[Array[String]](arrayString) {
	private[this] lazy val self = if (stringSelf.length == 0) Array.empty[String] else stringSelf.split(" ")

	override def parse = self
}

final case class OptionMapBigDecimal(bigDecimalString: String) extends OptionMapType[BigDecimal](bigDecimalString) {
	private[this] lazy val self = BigDecimal(stringSelf)

	override def parse = self
}

final case class OptionMapBigInt(bigIntString: String) extends OptionMapType[BigInt](bigIntString) {
	private[this] lazy val self = BigInt(stringSelf)

	override def parse = self
}

final case class OptionMapDouble(doubleString: String) extends OptionMapType[Double](doubleString) {
	private[this] lazy val self = stringSelf.toDouble

	override def parse = self
}

final case class OptionMapFloat(floatString: String) extends OptionMapType[Float](floatString) {
	private[this] lazy val self = stringSelf.toFloat

	override def parse = self
}

final case class OptionMapInt(intString: String) extends OptionMapType[Int](intString) {
	private[this] lazy val self = stringSelf.toInt

	override def parse = self
}

final case class OptionMapList(listString: String) extends OptionMapType[List[String]](listString) {
	private[this] lazy val self = if (stringSelf.length == 0) List.empty[String] else stringSelf.split(" ").toList

	override def parse = self
}

final case class OptionMapLong(longString: String) extends OptionMapType[Long](longString) {
	private[this] lazy val self = stringSelf.toLong

	override def parse = self
}

final case class OptionMapShort(shortString: String) extends OptionMapType[Short](shortString) {
	private[this] lazy val self = stringSelf.toShort

	override def parse = self
}

object OptionMapType {
	implicit def OptionMapTypeToT[T](optionMapType: OptionMapType[T]): T = optionMapType.parse

	implicit def StringToOptionMapArray(string: String): OptionMapArray = new OptionMapArray(string)

	implicit def StringToOptionMapBigDecimal(string: String): OptionMapBigDecimal = new OptionMapBigDecimal(string)

	implicit def StringToOptionMapBigInt(string: String): OptionMapBigInt = new OptionMapBigInt(string)

	implicit def StringToOptionMapDouble(string: String): OptionMapDouble = new OptionMapDouble(string)

	implicit def StringToOptionMapFloat(string: String): OptionMapFloat = new OptionMapFloat(string)

	implicit def StringToOptionMapInt(string: String): OptionMapInt = new OptionMapInt(string)

	implicit def StringToOptionMapList(string: String): OptionMapList = new OptionMapList(string)

	implicit def StringToOptionMapLong(string: String): OptionMapLong = new OptionMapLong(string)

	implicit def StringToOptionMapShort(string: String): OptionMapShort = new OptionMapShort(string)
}
