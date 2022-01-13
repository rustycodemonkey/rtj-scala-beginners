package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use funtions as first class elements
  // problem: oop

  val doubler = new MyFuntion[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // Function types = Function1[A, B] up to 22 parameters
  val stringtoIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringtoIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int) = a + b
  }

  // Funtion type Funtion2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1. a function which takes 2 strings and concatenates them
  2. transform the MyPredicate and MyTransformer into function type
  3. define a function which takes an int and returns another function which takes and int and returns an int
    - what's the type of this function
    - how to do it
  */

  // 1.
  val concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatenator("Hello ", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Int => (Int => Int) = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried Function - multiple parameter list to get to final result

}

trait MyFuntion[A, B] {
  def apply(element: A): B
}
