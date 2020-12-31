package com.atgg.c2

import akka.actor.{Actor,ActorRef,ActorSystem,Props}

class SayHelloActor extends Actor {
  override def receive: Receive = {
    case "hello" => println("收到Hello，回应Hello too：")
    case "ok" => println("ok")
    case "exit" => println("exit");context.stop(self);context.system.shutdown()
    case _ => println("完了,没匹配到!")
  }
}


object SayHelloActorDemo{
  private val actorFactory = ActorSystem("actorFactory")
  private val sayHelloActorRef:ActorRef = actorFactory.actorOf(Props[SayHelloActor],"sayHelloActor")

  def main(args: Array[String]): Unit = {
    sayHelloActorRef!"hello"
    sayHelloActorRef!"ok"
    sayHelloActorRef!"ok~"
    sayHelloActorRef!"exit"
  }



}
