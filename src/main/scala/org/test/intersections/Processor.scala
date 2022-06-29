package org.test.intersections

import cats.data.EitherT
import cats.effect.IO
import io.circe._
import io.circe.parser._

object Processor {

  def processData(data: String, source: String, end: String): IO[Either[Exception, (Option[BigDecimal],Option[List[Node]])]] =
    for {
      result <- IO(decode[TrafficData](data))
      process <- result match {
        case Left(err) => IO(Left(err))
        case Right(value) => {
          val averages = calculateAverages(value)
          val startNode = Node.toNode(source)
          val endNode = Node.toNode(end)
          (startNode, endNode) match {
            case (Some(start), Some(end)) => {
              val res = SearchGraph.shortestPath(SearchGraph.getGraphFromTrafficMeasurement(averages))(start, end)
              IO(println(s"Average transit times are: $averages")) *> IO(Right(res))
            }
            case _ => IO(Left(new Exception("Bad start or end nodes...")))
          }
        }
      }
    } yield process


  private def calculateAverages(data: TrafficData): TrafficMeasurement = {
    val numberOfMeasurements = data.trafficMeasurements.length
    val reducedMeasurement = data.trafficMeasurements.reduceLeft( (acc,current) =>
      combine(acc, current)
    )

    val result = averagedMeasurements(reducedMeasurement.measurements, numberOfMeasurements)

    reducedMeasurement.copy(measurements = result)
  }

  private def averagedMeasurements(measurements: List[Measurement], divisor: Int):List[Measurement] =
    measurements.map(measurement => measurement.copy( transitTime = measurement.transitTime / divisor))

  private def combine(first: TrafficMeasurement, second: TrafficMeasurement): TrafficMeasurement = 
    TrafficMeasurement(measurementTime = 0, measurements = combineMeasurements(first.measurements, second.measurements))
    
  private def combineMeasurements(first: List[Measurement], second: List[Measurement]): List[Measurement] =
    first.map { firstMeasurement =>
      val secondMeasurement = second.find(measurement =>
        (measurement.startAvenue == firstMeasurement.startAvenue) &&
          (measurement.startStreet == firstMeasurement.startStreet) &&
          (measurement.startAvenue == firstMeasurement.startAvenue) &&
          (measurement.endStreet == firstMeasurement.endStreet))
      firstMeasurement.copy( transitTime = firstMeasurement.transitTime +
        secondMeasurement.getOrElse(firstMeasurement.copy(transitTime = 0.00)).transitTime)
    }

  def getAllUniqueNodesFromMeasurement(trafficMeasurement: TrafficMeasurement): List[Node] =
    trafficMeasurement.measurements.flatMap { measurement =>
      List(Node(measurement.startAvenue, measurement.startStreet), Node(measurement.endAvenue, measurement.endStreet))
    }.distinct

}
