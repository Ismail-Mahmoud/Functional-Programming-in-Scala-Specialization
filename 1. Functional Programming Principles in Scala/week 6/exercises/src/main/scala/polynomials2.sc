class Poly(val terms0: Map[Int, Int]) {
  def this(terms: (Int, Int)*) = this(terms.toMap)

  val terms = terms0.withDefaultValue(0)

  // zero-th element is this.terms (accumulate on it)
  def addTerm(curTerms: Map[Int, Int], newTerm: (Int, Int)): Map[Int, Int] = {
    val (exp, co) = newTerm
    curTerms + (exp -> (co + curTerms(exp)))
  }

  def + (that: Poly) = new Poly(that.terms.foldLeft(this.terms)(addTerm))

  override def toString: String =
    (for((exp, co) <- terms.toList.sorted.reverse) yield exp match {
      case 0 => co
      case 1 => co + "x"
      case _ => co + "x^" + exp
    }).mkString(" + ")
}

//val a = new Poly(Map(1 -> 2, 3 -> 4, 5 -> 6))
//val b = new Poly(Map(0 -> 3, 3 -> 7))
val a = new Poly(1 -> 2, 3 -> 4, 5 -> 6)
val b = new Poly(0 -> 3, 3 -> 7)
a + b
