def fib(n: Int): Int =
  if(n == 0 || n == 1) 1 else fib(n - 1) + fib(n - 2)

fib(3)
fib(5)
fib(0)