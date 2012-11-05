package org.hashtree.stringmetric.cli

import scala.math.BigDecimal

/** Utility standalone for parse based operations. */
object ParseUtility {
	def parseBigDecimal(string: String): Option[BigDecimal] = try { Some(BigDecimal(string)) } catch { case _ => None }

	def parseDouble(string: String): Option[Double] = try { Some(string.toDouble) } catch { case _ => None }

	def parseFloat(string: String): Option[Float] = try { Some(string.toFloat) } catch { case _ => None }

	def parseInt(string: String): Option[Int] = try { Some(string.toInt) } catch { case _ => None }
}