package exercises

import scala.runtime.Nothing$

abstract class MyList {

  /*
  Singly linked list which holds integers
  head = first element of the list (return an Int)
  tail = remainder of the list (holds the pointer)
  isEmpty = (Boolean) is this list empty
  add(Int) => new list with this element added
  toString => returns a string representation of the list
  */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
// printElements is a polymorphic call
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""

}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.head)

  println(list.toString)

}