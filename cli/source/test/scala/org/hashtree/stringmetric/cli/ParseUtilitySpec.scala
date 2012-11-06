package org.hashtree.stringmetric.cli

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.math.{ BigDecimal, BigInt }

@RunWith(classOf[JUnitRunner])
final class ParseUtilitySpec extends ScalaTest {
	"ParseUtility" should provide {
		"parseBigDecimal method" when passed {
			"invalid argument" should returns {
				"None" in {
					ParseUtility.parseBigDecimal("one").isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Some(BigDecimal)" in {
					ParseUtility.parseBigDecimal("1").get should equal (BigDecimal(1))
				}
			}
		}
		"parseBigInt method" when passed {
			"invalid argument" should returns {
				"None" in {
					ParseUtility.parseBigInt("one").isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Some(BigInt)" in {
					ParseUtility.parseBigInt("1").get should equal (1: BigInt)
				}
			}
		}
		"parseDouble method" when passed {
			"invalid argument" should returns {
				"None" in {
					ParseUtility.parseDouble("one").isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Some(Double)" in {
					ParseUtility.parseDouble("1").get should be (1d)
				}
			}
		}
		"parseFloat method" when passed {
			"invalid argument" should returns {
				"None" in {
					ParseUtility.parseFloat("one").isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Some(Float)" in {
					ParseUtility.parseFloat("1").get should be (1f)
				}
			}
		}
		"parseInt method" when passed {
			"invalid argument" should returns {
				"None" in {
					ParseUtility.parseInt("one").isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Some(Int)" in {
					ParseUtility.parseInt("1").get should be (1)
				}
			}
		}
		"parseLong method" when passed {
			"invalid argument" should returns {
				"None" in {
					ParseUtility.parseLong("one").isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Some(Long)" in {
					ParseUtility.parseLong("1").get should be (1l)
				}
			}
		}
		"parseShort method" when passed {
			"invalid argument" should returns {
				"None" in {
					ParseUtility.parseShort("one").isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Some(Short)" in {
					ParseUtility.parseShort("1").get should equal (1: Short)
				}
			}
		}
	}
}