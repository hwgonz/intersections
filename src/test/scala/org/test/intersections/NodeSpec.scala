package org.test.intersections

class NodeSpec extends munit.FunSuite {

  test("Gets a correct Node from a correct input short intersection") {
    assertEquals(Node.toNode("a1"), Some(Node("A", "1")))
  }

  test("Gets a correct Node from a correct input street ending with 0") {
    assertEquals(Node.toNode("a10"), Some(Node("A", "10")))
  }

  test("Gets an empty Node from an incorrect input street") {
    assertEquals(Node.toNode("a1a"),  None)
  }

  test("Gets an empty Node from an incorrect input street starting with 0") {
    assertEquals(Node.toNode("a02"),  None)
  }

  test("Gets an empty Node from an incorrect input avenue and street") {
    assertEquals(Node.toNode("11a"),  None)
  }

  test("Gets an empty Node from an incorrect input avenue") {
    assertEquals(Node.toNode("210"),  None)
  }

}
