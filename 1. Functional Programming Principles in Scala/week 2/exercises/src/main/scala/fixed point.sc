val EPS = 1e-6
def abs(x: Double): Double = if(x < 0) -x else x

// f(x) = x
def fixedPoint(f: Double => Double)(initial: Double) = {

  def goodEnough(cur: Double, nxt: Double): Boolean = abs(cur - nxt) / cur < EPS

  @scala.annotation.tailrec
  def iterate(cur: Double): Double = {
    //println(cur)
    val nxt = f(cur)
    if(goodEnough(cur, nxt)) nxt
    else iterate(nxt)
  }

  iterate(initial)
}
// sqrt(n) = x
// x * x = n
// x = n / x
// this doesn't converge, so take the average
// x = (x + n / x) / 2  (same as Newton's method!)
def averageDamp(f: Double => Double)(x: Double): Double =
  (x + f(x)) / 2    // (Double => Double) => (Double => Double)
def sqrt(a: Double): Double =
  fixedPoint(averageDamp(x => a / x))(1.0)

fixedPoint(x => 1 + x / 2)(1.0)
sqrt(2)
sqrt(1e18)
sqrt(EPS)
