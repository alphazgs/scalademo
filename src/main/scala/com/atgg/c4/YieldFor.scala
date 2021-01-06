package com.atgg.c4

import scala.beans.BeanProperty

object YieldFor {

  def main(args: Array[String]): Unit = {
    def f(x:Int):Int = if(x == 1) 3 else 2*f(x-1)+1
  }

  class Car {
    @BeanProperty var name:String = _
  }




}
