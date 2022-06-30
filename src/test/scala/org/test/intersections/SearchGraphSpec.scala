package org.test.intersections

class SearchGraphSpec extends munit.FunSuite {

  val trafficMeasurement = TrafficMeasurement(0, List(Measurement("A","1",35.3278998176010436,"B","1"),
    Measurement("A","2",58.3458807805108166,"A","1"), Measurement("A","2",38.7849603265828289,"B","2"),
    Measurement("A","3",64.361397489726342,"A","2"), Measurement("A","3",60.2756448439929533,"B","3"),
    Measurement("A","4",66.6753644834702202,"A","3"),Measurement("A","4",70.1541767448123434,"B","4"),
    Measurement("A","5",26.6792482625586695,"A","4"), Measurement("A","6",37.2709107628528414,"A","5"),
    Measurement("A","6",19.7177842261583412,"B","6"), Measurement("A","7",17.2889918219989839,"A","6"),
    Measurement("A", "5",26.2769558444569356,"B","5"), Measurement("B", "5", 31.6749255124334212,"B","4")))

  test("Gets an empty map when there's no connection between source and target intersections") {

    val startNode = Node("A", "1")
    val endNode = Node("B", "7")

    val result = SearchGraph.shortestPath(SearchGraph.getGraphFromTrafficMeasurement(trafficMeasurement))(startNode, endNode)

    assertEquals(result, (None, None))
  }

  test("Gets the right shortest path for a single route between the 2 intersections") {

    val startNode = Node("A", "3")
    val endNode = Node("B", "2")

    val result = SearchGraph.shortestPath(SearchGraph.getGraphFromTrafficMeasurement(trafficMeasurement))(startNode, endNode)

    assertEquals(result, (Some(BigDecimal("103.146357816309166")), Some(List(Node("A","3"), Node("A","2"), Node("B","2")))))
  }


  test("Gets the right shortest path when there are multiple routes between 2 intersections") {

    val startNode = Node("A", "6")
    val endNode = Node("B", "4")

    val result = SearchGraph.shortestPath(SearchGraph.getGraphFromTrafficMeasurement(trafficMeasurement))(startNode, endNode)

    assertEquals(result, (Some(BigDecimal("95.222792119743198")), Some(List(Node("A","6"), Node("A","5"), Node("B","5"),Node("B","4")))))
  }

}
