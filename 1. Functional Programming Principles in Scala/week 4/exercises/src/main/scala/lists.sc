trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{
  def isEmpty: Boolean = false
  override def toString: String = head + " " + tail.toString
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  override def toString: String = ""
}

// A function call f(a, b), where f is a value of some class type
// is expanded to f.apply(a, b)
object List {
  def apply[T](): List[T] = new Nil
  def apply[T](a: T): List[T] = new Cons(a, new Nil)
  def apply[T](a: T, b: T): List[T] = new Cons(a, new Cons(b, new Nil))
}

List()
List(1)
List(2, 3)