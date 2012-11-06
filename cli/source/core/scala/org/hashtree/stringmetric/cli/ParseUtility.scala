package org.hashtree.stringmetric.cli

import scala.math.{ BigDecimal, BigInt }

/** Utility standalone for parse based operations. */
object ParseUtility {
	def parseBigDecimal(string: String): Option[BigDecimal] = try { Some(BigDecimal(string)) } catch { case _ => None }

	def parseBigInt(string: String): Option[BigInt] = try { Some(BigInt(string)) } catch { case _ => None }

	def parseDouble(string: String): Option[Double] = try { Some(string.toDouble) } catch { case _ => None }

	def parseFloat(string: String): Option[Float] = try { Some(string.toFloat) } catch { case _ => None }

	def parseInt(string: String): Option[Int] = try { Some(string.toInt) } catch { case _ => None }

	def parseLong(string: String): Option[Long] = try { Some(string.toLong) } catch { case _ => None }

	def parseShort(string: String): Option[Short] = try { Some(string.toShort) } catch { case _ => None }
}