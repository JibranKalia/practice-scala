case class Person2(name: String, isMale: Boolean, children: Person2*)

object PersonForCompletion {
  def definePersons(): List[Person2] = {
    val lara = Person2("Lara", false)
    val bob = Person2("Bob", true)
    val julie = Person2("Julie", false, lara, bob)
    return List(lara, bob, julie)
  }

  def main(args: Array[String]): Unit = {
    val persons = definePersons;

    val children1 = persons.filter(p => !p.isMale).flatMap(p => p.children.map(c => (p.name, c.name)))
    println(children1)

    val children2 = for (p <- persons; if !p.isMale; c <- p.children) yield (p.name, c.name)
    println(children2)

    val children3 = for {
      p <- persons
      if !p.isMale
      c <- p.children
    } yield (p.name, c.name)
    println(children3)
  }
}
