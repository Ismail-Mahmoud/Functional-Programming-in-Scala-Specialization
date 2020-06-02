def fact(n: Int): Int = {
  @scala.annotation.tailrec
  def loop(n: Int, acc: Int): Int =
    if(n == 0) acc else loop(n - 1, acc * n)
  loop(n, 1)
}

fact(5)
fact(1)
fact(0)