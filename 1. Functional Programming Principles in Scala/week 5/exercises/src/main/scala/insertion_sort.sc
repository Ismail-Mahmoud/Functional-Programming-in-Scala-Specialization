def insert[T](lst: List[T], x: T)(implicit ord: Ordering[T]): List[T] = lst match {
  case Nil => List(x)
  case h :: t => {
    if(ord.lt(x, h)) x :: lst
    else h :: insert(t, x)
  }
}

def sort[T](lst: List[T])(implicit ord: Ordering[T]): List[T] = lst match {
  case Nil => List()
  case h :: t => insert(sort(t), h)
}

val lst = List(9, -1, 2, 8, 4)
val lst2 = List("ali", "karam", "ahmed", "ziad", "samir")
sort(lst)
sort(lst2)