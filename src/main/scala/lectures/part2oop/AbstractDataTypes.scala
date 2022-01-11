package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract class - you want subclasses to define for you, meant to be extended later
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine" // override not mandatory because of abstract class
    override def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // Note: both abstract class and traits can have abstract or non-abstract members
  // 1. traits do not have constructor parameters
  // 2. Scala has single class inheritance but multiple traits maybe inherited by the same class
  // 3. traits describe behaviours but abstract class is type of thing

  // Scala Type Hierachy
  /*
          -----------------------> scala.Any <-----------------------
        /                                                             \
  scala.AnyVal                                                    scala.AnyRef
  e.g. Int, Unit, Boolean Float...                                e.g. String, List, Set ...
        ^                                                               ^
         \                                                             /
          \                                                       scala.Null
            \                                                           ^
             \                                                         /
               --------------------- scala.Nothing -------------------

  */

  

}
