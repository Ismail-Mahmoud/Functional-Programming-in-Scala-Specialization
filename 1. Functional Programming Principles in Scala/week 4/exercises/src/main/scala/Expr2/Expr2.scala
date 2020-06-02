package Expr2

object Main extends App {
  def e = new Add(new Num(3), new Num(4))
  println(e.eval)
}

trait Expr {
  def eval: Int
}

class Num(n: Int) extends Expr {
  def eval: Int = n
}

class Add(l: Expr, r: Expr) extends Expr {
  def eval: Int = l.eval + r.eval
}
