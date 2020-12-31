package com.zgs.LeetCode

import scala.math._


object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    var i1 = 0
    var i2 = 0
    cost.foreach(i => {
      val t = i2.min(i1) + i
      i2 = i1
      i1 = t
    }
    )
    i1.min(i2)
  }

  //斐波那契数列，可直接求通项公式https://wenku.baidu.com/view/699894c171fe910ef02df831.html
//  def climbStairs(n: Int): Int = {
////    if (n == 2) 2
////    else if (n == 1) 1
////    else {
////      climbStairs(n - 1) + climbStairs(n - 2)
////    }
////  }
  def climbStairs(n:Int):Int = {
    n match {
      case 0 | 1 | 2 => n
      case _ => climbStairs(n - 2) + climbStairs(n - 1)
    }
  }

//  def levelOrder(root: TreeNode): List[List[Int]] = {
//
//  }






  def main(args: Array[String]): Unit = {
    //    val co = Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)
    //    println(minCostClimbingStairs(co))
    print(climbStairs(41))


  }
}
