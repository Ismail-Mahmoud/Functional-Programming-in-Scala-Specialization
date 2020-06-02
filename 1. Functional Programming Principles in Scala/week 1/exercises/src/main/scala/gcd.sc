@scala.annotation.tailrec
def gcd(a: Int, b: Int): Int =
  if(b == 0) a else gcd(b, a % b)

gcd(10, 15)
gcd(15, 10)
gcd(0, 8)
gcd(4, 9)