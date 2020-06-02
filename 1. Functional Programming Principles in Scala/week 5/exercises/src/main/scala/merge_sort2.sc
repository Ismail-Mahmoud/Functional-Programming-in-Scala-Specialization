def merge[T](a: List[T], b: List[T])(ord: Ordering[T]): List[T] = (a, b) match {
  case (a, Nil) => a
  case (Nil, b) => b
  case (ah :: at, bh :: bt) => {
    if(ord.lt(ah, bh)) ah :: merge(at, b)(ord)
    else bh :: merge(a, bt)(ord)
  }
}

def sort[T](lst: List[T])(ord: Ordering[T]): List[T] = {
  val m = lst.length / 2
  if(m == 0) lst
  else {
    val (l, r) = lst.splitAt(m)
    merge(sort(l)(ord), sort(r)(ord))(ord)
  }
}

val lst = List(9, -1, 2, 8, 4)
val lst2 = List("ali", "karam", "ahmed", "ziad", "samir")
sort(lst)(Ordering.Int)
sort(lst2)(Ordering.String)