def scalarProduct(a: Vector[Int], b: Vector[Int]): Int = {
  val pairs = a.zip(b)
  (for((x, y) <- pairs) yield x * y).sum
}
scalarProduct(Vector(1, 2, 3), Vector(2, 0, 4))