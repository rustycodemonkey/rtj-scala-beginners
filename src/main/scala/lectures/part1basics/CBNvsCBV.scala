package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }
// Arrow above delays the evaluation of the expression passed as a paraneter
// Useful for lazy streams and things that might fail

  calledByValue(System.nanoTime()) // Evaluates System.nanoTime() first
  calledByName(System.nanoTime())  // Literal name of System.nanoTime() gets parsed to the function

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34)
  printFirst(34, infinite())
}
