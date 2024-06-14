object Main extends App {
  def makeRowSeq(row: Int) = {
    for (col <- 1 to 10 ) yield {
      val product = (col * row).toString
      val padding = " " * (4 - product.length)
      padding + product
    }
  }

  def makeRow(row: Int): String = makeRowSeq(row).mkString;

  def multiTable(): Unit = {
    val tableString =
      for (row <- 1 to 10)
        yield makeRow(row)

    println(tableString.mkString("\n"))
  }

  multiTable()
}
