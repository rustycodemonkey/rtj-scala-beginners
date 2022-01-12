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

  /*
  1. Generic trait MyPredicate[-T]
  method to test a value of type T passes a condition
  test(T) => Boolean

  2. Generic trait MyTransformer[-A, B]
  method to convert type A into type B
  method transform(A) => B
  every syblcass of my transformer will have a different implementation of that method

  3. MyList:
    - map(transformer) => new MyList of a different type
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformer[String, Int]

    [1,2,3].map(n * 2) = [2,4,6]
    [1,2,3,4].filter(n % 2) = [2,4]
    [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
  */




  
  
}
