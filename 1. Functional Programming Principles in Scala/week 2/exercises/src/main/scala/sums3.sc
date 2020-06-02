def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)

def sum(f: Int => Int, a: Int, b: Int): Int = {
  @scala.annotation.tailrec
  def loop(a: Int, acc: Int): Int = {
    if(a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}


sum(x => x, 3, 10)
sum(x => x * x * x, 1, 3)
sum(fact, 0, 4)