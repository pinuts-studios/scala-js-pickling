package org.scalajs.spickling
package test

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{ literal => lit }

import utest._

object PrimitivePicklersTest extends PicklersTest {

  val tests = TestSuite {
    "pickle a Boolean" - {
      expectPickleEqual(
          true,
          true)
    }

    "unpickle a Boolean" - {
      expectUnpickleEqual(
          true,
          true)
    }

    "pickle an Int" - {
      expectPickleEqual(
          42,
          42)
    }

    "unpickle an Int" - {
      expectUnpickleEqual(
          42,
          42)
    }

    "pickle a Long" - {
      expectPickleEqual(
          42L,
          lit(l = 42, m = 0, h = 0))
    }

    "unpickle a Long" - {
      expectUnpickleEqual(
          lit(l = 42, m = 0, h = 0),
          42L)
    }

    "pickle a String" - {
      expectPickleEqual(
          "hello",
          "hello")
    }

    "unpickle a String" - {
      expectUnpickleEqual(
          "hello",
          "hello")
    }

    "pickle null" - {
      expectPickleEqual(null, null)
    }

    "unpickle null" - {
      expectUnpickleEqual(null, null)
    }
  }
}
