def product(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) 1
  else f(a) * product(f)(a + 1, b)
}

def fact(n: Int): Int = product(x => x)(1, n)

product(x => x)(3, 5)
product(x => x * x)(3, 4)
fact(5)