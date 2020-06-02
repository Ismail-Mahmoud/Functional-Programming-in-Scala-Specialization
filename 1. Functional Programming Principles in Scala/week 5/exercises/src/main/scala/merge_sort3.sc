def merge[T](a: List[T], b: List[T])(implicit ord: Ordering[T]): List[T] = (a, b) match {
  case (a, Nil) => a
  case (Nil, b) => b
  case (ah :: at, bh :: bt) => {
    if(ord.lt(ah, bh)) ah :: merge(at, b)
    else bh :: merge(a, bt)
  }
}

def sort[T](lst: List[T])(implicit ord: Ordering[T]): List[T] = {
  val m = lst.length / 2
  if(m == 0) lst
  else {
    val (l, r) = lst.splitAt(m)
    merge(sort(l), sort(r))
  }
}

val lst = List(9, -1, 2, 8, 4)
val lst2 = List("ali", "karam", "ahmed", "ziad", "samir")
sort(lst)
sort(lst2)