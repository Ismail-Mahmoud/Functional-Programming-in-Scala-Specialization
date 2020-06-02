// Identifiers:
//  - Alphanumeric
//  - Symbolic (operators)

class Rational(a: Int, b: Int) {  // Implicit primary constructor
  require(b != 0, "Denominator must be non-zero")
  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
  private val g = gcd(a, b)
  val num = a / g
  val den = b / g

  def this(a: Int) = this(a, 1)   // custom constructor

  //def add(r: Rational): Rational = new Rational(num * r.den + den * r.num, den * r.den)
  def + (r: Rational): Rational = new Rational(num * r.den + den * r.num, den * r.den)

  //def neg(): Rational = new Rational(-num, den)
  def unary_- : Rational = new Rational(-num, den)

  //def sub(r: Rational): Rational = add(r.neg())
  def - (r: Rational): Rational = this + -r

  //def less(r: Rational): Boolean = num * r.den < den * r.num
  def < (r: Rational): Boolean = num * r.den < den * r.num

  //def max(r: Rational): Rational = if(less(r)) r else this
  def max(r: Rational): Rational = if(this < r) r else this

  override def toString: String = if(den == 1) num.toString else num + "/" + den
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
//y.add(y)
x + y
//x.sub(y).sub(z)
x - y - z
//x.less(y)
x < y
//x.max(y)
x max y

val s = new Rational(2)
assert(s.den != 0)

val k = new Rational(1, 0)
//k.add(k)
k + k

