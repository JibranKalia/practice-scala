import java.io._

object LoanPattern {
  private def withFileWriter[T](name: String)(doWrite: BufferedWriter => T): T = {
    val writer = new BufferedWriter(new FileWriter(name))
    try {
      doWrite(writer)
    } finally writer.close()
  }

  private def withFileReader[T](name: String)(doRead: BufferedReader => T): T= {
    val reader = new BufferedReader(new FileReader(name))
    try {
      doRead(reader)
    } finally reader.close()
  }

  def main(args: Array[String]): Unit = {
    withFileWriter("File.txt") { writer =>
      writer.write("Hello\n"); writer.write("World!")
    }
    val result = withFileReader("File.txt") { reader =>
      reader.readLine() + "\n" + reader.readLine()
    }

    assert(result == "Hello\nWorld!")
    println(result)
  }
}
