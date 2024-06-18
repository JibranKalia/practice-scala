case class Person(name: String, age: Int)

object PersonDetails {

  def describePerson(person: Person): String = person match {
    case Person(_, n) if n > 30 => "This person is old"
    case Person("John", _) => "This person is named John"
    case Person(_, n) if n < 30 => "This person is young"
    case Person(name, age) => s"This person is $name old and with $name as a name"


  }

  def main(args: Array[String]): Unit = {

    val person = Person("John", 30)

    println(describePerson(person))
    println(describePerson(Person("J", 28)))
    println(describePerson(Person("J", 35)))
    println(describePerson(Person("J", 30)))
  }
}
