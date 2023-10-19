package playground

import java.time.Year

object Playground {

  def main(args: Array[String]): Unit = {
    println("I'm ready to learn Scala!")
    val year = Year.now.getValue
    println(year)
  }
}
