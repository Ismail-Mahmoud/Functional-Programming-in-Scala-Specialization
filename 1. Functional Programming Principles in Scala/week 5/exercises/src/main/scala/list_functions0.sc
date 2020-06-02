val lst = List(0, 1, 2, 3, 4)
lst(3)
lst.length
lst.last
lst.init
lst.take(3)
lst.drop(3)
lst.contains(2)
lst.contains(9)
lst.indexOf(2)
lst.indexOf(9)
lst.reverse
lst ++ List(5, 6, 7)
lst ::: List(5, 6, 7)
lst.updated(2, 9)

val a = List(9, -1, 2, 8, -4)
a.sorted
a.sortWith(_ > _)
a.groupBy(_ > 0)

a.map(x => x * x)

a.filter(x => x > 0)
a.filterNot(x => x > 0)
a.partition(x => x > 0)

a.takeWhile(x => x > 0)
a.dropWhile(x => x > 0)
a.span(x => x > 0)

// ((x1 op x2) op ...) op xn
//List(1, 2, 3, 4).reduceLeft((x, y) => x + y)
List(1, 2, 3, 4).reduceLeft(_ + _)
//List(1, 2, 3, 4).reduceLeft((x, y) => x * y)
List(1, 2, 3, 4).reduceLeft(_ * _)
val empty: List[Int] = List()
//empty.reduceLeft(_ + _) =====> Error
empty.foldLeft(0)(_ + _)
empty.foldLeft(1)(_ * _)
