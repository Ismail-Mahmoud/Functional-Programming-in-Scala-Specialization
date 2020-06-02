def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)

def sum(f: Int => Int, a: Int, b: Int): Int = {
  if(a > b) 0
  else f(a) + sum(f, a + 1, b)
}

sum(id, 3, 10)
sum(cube, 1, 3)
sum(fact, 0, 4)