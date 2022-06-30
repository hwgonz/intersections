package org.test.intersections

import de.ummels.prioritymap.PriorityMap

//import scala.collection.mutable

object SearchGraph {

  type Graph[N] = N => Map[N, BigDecimal]

  def shortestPath[N](g: Graph[N])(source: N, target: N):
  (Option[BigDecimal], Option[List[N]]) = {
    val result = dijkstra3(g)(source)
    val pred = result._2
    val totalTime = result._1
    if (pred.contains(target) || source == target)
      (totalTime.get(target), Some(iterateRight(target)(pred.get)))
    else (None, None)
  }

  def getGraphFromTrafficMeasurement(trafficMeasurement: TrafficMeasurement): Graph[Node] = { node =>
    trafficMeasurement.measurements.filter(
      measurement => measurement.startAvenue == node.avenue &&
        measurement.startStreet == node.street)
      .map(measurement => (Node(measurement.endAvenue, measurement.endStreet), measurement.transitTime))
      .toMap
  }

  def iterateRight[N](x: N)(f: N => Option[N]): List[N] = {
    def go(x: N, acc: List[N]): List[N] = f(x) match {
      case None => x :: acc
      case Some(y) => go(y, x :: acc)
    }

    go(x, List.empty)
  }

  def dijkstra3[N](g: Graph[N])(source: N): (Map[N, BigDecimal], Map[N, N]) = {
    def go(active: PriorityMap[N, BigDecimal], res: Map[N, BigDecimal], pred: Map[N, N]):
    (Map[N, BigDecimal], Map[N, N]) =
      if (active.isEmpty) (res, pred)
      else {
        val (node, cost) = active.head
        val neighbours = for {
          (n, c) <- g(node) if !res.contains(n) &&
            cost + c < active.getOrElse(n, Int.MaxValue)
        } yield n -> (cost + c)
        val preds = neighbours mapValues (_ => node)
        go(active.tail ++ neighbours, res + (node -> cost), pred ++ preds)
      }

    go(PriorityMap(source -> 0), Map.empty, Map.empty)
  }

  /*private def dijkstra1[N](g: Graph[N])(source: N):
  (Map[N, BigDecimal], Map[N, N]) = {
    val active = mutable.Set(source)
    val res = mutable.Map(source -> BigDecimal(0))
    val pred = mutable.Map.empty[N, N]
    while (active.nonEmpty) {
      val node = active.minBy(res)
      active -= node
      val cost = res(node)
      for ((n, c) <- g(node)) {
        val cost1 = cost + c
        if (cost1 < res.getOrElse(n, Int.MaxValue)) {
          active += n
          res += (n -> cost1)
          pred += (n -> node)
        }
      }
    }
    (res.toMap, pred.toMap)
  }*/

}


