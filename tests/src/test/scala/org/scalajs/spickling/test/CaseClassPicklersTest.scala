package org.scalajs.spickling
package test

import scala.annotation.meta.{getter, field}
import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => lit}
import annotations.SerializedName

import utest._

case class Person(name: String, age: Int, smokes: Boolean, cat: Cat)

case class Cat(name: String, likeDogs: Boolean)

case class Dog(@SerializedName("toto") dogName: String)

case object TrivialCaseObject

object CaseClassPicklersTest extends PicklersTest {

  PicklerRegistry.register[Person]
  PicklerRegistry.register[Cat]
  PicklerRegistry.register[Dog]
  PicklerRegistry.register(TrivialCaseObject)

  val tests = TestSuite {
    "pickle a Person" - {
      expectPickleEqual(
        Person("Jack", 24, smokes = false, Cat("Bobby", likeDogs = false)),
        lit(name = "Jack",
          age = 24,
          smokes = false,
          cat = lit(
            name = "Bobby",
            likeDogs = false
          )))
    }

    "unpickle a Person" - {
      expectUnpickleEqual(
        lit(name = "Jack",
          age = 24,
          smokes = false,
          cat = lit(
            name = "Bobby",
            likeDogs = false
          )),
        Person("Jack", 24, smokes = false, Cat("Bobby", likeDogs = false)))
    }

    "pickle a Dog" - {
      expectPickleEqual(
        Dog("tobby"),
        lit(toto = "tobby")
      )
    }

    "unpickle a Dog" - {
      expectUnpickleEqual(
        lit(toto = "tobby"),
        Dog("tobby")
      )
    }

    "pickle TrivialCaseObject" - {
      expectPickleEqual(
        TrivialCaseObject,
        lit(s = "org.scalajs.spickling.test.TrivialCaseObject$"))
    }

    "unpickle TrivialCaseObject" - {
      expectUnpickleEqual(
        lit(s = "org.scalajs.spickling.test.TrivialCaseObject$"),
        TrivialCaseObject)
    }
  }
}
