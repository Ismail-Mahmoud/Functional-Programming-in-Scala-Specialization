def fact(n: Int): Int =
  if(n == 0) 1 else n * fact(n - 1)

fact(5)
fact(1)
fact(0)