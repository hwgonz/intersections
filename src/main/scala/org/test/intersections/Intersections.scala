package org.test.intersections

import cats.effect.{ExitCode, IO, IOApp}


import scala.io.StdIn.readLine

object Intersections extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = for {
    _ <- IO(println("Input File [Enter to indicate default sample-data.json]:"))
    maybeFile <- IO(readLine())
    file <- IO(if (maybeFile.isEmpty) "sample-data.json" else maybeFile)
    results <- FileHandler.getFile(file).use { file =>
      IO(file.getLines().mkString)
    }
    output <- Processor.processData(results)
    _ <- IO(println(s"You said $file"))
    _ <- IO(println(s"Ouput is $output"))
  } yield ExitCode.Success

}
