package org.scalajs.spickling

import scala.annotation.StaticAnnotation
import scala.annotation.meta.getter

object annotations {
  @getter
  class SerializedName(val name: String) extends StaticAnnotation
}
