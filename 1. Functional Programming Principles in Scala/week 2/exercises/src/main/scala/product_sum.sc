def sum(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) 0
  else f(a) + sum(f)(a + 1, b)
}

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) 1
  else f(a) * product(f)(a + 1, b)
}

def calc(f: (Int => Int) => (Int, Int) => Int)(g: Int => Int)(a: Int, b: Int): Int = {
  f(g)(a, b)
}

calc(sum)(x => x)(3, 10)
calc(sum)(x => x * x * x)(1, 3)
calc(product)(x => x)(3, 5)
calc(product)(x => x * x)(3, 4)
calc(sum)(x => calc(product)(x => x)(1, x))(0, 4) // sumFacts