package org.test.intersections

import cats.effect.{ExitCode, IO, IOApp}


import scala.io.StdIn.readLine

object Intersections extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = for {
    _ <- IO(println("Input File [Enter to indicate default sample-data.json]:"))
    maybeFile <- IO(readLine())
    file <- IO(if (maybeFile.isEmpty) "sample-data.json" else maybeFile)
    inputData <- FileHandler.getFile(file).use { file =>
      IO(file.getLines().mkString)
    }
    _ <- IO(println("Enter start intersection:"))
    sourceNode <- IO(readLine())
    //_ <- IO(println(s"Source node is ${Node.toNode(sourceNode)}"))
    _ <- IO(println("Enter end intersection:"))
    endNode <- IO(readLine())
    //_ <- IO(println(s"End node is ${Node.toNode(endNode)}"))
    output <- Processor.processData(inputData, sourceNode, endNode)
    _ <- output match {
      case Left(err) => IO(Left(err))
      case Right(value) => IO(println(s"Total transit time is ${value._1}")) *> IO(println(s"Shortest path is ${value._2}"))
    }
  } yield ExitCode.Success

}
