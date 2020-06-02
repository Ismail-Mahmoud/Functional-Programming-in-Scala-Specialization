def isPrime(n: Int): Boolean = (2 until n).forall(d => n % d != 0)
def get(n: Int) = {
  //for(i <- 1 to n; j <- i + 1 to n if isPrime(i + j)) yield (i, j)
  for {
    i <- 1 to n
    j <- i + 1 to n
    if isPrime(i + j)
  } yield (i, j)
}
get(6)