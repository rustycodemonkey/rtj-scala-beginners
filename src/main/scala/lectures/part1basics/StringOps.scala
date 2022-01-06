package lectures.part1basics

object StringOps extends App {

  // String operations comes from Java
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11)) // Inclusive of 7 and exclusive of 11
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt

  // prepend and appending operators are Scala specific
  println('a' +: aNumberString :+ 'z')

  // Scala specific function
  println(str.reverse)
  println(str.take(2))

  // Scala specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.3f burgers per minute"
  // printf like format - 2 characters total, minimum and 3 decimal precision
  // Also checks for type correctness
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
