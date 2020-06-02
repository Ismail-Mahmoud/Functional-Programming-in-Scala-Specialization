class Poly(val terms: Map[Int, Int]) {

  def adjust(term: (Int, Int)): (Int, Int) = {
    val (exp, co) = term
    this.terms.get(exp) match {
      case None => (exp, co)
      case Some(co2) => (exp, co + co2)
    }
  }

  def + (that: Poly) = new Poly(this.terms ++ that.terms.map(adjust))

  override def toString: String =
    (for((exp, co) <- terms.toList.sorted.reverse) yield exp match {
      case 0 => co
      case 1 => co + "x"
      case _ => co + "x^" + exp
    }).mkString(" + ")
}

val a = new Poly(Map(1 -> 2, 3 -> 4, 5 -> 6))
val b = new Poly(Map(0 -> 3, 3 -> 7))
a + b