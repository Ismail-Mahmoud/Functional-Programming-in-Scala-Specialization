List(1, 2, 3)
1 :: 2 :: 3 :: Nil
Nil.::(3).::(2).::(1)
List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
List()
Nil :: 7 :: Nil
3 :: Nil :: Nil

val xs = List(9, 1, 7, 3)
val ys = List(1, 2)
xs ::: ys
xs.contains(1)
xs.contains(0)
val i = xs.indexOf(0)
val p: (List[Int], List[Int]) = xs.splitAt(i)

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case Nil => List(x)
  case y :: ys => if(x <= y) x :: xs else y :: insert(x, ys)
}

def sort(xs: List[Int]): List[Int] = xs match {
  case Nil => List()
  case y :: ys => insert(y, sort(ys))
}

val xs = List(9, 1, 7, 3)
sort(xs)