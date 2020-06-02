def merge[T](a: List[T], b: List[T])(cmp: (T, T) => Boolean): List[T] = (a, b) match {
  case (a, Nil) => a
  case (Nil, b) => b
  case (ah :: at, bh :: bt) => {
    if(cmp(ah, bh)) ah :: merge(at, b)(cmp)
    else bh :: merge(a, bt)(cmp)
  }
}

def sort[T](lst: List[T])(cmp: (T, T) => Boolean): List[T] = {
  val m = lst.length / 2
  if(m == 0) lst
  else {
    val (l, r) = lst.splitAt(m)
    merge(sort(l)(cmp), sort(r)(cmp))(cmp)
  }
}

val lst = List(9, -1, 2, 8, 4)
val lst2 = List("ali", "karam", "ahmed", "ziad", "samir")
sort(lst)((x, y) => x < y)
sort(lst2)((x: String, y: String) => x.compareTo(y) < 0)