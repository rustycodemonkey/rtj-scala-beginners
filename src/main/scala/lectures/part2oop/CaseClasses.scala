package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString
  */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2.  sensible toString
  // println(istance) = println(instance.toString) - syntatic sugar
  println(jim.toString)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy menthod
  val jim3 = jim.copy(age = 45)
  println(jim == jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // Akka - useful

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  // There are case objects
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  // Exercises
  /*
  Expan MyList - use case classes and case objects
   */
}
