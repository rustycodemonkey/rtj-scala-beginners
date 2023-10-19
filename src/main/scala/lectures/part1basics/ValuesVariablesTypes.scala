package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // x = 2
  // VALS ARE IMMUTABLE

  val y = 43
  println(y)
  // COMPILER can infer types

  // val aString: String = "hello";
  // Semicolon allowed but not part of Scala style

  val aString: String = "hello"
  val anotherString: String = "goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x // 4 bytes
  val aShort: Short = 4613 // 2 bytes
  val aLong: Long = 3414313155135313525L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables - MUTABLE
  var aVariable: Int = 4
  aVariable = 5 // side effects


}
