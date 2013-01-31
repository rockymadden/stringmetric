package com.rockymadden.stringmetric.cli

import com.rockymadden.stringmetric.ScalaTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
final class OptionMapTypeSpec extends ScalaTest {
	"OptionMapArray" should provide {
		"parse method" when passed {
			"invalid argument" should returns {
				"empty Array" in {
					OptionMapArray("").parse should equal (Array.empty[String])

					(OptionMapArray(""): Array[String]) should equal (Array.empty[String])
				}
			}
			"valid argument" should returns {
				"Array" in {
					OptionMapArray("1").parse should equal (Array("1"))

					OptionMapArray("1 2 3").parse should equal (Array("1", "2", "3"))

					(OptionMapArray("1 2 3"): Array[String]) should equal (Array("1", "2", "3"))
				}
			}
		}
	}
	"OptionMapBigDecimal" should provide {
		"parse method" when passed {
			"invalid argument" should throws {
				"NumberFormatException" in {
					evaluating {
						OptionMapBigDecimal("").parse
					} should produce[NumberFormatException]

					evaluating {
						OptionMapBigDecimal("one").parse
					} should produce[NumberFormatException]

					evaluating {
						(OptionMapBigDecimal("one"): BigDecimal)
					} should produce[NumberFormatException]
				}
			}
			"valid argument" should returns {
				"BigDecimal" in {
					OptionMapBigDecimal("1").parse should equal (1: BigDecimal)

					(OptionMapBigDecimal("1"): BigDecimal) should equal (1: BigDecimal)
				}
			}
		}
	}
	"OptionMapBigInt" should provide {
		"parse method" when passed {
			"invalid argument" should throws {
				"NumberFormatException" in {
					evaluating {
						OptionMapBigInt("").parse
					} should produce[NumberFormatException]

					evaluating {
						OptionMapBigInt("one").parse
					} should produce[NumberFormatException]

					evaluating {
						(OptionMapBigInt("one"): BigInt)
					} should produce[NumberFormatException]
				}
			}
			"valid argument" should returns {
				"BigInt" in {
					OptionMapBigInt("1").parse should equal (1: BigInt)

					(OptionMapBigInt("1"): BigInt) should equal (1: BigInt)
				}
			}
		}
	}
	"OptionMapDouble" should provide {
		"parse method" when passed {
			"invalid argument" should throws {
				"NumberFormatException" in {
					evaluating {
						OptionMapDouble("").parse
					} should produce[NumberFormatException]

					evaluating {
						OptionMapDouble("one").parse
					} should produce[NumberFormatException]

					evaluating {
						(OptionMapDouble("one"): Double)
					} should produce[NumberFormatException]
				}
			}
			"valid argument" should returns {
				"Double" in {
					OptionMapDouble("1").parse should equal (1d)

					(OptionMapDouble("1"): Double) should equal (1d)
				}
			}
		}
	}
	"OptionMapFloat" should provide {
		"parse method" when passed {
			"invalid argument" should throws {
				"NumberFormatException" in {
					evaluating {
						OptionMapFloat("").parse
					} should produce[NumberFormatException]

					evaluating {
						OptionMapFloat("one").parse
					} should produce[NumberFormatException]

					evaluating {
						(OptionMapFloat("one"): Float)
					} should produce[NumberFormatException]
				}
			}
			"valid argument" should returns {
				"Float" in {
					OptionMapFloat("1").parse should equal (1f)

					(OptionMapFloat("1"): Float) should equal (1f)
				}
			}
		}
	}
	"OptionMapInt" should provide {
		"parse method" when passed {
			"invalid argument" should returns {
				"NumberFormatException" in {
					evaluating {
						OptionMapInt("").parse
					} should produce[NumberFormatException]

					evaluating {
						OptionMapInt("one").parse
					} should produce[NumberFormatException]

					evaluating {
						(OptionMapInt("one"): Int)
					} should produce[NumberFormatException]
				}
			}
			"valid argument" should returns {
				"Int" in {
					OptionMapInt("1").parse should equal (1)

					(OptionMapInt("1"): Int) should equal (1)
				}
			}
		}
	}
	"OptionMapList" should provide {
		"parse method" when passed {
			"invalid argument" should returns {
				"empty List" in {
					OptionMapList("").parse should equal (List.empty[String])

					(OptionMapList(""): List[String]) should equal (List.empty[String])
				}
			}
			"valid argument" should returns {
				"List" in {
					OptionMapList("1").parse should equal (List("1"))

					OptionMapList("1 2 3").parse should equal (List("1", "2", "3"))

					(OptionMapList("1 2 3"): List[String]) should equal (List("1", "2", "3"))
				}
			}
		}
	}
	"OptionMapLong" should provide {
		"parse method" when passed {
			"invalid argument" should throws {
				"NumberFormatException" in {
					evaluating {
						OptionMapLong("").parse
					} should produce[NumberFormatException]

					evaluating {
						OptionMapLong("one").parse
					} should produce[NumberFormatException]

					evaluating {
						(OptionMapLong("one"): Long)
					} should produce[NumberFormatException]
				}
			}
			"valid argument" should returns {
				"Long" in {
					OptionMapLong("1").parse should equal (1l)

					(OptionMapLong("1"): Long) should equal (1l)
				}
			}
		}
	}
	"OptionMapShort" should provide {
		"parse method" when passed {
			"invalid argument" should throws {
				"NumberFormatException" in {
					evaluating {
						OptionMapShort("").parse
					} should produce[NumberFormatException]

					evaluating {
						OptionMapShort("one").parse
					} should produce[NumberFormatException]

					evaluating {
						(OptionMapShort("one"): Short)
					} should produce[NumberFormatException]
				}
			}
			"valid argument" should returns {
				"Short" in {
					OptionMapShort("1").parse should equal (1: Short)

					(OptionMapShort("1"): Short) should equal (1: Short)
				}
			}
		}
	}
}
