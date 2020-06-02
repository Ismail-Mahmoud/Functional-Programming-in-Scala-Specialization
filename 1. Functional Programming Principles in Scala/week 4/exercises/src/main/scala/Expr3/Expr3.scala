package Expr3

object Main extends App {
  /*
  def eval(e: Expr): Int = e match {
    case Num(n) => n
    case Add(l, r) => eval(l) + eval(r)
  }
  */
  def e = Add(Num(3), Add(Num(4), Num(5)))
  //println(eval(e))
  println(e.eval)
  println(e.show)
  def e1 = Add(Mul(Num(2), Var("x")), Var("y"))
  println(e1.show)
  def e2 = Mul(Add(Num(2), Var("x")), Var("y"))
  println(e2.show)
  def e3 = Add(Mul(e1, e2), e)
  println(e3.show)
}

trait Expr {
  def eval: Int = this match {
    case Num(n) => n
    case Add(l, r) => l.eval + r.eval
    case Mul(l, r) => l.eval * r.eval
  }
  def show: String = this match {
    case Num(n) => n.toString
    case Var(v) => v
    case Add(l, r) => l.show + " + " + r.show
    case Mul(l, r) => {
      (l match {
        case Add(_, _) => "(" + l.show + ")"
        case _ => l.show
      }) + " * " + (r match {
        case Add(_, _) => "(" + r.show + ")"
        case _ => r.show
      })
    }
  }
}
case class Num(n: Int) extends Expr
case class Var(v: String) extends Expr
case class Add(l: Expr, r: Expr) extends Expr
case class Mul(l: Expr, r: Expr) extends Expr
