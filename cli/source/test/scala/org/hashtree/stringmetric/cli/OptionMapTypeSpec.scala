package org.hashtree.stringmetric.cli

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class OptionMapTypeSpec extends ScalaTest {
	"OptionMapBigDecimal" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapBigDecimal("one").get.isDefined should be (false)

					(OptionMapBigDecimal("one"): Option[BigDecimal]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"BigDecimal" in {
					OptionMapBigDecimal("1").get.get should equal (1: BigDecimal)

					(OptionMapBigDecimal("1"): BigDecimal) should equal (1: BigDecimal)

					(OptionMapBigDecimal("1"): String) should equal ("1")
				}
			}
		}
	}
	"OptionMapBigInt" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapBigInt("one").get.isDefined should be (false)

					(OptionMapBigInt("one"): Option[BigInt]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"BigInt" in {
					OptionMapBigInt("1").get.get should equal (1: BigInt)

					(OptionMapBigInt("1"): BigInt) should equal (1: BigInt)

					(OptionMapBigInt("1"): String) should equal ("1")
				}
			}
		}
	}
	"OptionMapDouble" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapDouble("one").get.isDefined should be (false)

					(OptionMapDouble("one"): Option[Double]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Double" in {
					OptionMapDouble("1").get.get should equal (1d)

					(OptionMapDouble("1"): Double) should equal (1d)

					(OptionMapDouble("1"): String) should equal ("1.0")
				}
			}
		}
	}
	"OptionMapFloat" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapFloat("one").get.isDefined should be (false)

					(OptionMapFloat("one"): Option[Float]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Float" in {
					OptionMapFloat("1").get.get should equal (1f)

					(OptionMapFloat("1"): Float) should equal (1f)

					(OptionMapFloat("1"): String) should equal ("1.0")
				}
			}
		}
	}
	"OptionMapInt" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapInt("one").get.isDefined should be (false)

					(OptionMapInt("one"): Option[Int]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Int" in {
					OptionMapInt("1").get.get should equal (1)

					(OptionMapInt("1"): Int) should equal (1)

					(OptionMapInt("1"): String) should equal ("1")
				}
			}
		}
	}
	"OptionMapLong" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapLong("one").get.isDefined should be (false)

					(OptionMapLong("one"): Option[Long]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Long" in {
					OptionMapLong("1").get.get should equal (1l)

					(OptionMapLong("1"): Long) should equal (1l)

					(OptionMapLong("1"): String) should equal ("1")
				}
			}
		}
	}
	"OptionMapShort" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapShort("one").get.isDefined should be (false)

					(OptionMapShort("one"): Option[Short]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Short" in {
					OptionMapShort("1").get.get should equal (1: Short)

					(OptionMapShort("1"): Short) should equal (1: Short)

					(OptionMapShort("1"): String) should equal ("1")
				}
			}
		}
	}
}