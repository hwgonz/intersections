package org.test.intersections

import cats.effect.IO
import io.circe._
import io.circe.parser._

object Processor {

  def processData(data: String): IO[Either[Error,TrafficData]] = {
    IO(decode[TrafficData](data))
  }

}
