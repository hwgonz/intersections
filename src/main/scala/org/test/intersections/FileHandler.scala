package org.test.intersections

import cats.effect.{IO, Resource}
import scala.io.{BufferedSource, Source}

object FileHandler {

  def getFile(name: String): Resource[IO, BufferedSource] = Resource.make { IO(Source.fromFile(name)) } { file: BufferedSource => IO(file.close()) }

}
