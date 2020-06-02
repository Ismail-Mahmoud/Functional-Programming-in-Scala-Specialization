def nQueens(n: Int): Set[List[Int]] = {

  def valid(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithRows = ((row - 1) to 0 by -1).zip(queens)
    queensWithRows.forall{case (r, c) => col != c && math.abs(col - c) != row - r}
  }

  def place(k: Int): Set[List[Int]] = {
    if(k == 0) Set(List())
    else for {
      queens <- place(k - 1)
      col <- 0 until n
      if valid(col, queens)
    } yield col :: queens
  }
  place(n)
}

def show(queens: List[Int]) = {
  val lines =
    for(col <- queens.reverse)
    yield Vector.fill(queens.length)(". ").updated(col, "Q ").mkString

  "\n" + lines.mkString("\n") + "\n"
}

val sol = nQueens(8)
sol.map(show).mkString("===============")