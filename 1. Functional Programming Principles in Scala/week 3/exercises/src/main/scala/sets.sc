abstract class Set {
  def contains(x: Int): Boolean
  def insert(x: Int): Set
  def union(s: Set): Set
}

class NonEmpty(k: Int, L: Set, R: Set) extends Set {
  def key = k
  def left: Set = L
  def right: Set = R

  def contains(x: Int): Boolean = {
    if(x < key) left.contains(x)
    else if(x > key) right.contains(x)
    else true
  }
  def insert(x: Int): Set = {
    if(x < key) new NonEmpty(key, left.insert(x), right)
    else if(x > key) new NonEmpty(key, left, right.insert(x))
    else this
  }
  def union(s: Set): Set = ((left.union(right)).union(s)).insert(key)
  override def toString: String = "{" + left.toString + "," + key + "," + right.toString + "}"
}

class Empty extends Set {
  def contains(x: Int): Boolean = false
  def insert(x: Int): Set = new NonEmpty(x, new Empty, new Empty)
  def union(s: Set): Set = s
  override def toString: String = "."
}

val s = new NonEmpty(3, new Empty, new Empty)
val s1 = s.insert(4)
val s2 = s1.insert(10)
val s3 = s2.insert(-1)
s3.contains(2)
s3.contains(4)
val s4 = s.insert(2)
s3.union(s4)