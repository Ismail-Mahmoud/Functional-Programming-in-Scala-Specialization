def removeAt(lst: List[Int], idx: Int): List[Int] = lst.take(idx) ::: lst.drop(idx + 1)
removeAt(List(0, 1, 2, 3, 4), 2)


def flatten(lst: List[Any]): List[Any] = lst match {
  case Nil => Nil
  case h :: t => (h match {
    case lst: List[Any] => flatten(lst)
    case single => List(single)
  }) ::: flatten(t)
}
flatten(List(List(1, 1), 2, List(3, List(5, 8))))


def pack[T](lst: List[T]): List[List[T]] = lst match {
  case Nil => Nil
  case h :: t => lst.takeWhile(x => x == h) :: pack(lst.dropWhile(x => x == h))
}
pack(List("a", "a", "a", "b", "c", "c", "a"))


def encode1[T](lst: List[T]): List[(T, Int)] = lst match {
  case Nil => Nil
  case h :: t => {
    val tmp = lst.takeWhile(x => x == h)
    (h, tmp.length) :: encode1(lst.dropWhile(x => x == h))
  }
}
encode1(List("a", "a", "a", "b", "c", "c", "a"))

def encode2[T](lst: List[T]): List[(T, Int)] = {
  val tmp = pack(lst)
  tmp.map(x => (x.head, x.length))
}
encode2(List("a", "a", "a", "b", "c", "c", "a"))


def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())((x, y) => f(x) :: y)
mapFun(List(-1, 2, 5), (x: Int) => x * x)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((x, y) => 1 + y)
lengthFun(List(-1, 2, 5))
