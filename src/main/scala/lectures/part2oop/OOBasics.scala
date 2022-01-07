package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("Anh", "Do", 1977)
  // println(writer.fullname())

  val novel = new Novel("Wolf Girl", 2020, writer)
  println(novel.authorAge())

  val movieActor = new Writer("Tom", "Cruise", 1962)
  // println(writer.fullname())

  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(movieActor))

  println("Novel Name: " + novel.name)
  println("Year of Release: " + novel.yor)
  println("Novel Author: " + novel.author.fullname())

  val rereleasedNovel = novel.copy(2021)

  println("Novel Name: " + rereleasedNovel.name)
  println("Updated Year of Release: " + rereleasedNovel.yor)
  println("Novel Author: " + rereleasedNovel.author.fullname())


  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

// constructor
class Person(name: String, val age: Int) {
  // name is above is a class parameter, age is a class field
  // class parameters are not NOT FIELDS


  // class body
  val x = 2 // THIS IS A FIELD
  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name") // this instance's field

  // overloading
  def greet(): Unit = println(s"Hi, I am $name") // this is implied because name is not provided in the parameter

  // multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
  // multiple constructors only good for default parameters
  // but you can use default parameters in the original constructor instead

}

/*
Novel and Writer class

Writer: first name, surname year of birth
- method fullname

Novel: name, year of realease, author
- authorAge - returns age of author at the year of release
- isWrittenBy(author)
- copy (new year of release) returns new instance of a Novel
*/

class Writer(fname: String, surname: String, val yob: Int) {
  def fullname(): String = fname + " " + surname
}

class Novel(val name: String, val yor: Int, val author: Writer) {

  def authorAge(): Int = yor - author.yob
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)

}


/*
Counter class
- receives an int value
- method current count
- method to increment/decrement => new Counter
- overload inc/dev methods to receive an amount parameter
*/

class Counter (count: Int = 0) {
  def inc: Counter = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }

  def dec: Counter = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if(n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}