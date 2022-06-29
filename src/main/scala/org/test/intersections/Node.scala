package org.test.intersections

case class Node (avenue: String, street: String)

case class DirectedEdge(from: Node, to: Node, transitTime: BigDecimal)

case class EdgeGraph(adjacent: Map[Node, List[DirectedEdge]] = Map.empty)

object Node {
  def toNode(value: String): Option[Node] = {
    val letterPattern = "([a-zA-Z])".r
    val numberPattern = "([1-9][0-9]?)".r
    val firstLetter = value.charAt(0) match {
      case letterPattern(c) => Some(c.toString.toUpperCase)
      case _ => None
    }
    val restNumber = value.substring(1) match {
      case numberPattern(n) => Some(n)
      case _ => None
    }
    (firstLetter,restNumber) match {
      case (Some(avenue), Some(street)) => Some(Node(avenue, street))
      case _ => None
    }
  }
}