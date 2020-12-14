package com.zgs.unit08

object test {
  def main(args: Array[String]): Unit = {
    def boom(x: Int): Int= if (x == 0) throw new Exception("boom!") else boom(x - 1) //尾递归




  }

}
