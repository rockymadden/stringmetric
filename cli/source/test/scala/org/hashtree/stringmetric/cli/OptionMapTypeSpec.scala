package org.hashtree.stringmetric.cli

import org.hashtree.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class OptionMapTypeSpec extends ScalaTest {
	"OptionMapArray" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapArray("").get.isDefined should be (false)

					(OptionMapArray(""): Option[Array[String]]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Array" in {
					OptionMapArray("1").get.get should equal (Array("1"))

					OptionMapArray("1 2 3").get.get should equal (Array("1", "2", "3"))

					(OptionMapArray("1 2 3"): Array[String]) should equal (Array("1", "2", "3"))
				}
			}
		}
	}
	"OptionMapBigDecimal" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapBigDecimal("").get.isDefined should be (false)

					OptionMapBigDecimal("one").get.isDefined should be (false)

					(OptionMapBigDecimal("one"): Option[BigDecimal]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"BigDecimal" in {
					OptionMapBigDecimal("1").get.get should equal (1: BigDecimal)

					(OptionMapBigDecimal("1"): BigDecimal) should equal (1: BigDecimal)
				}
			}
		}
	}
	"OptionMapBigInt" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapBigInt("").get.isDefined should be (false)

					OptionMapBigInt("one").get.isDefined should be (false)

					(OptionMapBigInt("one"): Option[BigInt]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"BigInt" in {
					OptionMapBigInt("1").get.get should equal (1: BigInt)

					(OptionMapBigInt("1"): BigInt) should equal (1: BigInt)
				}
			}
		}
	}
	"OptionMapDouble" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapDouble("").get.isDefined should be (false)

					OptionMapDouble("one").get.isDefined should be (false)

					(OptionMapDouble("one"): Option[Double]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Double" in {
					OptionMapDouble("1").get.get should equal (1d)

					(OptionMapDouble("1"): Double) should equal (1d)
				}
			}
		}
	}
	"OptionMapFloat" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapFloat("").get.isDefined should be (false)

					OptionMapFloat("one").get.isDefined should be (false)

					(OptionMapFloat("one"): Option[Float]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Float" in {
					OptionMapFloat("1").get.get should equal (1f)

					(OptionMapFloat("1"): Float) should equal (1f)
				}
			}
		}
	}
	"OptionMapInt" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapInt("").get.isDefined should be (false)

					OptionMapInt("one").get.isDefined should be (false)

					(OptionMapInt("one"): Option[Int]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Int" in {
					OptionMapInt("1").get.get should equal (1)

					(OptionMapInt("1"): Int) should equal (1)
				}
			}
		}
	}
	"OptionMapList" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapList("").get.isDefined should be (false)

					(OptionMapList(""): Option[List[String]]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"List" in {
					OptionMapList("1").get.get should equal (List("1"))

					OptionMapList("1 2 3").get.get should equal (List("1", "2", "3"))

					(OptionMapList("1 2 3"): List[String]) should equal (List("1", "2", "3"))
				}
			}
		}
	}
	"OptionMapLong" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapLong("").get.isDefined should be (false)

					OptionMapLong("one").get.isDefined should be (false)

					(OptionMapLong("one"): Option[Long]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Long" in {
					OptionMapLong("1").get.get should equal (1l)

					(OptionMapLong("1"): Long) should equal (1l)
				}
			}
		}
	}
	"OptionMapShort" should provide {
		"get method" when passed {
			"invalid argument" should returns {
				"None" in {
					OptionMapShort("").get.isDefined should be (false)

					OptionMapShort("one").get.isDefined should be (false)

					(OptionMapShort("one"): Option[Short]).isDefined should be (false)
				}
			}
			"valid argument" should returns {
				"Short" in {
					OptionMapShort("1").get.get should equal (1: Short)

					(OptionMapShort("1"): Short) should equal (1: Short)
				}
			}
		}
	}
}