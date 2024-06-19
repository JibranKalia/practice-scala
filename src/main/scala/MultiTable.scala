object MultiTable {
  def makeRowSeq(row: Int) = {
    for (col <- 1 to 10) yield {
      val product = (col * row).toString
      val padding = " " * (4 - product.length)
      padding + product
    }
  }

  def makeRow(row: Int): String = makeRowSeq(row).mkString;

  def multiTable(): String = {
    val tableString =
      for (row <- 1 to 10)
        yield makeRow(row)

    tableString.mkString("\n")
  }

  def run(): Unit = {
    println(multiTable())
  }
}
