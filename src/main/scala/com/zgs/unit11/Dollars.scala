package com.zgs.unit11

class Dollars(val amount:Int) extends  AnyVal {
  override def toString: String = "$" + amount
}
