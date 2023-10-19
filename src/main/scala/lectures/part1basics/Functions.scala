package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  // println(aParameterlessFunction) - This only works in Scala 2

  // Scala 3 forbids the above mixup
  // - functions with parentheses must be called with parentheses
  // - functions without parenthenses must be called without parentheses

  def aRepeatedFunction (aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))
  // WHEN YOU NEED LOOPS, USE RECURSION

 // Compiler can figure out the return type of a function
 // However, recursive function needs a return type as compiler can't figure out on its own
 // Best practice, always specify the return type in functions

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)


  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }
  // Auxillary Functions


  /*
  1. A greeting function (name, age) => "Hi, my name is $name and $age years old"
  2. Factorial function 1 * 2 * 3 * .. * n
  3. Fibonacci function
  f(1) = 1
  f(2) = 1
  f(n) = f(n-1) + f(n-2)
  1, 1, 2, 3, 5, 8, 13, 21, 34, ...

  4. Tests if a number is prime
  */

  // 1
  def aGreetingFunction(name: String, age: Int): String =
    "Hi, my name is " + name + " and " + age + " years old."
  println(aGreetingFunction("David", 12))

  // 2
  def aFactorialFunction(n: Int): Int = {

    if (n <= 1) 1
    else n * aFactorialFunction(n-1)
  }
  println(aFactorialFunction(5))

  // 3
  def aFibonacciFunction(n: Int): Int = {

    if (n <= 2) 1
    else aFibonacciFunction(n-1) + aFibonacciFunction(n-2)
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
  }
  println(aFibonacciFunction(8))

  def isPrime(n: Int): Boolean = {

    def isPrimeUntil(t: Int): Boolean =
      println(t)
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }

//  println(isPrime(13))
//  println(isPrime(2003))
  println(isPrime(24))

}
