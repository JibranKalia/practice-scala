import java.io._

import java.io._

object LoanResource {
  def originalReadFile(file: File): Unit = {
    val reader = new BufferedReader(new FileReader(file))
    try {
      var line = reader.readLine()
      while (line != null) {
        println(processLine(line))
        line = reader.readLine()
      }
    } finally reader.close()
  }

  def processLine(line: String): String = {
    line.toUpperCase()
  }

  def doEachLine(fileName: String)(op: String => String): Unit = {
    val file = new File(fileName)
    val reader = new BufferedReader(new FileReader(file))

    try {
      var line = reader.readLine()
      while (line != null) {
        println(op(line))
        line = reader.readLine()
      }
    } finally {
      reader.close()
    }
  }

  def main(args: Array[String]): Unit = {
    doEachLine("example.txt") { line =>
      line.toUpperCase()
    }
  }
}
