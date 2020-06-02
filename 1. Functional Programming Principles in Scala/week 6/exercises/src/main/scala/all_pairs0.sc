// pairs of (i, j) such that 1 <= i < j <= n and i + j is prime
def isPrime(n: Int): Boolean = (2 until n).forall(d => n % d != 0)
def get(n: Int) = {
  val all = (1 to n).flatMap(i => (i + 1 to n).map(j => (i, j)))
  all.filter(ij => isPrime(ij._1 + ij._2))
}
get(6)