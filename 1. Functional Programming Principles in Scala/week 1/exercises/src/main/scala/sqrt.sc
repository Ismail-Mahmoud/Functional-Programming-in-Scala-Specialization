def abs(x: Double): Double = if(x >= 0) x else -x

def sqrt(x: Double): Double = {

  def goodEnough(y: Double): Boolean =
    (abs(y * y - x) / x) < 1e-6

  def advance(y: Double): Double =
    (y + x / y) / 2

  def iterate(y: Double): Double =
    if(goodEnough(y)) y
    else iterate(advance(y))

  iterate(1.0)
}

sqrt(4)
sqrt(9)
sqrt(2)
sqrt(1e-6)
sqrt(1e18)