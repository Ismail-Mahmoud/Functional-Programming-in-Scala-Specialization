package Expr0

object Main extends App {
  def eval(e: Expr): Int = {
    if(e.isNum) e.value
    else if(e.isAdd) eval(e.leftOp) + eval(e.rightOp)
    else throw new Error("Unknown expression")
  }
  def e = new Add(new Num(1), new Num(2))
  println(eval(e))
}

trait Expr {
  def isNum: Boolean
  def isAdd: Boolean
  def value: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Num(n: Int) extends Expr {
  def isNum: Boolean = true
  def isAdd: Boolean = false
  def value: Int = n
  def leftOp: Expr = throw new Error("Num.leftOp")
  def rightOp: Expr = throw new Error("Num.rightOp")
}

class Add(l: Expr, r: Expr) extends Expr {
  def isNum = false
  def isAdd = true
  def value: Int = throw new Error("Add.value")
  def leftOp: Expr = l
  def rightOp: Expr = r
}
