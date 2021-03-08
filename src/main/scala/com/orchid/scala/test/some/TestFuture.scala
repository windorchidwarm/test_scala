package com.orchid.scala.test.some

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.Success

object TestFuture {

    def main(args: Array[String]): Unit = {
        implicit val baseTime = System.currentTimeMillis()

        val testFutureDemo = Future {
            Thread.sleep(300)
            2 + 2
        }
        // 必须在2秒内返回结果，否则会抛出异常
        val finalOutput = Await.result(testFutureDemo, 2 second)
        println(finalOutput)

        val fut = Future {
            Thread.sleep(1000)
            1 + 1
        }

        // onComplete 方法 callback方式获取Future不会引起阻塞
        fut onComplete {
            case Success(value) => println(s"the result is ${value}")
            case _ => println("some Exception")
        }

        println("I am work")
        Thread.sleep(2000)

        val rateQuote = Future {
            println("dddd")
            "123"
        }

        def isProfitabe(queto: String) = {
            if (queto == "123")
                true
            else
                false
        }

        val purchase = rateQuote map {
            quote => if(isProfitabe(quote)) println("true")
            else println("false")
        }
    }
}

class TestFuture {

}
