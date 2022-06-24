package org.test.intersections

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder


case class Measurement(startAvenue: String, startStreet: String, transitTime: BigDecimal, endAvenue: String, endStreet: String)

case class TrafficMeasurement(measurementTime: Int, measurements: List[Measurement])

case class TrafficData(trafficMeasurements: List[TrafficMeasurement])

object TrafficData {

  implicit val decodeMeasurement: Decoder[Measurement] = deriveDecoder[Measurement]
  implicit val decodeTrafficMeasurement: Decoder[TrafficMeasurement] = deriveDecoder[TrafficMeasurement]
  implicit val decodeTrafficData: Decoder[TrafficData] = deriveDecoder[TrafficData]

}
