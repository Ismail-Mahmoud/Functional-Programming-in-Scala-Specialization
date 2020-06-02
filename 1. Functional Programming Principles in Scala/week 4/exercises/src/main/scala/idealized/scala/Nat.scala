package idealized.scala

object Main extends App {
  val x: Nat = Zero.successor.successor.successor   // 3
  val y = x.successor.successor.successor.successor // 7
  val z = Zero
  println(x, y, z)
  println(x.predecessor, y.predecessor.predecessor)
  println(x + y)
  println(y + x)
  println(y - x)
  println(x + z)
  println(x - z)
  //println(x - y)
  //println(z - x)
  println(x.isZero)
  println(z.isZero)
}

abstract class Nat {    // Natural numbers
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (x: Nat): Nat
  def - (x: Nat): Nat

  override def toString: String = this.isZero.ifThenElse("0", (1 + this.predecessor.toString.toInt).toString)
}

object Zero extends Nat {
  def isZero: Boolean = True
  def predecessor = throw new Error("Negative number")
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = that.isZero.ifThenElse(Zero, throw new Error("Negative number"))
}

class Succ(p: Nat) extends Nat {
  // this = Succ(p) = p + 1
  def isZero: Boolean = False
  def predecessor: Nat = p
  def + (that: Nat): Nat = new Succ(p + that)   // this + that = p + 1 + that = Succ(p + that)
  def - (that: Nat): Nat = that.isZero.ifThenElse(this, p - that.predecessor)  // 10 - 2 = 9 - 1 = 8 - 0
}
