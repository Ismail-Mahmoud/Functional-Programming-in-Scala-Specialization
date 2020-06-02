// All sequences operations are the same as lists
// (List, Vector, Range, Array, String)

// access index or append in O(log32(N))
val v: Vector[Int] = Vector(1, 2, 3)
0 +: v
v :+ 4
v(1)
v.toList

// stored as object with 3 fields (lower, upper, step)
val r: Range = 1 to 5     // 1,2,3,4,5
r.map(x => x)
val r2: Range = 1 until 5  // 1,2,3,4
val r3: Range = 1 to 10 by 3  // 1,4,7,10
val r4: Range = 6 to 1 by -2  // 6,4,2

val s: String = "Ismail"
val idx = List(0, 1, 2)
val pairs = idx.zip(s)
pairs.unzip
//s.zip(idx)
s.exists(c => c.isUpper)
s.forall(c => c.isUpper)
s.filter(c => c.isLower)
// flatmap: map each cahr to a list then concat all
// same as map then flatten
s.flatMap(c => List(c, c))
s.map(c => List(c, c)).flatten

val arr = Array(1, 2, 3, 4)
arr.sum
arr.product
arr.max
arr.min

// combinations of all (x, y), where x in [1, 5] and y in [1, 3]
(1 to 5).flatMap(x => (1 to 3).map(y => (x, y)))

def isPrime(n: Int): Boolean = (2 until n).forall(d => n % d != 0)
isPrime(7)
isPrime(9)