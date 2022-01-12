package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahaha")
  } // Compiler made an anonymous class from above
  /*
  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahaha")
  }
  val funnyAnimal: Animal = new AnonymosClasses$anon$1
  */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }

  // Anonymous classes work for abstract and non-abstract classes and traits

}
