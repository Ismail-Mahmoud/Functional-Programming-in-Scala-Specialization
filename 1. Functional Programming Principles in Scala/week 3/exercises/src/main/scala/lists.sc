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

def nth[T](n: Int, lst: List[T]): T = {
  if(lst.isEmpty) throw new IndexOutOfBoundsException
  else if(n == 0) lst.head
  else nth(n - 1, lst.tail)
}

object List {

}

val lst = new Cons(1, new Cons(2, new Cons(3, new Nil)))
nth(1, lst)
//nth(-1, lst)
nth(4, lst)