case class Book(title: String, authors: String*)

object BookForCompletion {
  def defineBooks(): List[Book] = {
    return List(
      Book("To Kill a Mockingbird", "Harper Lee"),
      Book("1984", "George Orwell"),
      Book("Pride and Prejudice", "Jane Austen"),
      Book("The Great Gatsby", "F. Scott Fitzgerald"),
      Book("Moby Dick", "Herman Melville"),
      Book("War and Peace", "Leo Tolstoy"),
      Book("The Catcher in the Rye", "J.D. Salinger"),
      Book("The Lord of the Rings", "J.R.R. Tolkien"),
      Book("The Hobbit", "J.R.R. Tolkien"),
      Book("Brave New World", "Aldous Huxley"),
      Book("The Picture of Dorian Gray", "Oscar Wilde"),
      Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle"),
      Book("Dracula", "Bram Stoker"),
      Book("The Count of Monte Cristo", "Alexandre Dumas"),
      Book("Great Expectations", "Charles Dickens"),
      Book("The Brothers Karamazov", "Fyodor Dostoevsky"),
      Book("Crime and Punishment", "Fyodor Dostoevsky"),
      Book("Wuthering Heights", "Emily Brontë"),
      Book("Jane Eyre", "Charlotte Brontë"),
      Book("Anna Karenina", "Leo Tolstoy"),
      Book("Frankenstein", "Mary Shelley"),
      Book("The Odyssey", "Homer"),
      Book("The Iliad", "Homer"),
      Book("Les Misérables", "Victor Hugo"),
      Book("Ulysses", "James Joyce"),
      Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez"),
      Book("The Divine Comedy", "Dante Alighieri"),
      Book("Don Quixote", "Miguel de Cervantes"),
      Book("Madame Bovary", "Gustave Flaubert"),
      Book("The Three Musketeers", "Alexandre Dumas"),
      Book("The Metamorphosis", "Franz Kafka"),
      Book("Fahrenheit 451", "Ray Bradbury"),
      Book("Lolita", "Vladimir Nabokov"),
      Book("Heart of Darkness", "Joseph Conrad"),
      Book("The Stranger", "Albert Camus"),
      Book("Catch-22", "Joseph Heller"),
      Book("The Old Man and the Sea", "Ernest Hemingway"),
      Book("A Tale of Two Cities", "Charles Dickens"),
      Book("The Grapes of Wrath", "John Steinbeck"),
      Book("Slaughterhouse-Five", "Kurt Vonnegut"),
      Book("The Sound and the Fury", "William Faulkner"),
      Book("Beloved", "Toni Morrison"),
      Book("Invisible Man", "Ralph Ellison"),
      Book("The Sun Also Rises", "Ernest Hemingway"),
      Book("The Bell Jar", "Sylvia Plath"),
      Book("Gone with the Wind", "Margaret Mitchell"),
      Book("The Call of the Wild", "Jack London"),
      Book("White Fang", "Jack London")
    )
  }

  def main(args: Array[String]): Unit = {

    val books = defineBooks()
    // find all books that start with Homer
    val res1 = for {
      b <- books
      author <- b.authors
      if author.startsWith("Homer")
    } yield b.title

    println(res1)

    // find the titles of all books that have the string “and” in their title
    val res2 = for {
      b <- books
      if b.title.indexOf("and") >= 0
    } yield b.title

    println(res2)

    //  find the names of all authors that have written at least two books in the database
    val res3 = for {
      b1 <- books
      b2 <- books
      if b1 != b2
    } yield b1
  }
}

/**
 * This is all related to `for` loops that return something via a `yeild`:
 *
 * for(y <- expr2)) yield expr3
 * expr2.map(y => expr3)
 *
 * for (x <- expr1 if expr2) yield expr3
 * for (x <- expr1.filter(x => expr2)) yield expr3
 * expr1.filter(x => expr2).map(x => expr3)
 *
 *
 * for (x <- expr1; y <- expr2) yield expr3
 * expr1.flatMap(x => (expr2.map(y => expr3)))
 *
 *
 * for (b1 <- books; b2 <- books if b1 != b2;
 *    a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
 *    yield a1
 *
 * books.flatMap(b1 => {
 *  books.filter(b2 => b1 != b2).flatMap {
 *    authors.flatMap(a1 => {
 *      authors.filter(a2 => a1 == a2).map {
 *       a2 => a1
 *      }
 *    })
 *  })
 * })
 *
 *
 * for loops that don't return anything and instead have a sideeffect are simpler.
 *
 * The can use a foreach instead of a map
 */
