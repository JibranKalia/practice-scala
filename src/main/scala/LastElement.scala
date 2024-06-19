object LastElement {
  def lastEasy[A](ls: List[A]): A = ls.last

  def lastRecursive[A](ls: List[A]): A = {
    println(ls)

    ls match {
      case h :: Nil  => h
      case _ :: tail => lastRecursive(tail)
      case _         => throw new NoSuchElementException()
    }
  }

  def main(args: Array[String]): Unit = {
    val testList = List(1, 1, 2, 3, 5)
    println(s"lastBuiltin(testList): ${lastRecursive(testList)}")
  }
}
