class Msg(val id: Int, val parent: Option[Int], val txt: String)

object PrintMessagesPractice {
  def printMessages(messages: Array[Msg]): Unit = {
    def printFrag(parentId: Option[Int], indent: String): Unit = {
      for (m <- messages; if m.parent == parentId) {
        println(s"$indent#s${m.id} ${m.txt}");
        printFrag(Some(m.id), indent + "   ")
      }
    }

    printFrag(None, "")
  }

  def main(args: Array[String]): Unit = {
    printMessages(
      Array(
        new Msg(0, None, "Hello"),
        new Msg(1, Some(0), "World"),
        new Msg(2, None, "I am Cow"),
        new Msg(3, Some(2), "Hear me moo"),
        new Msg(4, Some(2), "Here I stand"),
        new Msg(5, Some(2), "I am Cow"),
        new Msg(6, Some(5), "Here me moo, moo")
      ))
  }
}
