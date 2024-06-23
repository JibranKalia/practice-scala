object RenderSudoku {
  def main(args: Array[String]): Unit = {
    val sudo = Array(
      Array(3, 1, 6, 5, 7, 8, 4, 9, 2),
      Array(5, 2, 9, 1, 3, 4, 7, 6, 8),
      Array(4, 8, 7, 6, 2, 9, 5, 3, 1),
      Array(2, 6, 3, 0, 1, 0, 0, 8, 0),
      Array(9, 7, 4, 8, 6, 3, 0, 0, 5),
      Array(8, 5, 1, 0, 9, 0, 6, 0, 0),
      Array(1, 3, 0, 0, 0, 0, 2, 5, 0),
      Array(0, 0, 0, 0, 0, 0, 0, 7, 4),
      Array(0, 0, 5, 2, 0, 6, 3, 0, 0)
    )

    val res = renderSudoku(sudo)
    println(res)
  }

  def renderSudoku(seq: Array[Array[Int]]): String = {
    val sb = new StringBuilder()

    for (i <- seq.indices) {
      if (i % 3 == 0) {
        sb.append("+-------+-------+-------+\n")
      }
      for (j <- seq(i).indices) {
        if (j % 3 ==0 ) {
          sb.append("| ")
        }
        sb.append(seq(i)(j) match {
          case 0   => "  "
          case num => s"$num "
        })
      }
      sb.append("| \n")
    }

    sb.append("+-------+-------+-------+\n")
    sb.toString()
  }
}
