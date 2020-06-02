// ci = ai * bi
def scalarProduct(a: Vector[Int], b: Vector[Int]): Int = {
  val pairs = a.zip(b)
  //pairs.map(xy => xy._1 * xy._2).sum
  pairs.map{case(x, y) => x * y}.sum  // pattern matching function value
  //pairs.map(xy => xy match {case (x, y) => x * y}).sum
}
scalarProduct(Vector(1, 2, 3), Vector(2, 0, 4))

// The function value {case p1 => e1 ... case pn => en}
// is equivalent to x => x match {case p1 => e1 ... case pn => en}