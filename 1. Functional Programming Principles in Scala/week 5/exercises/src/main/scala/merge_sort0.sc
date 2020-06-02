def merge(a: List[Int], b: List[Int]): List[Int] = (a, b) match {
  case (a, Nil) => a
  case (Nil, b) => b
  case (ah :: at, bh :: bt) => {
    if(ah < bh) ah :: merge(at, b)
    else bh :: merge(a, bt)
  }
}

def sort(lst: List[Int]): List[Int] = {
  val m = lst.length / 2
  if(m == 0) lst
  else {
    val (l, r) = lst.splitAt(m)
    merge(sort(l), sort(r))
  }
}

val lst = List(9, -1, 2, 8, 4)
sort(lst)