package exercises

// import scala.runtime.Nothing$

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
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
//    else h + " " + t.printElements // this errors due to +, does A have + defined?
  }
}

object ListTest extends App {
/*  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.head)

  println(list.toString)*/

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

}