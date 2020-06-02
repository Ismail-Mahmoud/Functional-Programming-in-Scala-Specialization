package Expr1

/**
 * x.isInstanceOf[T]: Boolean   (check if x's type is T)
 * x.asInstanceOf[T]: T         (cast x's type to T)
 */

object Main extends App {
  def eval(e: Expr): Int = {
    if(e.isInstanceOf[Num]) e.asInstanceOf[Num].value
    else if(e.isInstanceOf[Add]) eval(e.asInstanceOf[Add].leftOp) + eval(e.asInstanceOf[Add].rightOp)
    else throw new Error("Unknown expression")
  }
  def e = new Add(new Num(2), new Num(3))
  println(eval(e))
}

trait Expr

class Num(n: Int) extends Expr {
  def value: Int = n
}

class Add(l: Expr, r: Expr) extends Expr {
  def leftOp: Expr = l
  def rightOp: Expr = r
}