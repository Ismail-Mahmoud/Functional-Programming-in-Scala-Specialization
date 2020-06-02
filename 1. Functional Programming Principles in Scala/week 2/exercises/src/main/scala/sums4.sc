def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)

def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if(a > b) 0
    else f(a) + sumF(a + 1, b)
  }
  sumF
}


sum(x => x)(3, 10)
sum(x => x * x * x)(1, 3)
sum(fact)(0, 4)