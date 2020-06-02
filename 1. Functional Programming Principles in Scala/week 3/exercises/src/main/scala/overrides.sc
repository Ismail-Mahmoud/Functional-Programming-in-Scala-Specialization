abstract class Base {
  def a: Int = 1
  def b: Int
}

class Sub extends Base {
  override def a: Int = 2   // must use override because it has been initialized in the Base class
  def b = 2                 // onerride is optional
}