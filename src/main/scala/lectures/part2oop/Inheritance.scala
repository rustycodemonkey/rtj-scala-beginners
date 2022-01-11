package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  class Animal {
    val creatureType = "wild"
//    protected def eat = println("nomnom")
    def eat = println("nomnom")

    // private def eat = println("nomnom") - makes eat method only accessible within the Animal class
    // protected def eat = println("nomnom") - makes eat method only accessible within Animal and its subclasses
  }

  class Cat extends Animal { // inheriting all non-private fields and methods
    // Cat is a subclass and Animal is a superclass

    def crunch = {
      eat
      println("crunch crunch")
    }
  }
  val cat = new Cat
  // cat.eat - not accessible
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding - works for methods, vals and vars
  class Dog (override val creatureType: String) extends Animal {
    // override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  // will use the last oeverriden eat method
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super - reference method or field from parent class

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevents extension in other files
  /*
  if Cats and Dogs are the only Animals then you can seal the Animal class in this file so that Animal class cannot be extended beyond this file
  */
}
