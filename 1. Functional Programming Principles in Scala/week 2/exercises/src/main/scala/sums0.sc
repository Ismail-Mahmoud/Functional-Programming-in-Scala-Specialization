def sumInts(a: Int, b: Int): Int = {
  if(a > b) 0
  else a + sumInts(a + 1, b)
}

def cube(x: Int): Int = x * x * x
def sumCubes(a: Int, b: Int): Int = {
  if(a > b) 0
  else cube(a) + sumCubes(a + 1, b)
}

def fact(x: Int): Int = if(x == 0) 1 else x * fact(x - 1)
def sumFacts(a: Int, b: Int): Int = {
  if(a > b) 0
  else fact(a) + sumFacts(a + 1, b)
}

sumInts(3, 10)
sumCubes(1, 3)
sumFacts(0, 4)