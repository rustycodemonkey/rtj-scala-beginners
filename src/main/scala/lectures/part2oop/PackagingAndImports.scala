package lectures.part2oop

 // import all under playground
 // import playground._
 import playground.{Cinderella => Princess, PrinceCharming}
 import java.util.Date
 import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Danile", "RockTheJVM", 2018)

  // import the package
  // if not in the proper package or use fully qualified name
  // val princess = new playground.Cinderella
  val princess = new Princess

  // packages are in hierachy (dot notation)
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use FQN
  val date = new Date
  val sqlData = new SqlDate(2018, 5, 4)
  // 2. use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
