package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    // def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def learns(subject: String): String = s"$name learns $subject"
    def +(person: Person): String = s"${name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(name = s"${this.name} ($nickname)", favouriteMovie = this.favouriteMovie, age = this.age)
    def unary_! : String = s"$name, what the heck?!" // space between unary_! and colon is important
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def isAlive: Boolean = true
    def learnsScala: String = this learns "Scala"
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int) = s"$name watched $favouriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent (object method single parameter)
  // infix notation = operator notation (syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  // println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS in Scala
  // Akka actors have ! ? operators

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_- prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation - only available for methods without parameters
  println(mary.isAlive)
  println(mary isAlive) // needs 'import scala.language.postfixOps'

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  // Exercises

  /*
  1.
  Overload the + operator
  mary + "the rockstar" => new person with the name "Mary (the rockstar)"

  2.
  Add an age to the Person class
  Add a unary + operator => new person with the age + 1
  +mary => mary with the age incrementer
  Resembles ++

  3.
  Add a "learns" method in the Person class with String input "Scala" => "Mary learns Scala"
  Add a learnsScala method, no parameters but calls learns method with "Scala" as a parameter.
  Use it in postfix notation

  4. Overload the apply method
  maryl.apply(2) => "Mary watched Inception 2 times"
  */

  println((mary + "the rockstar")())

  println(mary.age)
  println((+mary).age)


  println(mary learns "Scala")

  println(mary learnsScala)

  println(mary(2))

}
