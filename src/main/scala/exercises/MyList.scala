package exercises

//import scala.runtime.Nothing$

abstract class MyList[+A] {

  /*
  Singly linked list which holds integers
  head = first element of the list (return an Int)
  tail = remainder of the list (holds the pointer)
  isEmpty = (Boolean) is this list empty
  add(Int) => new list with this element added
  toString => returns a string representation of the list
  */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
// printElements is a polymorphic call
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // higher-order functions - receive functions as parameters or return functions as a result
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean ): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
    //    else h + " " + t.printElements // this errors due to +, does A have + defined?
  }

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))



  /*
  [1,2] ++ [3,4,5]
  = new Cons(1, [2] ++ [3,4,5])
  = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
  */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /*
  [1,2].flatMap(n => [n, n+1]
  = [1,2] ++ [2].flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty
  = [1,2,2,3]
  */

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

}

/*
trait MyPredicate[-T] { // T => Boolean
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] { // A => B
  def transform(elem: A): B
}
*/

object ListTest extends App {
/*  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.head)

  println(list.toString)*/

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  /*
  [1,2,3].map(n * 2)
  = new Cons(2, [2,3].map(n * 2))
  = new Cons(2, new Cons(4, [3].map(n * 2)))
  = new Cons(2, new Cons(4, new Cons(6, Empty.maps(n * 2))))
  = new Cons(2, new Cons(4, new Cons(6, Empty)))
  */

  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }).toString)

  /*
  [1,2,3].filter(n % 2 == 0) =
    [2,3].filter(n % 2 == 0) =
    = new Cons(2, [3].filter(n % 2 == 0)
    = new Cons(2, Empty.filter(n % 2 == 0)
    = new Cons(2, Empty)
  */

  println(listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }))

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)

  println(cloneListOfIntegers == listOfIntegers)

}