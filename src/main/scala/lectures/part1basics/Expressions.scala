package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println (!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works wirth -= *= /= .... side effects
  println(aVariable)

  // Instruction (DO) vs Expressions (VALUE)

  // IF in Scala is an expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF expression
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE ABOVE AGAIN! This is imperative code

  // EVERYTHING in Scala is an Expression

  val aWeirdValue = (aVariable = 3) // Type Unit === void
  println(aWeirdValue)
  // reassigning values in Scala are expressions returning Unit

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)

  // val anotherValue = z + 1
  // z is defined within a code block

  // 1. What is the difference between "hello world" vs println("hello world")?
  // 2.
  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someValue)
  println(someOtherValue)

}
