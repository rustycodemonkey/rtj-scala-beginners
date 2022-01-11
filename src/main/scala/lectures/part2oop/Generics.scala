package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A
    // can also be applied to traits not just classes
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog = Animal
    */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listofStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION - we return a list of Animals

  // 2. no = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] // can't have Cat on the right hand side

  // 3. Hell, no! = CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A) // A must be a subtype of Animal
  // A >: Animal would mean A must be supertype of Animal
  val cage = new Cage(new Dog)
  class Car
  // val newCage = new Cage(new Car)

  // expand MyList to be generic

}
