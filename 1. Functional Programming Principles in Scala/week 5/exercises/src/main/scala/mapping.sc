def squareList1(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList1(ys)
  }

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x * x)

val lst = List(-1, 2, 5)

squareList1(lst)
squareList2(lst)

lst.map(x => x * 2)
lst.map(_ * 2)
