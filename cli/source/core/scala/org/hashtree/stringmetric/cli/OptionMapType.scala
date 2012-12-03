package org.hashtree.stringmetric.cli

sealed abstract class OptionMapType[T](protected[this] val stringSelf: String) {
	def get(): Option[T]
}

final case class OptionMapArray(arrayString: String) extends OptionMapType[Array[String]](arrayString) {
	private[this] lazy val self = try {
		if (stringSelf.length == 0) None
		else Some(stringSelf.split(" "))
	} catch { case _ => None }

	override def get() = self
}

final case class OptionMapBigDecimal(bigDecimalString: String) extends OptionMapType[BigDecimal](bigDecimalString) {
	private[this] lazy val self = try { Some(BigDecimal(stringSelf)) } catch { case _ => None }

	override def get() = self
}

final case class OptionMapBigInt(bigIntString: String) extends OptionMapType[BigInt](bigIntString) {
	private[this] lazy val self = try { Some(BigInt(stringSelf)) } catch { case _ => None }

	override def get() = self
}

final case class OptionMapDouble(doubleString: String) extends OptionMapType[Double](doubleString) {
	private[this] lazy val self = try { Some(stringSelf.toDouble) } catch { case _ => None }

	override def get() = self
}

final case class OptionMapFloat(floatString: String) extends OptionMapType[Float](floatString) {
	private[this] lazy val self = try { Some(stringSelf.toFloat) } catch { case _ => None }

	override def get() = self
}

final case class OptionMapInt(intString: String) extends OptionMapType[Int](intString) {
	private[this] lazy val self = try { Some(stringSelf.toInt) } catch { case _ => None }

	override def get() = self
}

final case class OptionMapList(listString: String) extends OptionMapType[List[String]](listString) {
	private[this] lazy val self = try {
		if (stringSelf.length == 0) None
		else Some(stringSelf.split(" ").toList)
	} catch { case _ => None }

	override def get() = self
}

final case class OptionMapLong(longString: String) extends OptionMapType[Long](longString) {
	private[this] lazy val self = try { Some(stringSelf.toLong) } catch { case _ => None }

	override def get() = self
}

final case class OptionMapShort(shortString: String) extends OptionMapType[Short](shortString) {
	private[this] lazy val self = try { Some(stringSelf.toShort) } catch { case _ => None }

	override def get() = self
}

object OptionMapType {
	implicit def OptionMapTypeToString[T](optionMapType: OptionMapType[T]): String = optionMapType.get.map(_.toString).get

	implicit def OptionMapTypeToOptionT[T](optionMapType: OptionMapType[T]): Option[T] = optionMapType.get

	implicit def OptionMapTypeToT[T](optionMapType: OptionMapType[T]): T = optionMapType.get.get

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