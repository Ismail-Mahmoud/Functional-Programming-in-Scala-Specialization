package idealized.scala

abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, False)
  def || (x: => Boolean): Boolean = ifThenElse(True, x)
  def unary_! : Boolean = ifThenElse(False, True)

  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)
}

object True extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = t

  override def toString: String = "true"
}

object False extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = e

  override def toString: String = "false"
}