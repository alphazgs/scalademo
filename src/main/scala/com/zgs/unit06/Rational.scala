package com.zgs.unit06

class Rational(n: Int, d: Int)  extends  Ordered[Rational] {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  override def toString: String = numer + "/" + denom

  def +(that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def compare(that: Rational): Int = (this.numer * that.denom) - (that.numer*this.denom)

}
