package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {

    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
  }
  println(factorial(10))
  // println(factorial(5000)) - Stack Overflow

  def anotherFactorial(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper (x-1, x * accumulator) // TAIL RECURSIVE = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factHelper(2, 3 * 4 * ... * 10 * 1)
  = facHelper(1, 1 * 2 * 3 * 4 * ... * 10)
  = 1 * 2 * 3 * 4 * ... * 10
  */

  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
  1. Concatenate a string n times, tail recursive
  2. IsPrime function, tail recursive
  3. Fibonacci function, tail recursive
  */

  @tailrec
  def concatTailrec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatTailrec(aString, n - 1, accumulator + aString)
  }

  println(concatTailrec("hello", 3, ""))


  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
    //  println(t)
    //  println(isStillPrime)
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  // println(isPrime(2003))
  // println(isPrime(629))
  println(isPrime(11))


  def fibonacci(n: Int): Int = {
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2,1,1)
  }

  println(fibonacci(8))

}
