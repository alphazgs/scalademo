package com.zgs.unit06

object test {
  def main(args: Array[String]): Unit = {
    implicit def int2rational(n: Int) = {
      new Rational(n)
    }

    val a = new Rational(4, 8)
    val c = 5
    val b = new Rational(10, 20)
    //    print(b + 5)

    val fg = new Rational(4, 5)
    val g2 = new Rational(5, 6)
    val li = List(fg, g2)
    println(li.sorted)


  }

}
