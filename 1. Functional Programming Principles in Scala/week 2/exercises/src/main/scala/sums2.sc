def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)

def sum(f: Int => Int, a: Int, b: Int): Int = {
  if(a > b) 0
  else f(a) + sum(f, a + 1, b)
}

def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
def sumFacts(a: Int, b: Int): Int = sum(fact, a, b)


sumInts(3, 10)
sumCubes(1, 3)
sumFacts(0, 4)