package com.orchid.scala.test.some

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object TestFuture {

    def main(args: Array[String]): Unit = {
        implicit val baseTime = System.currentTimeMillis()

        val testFutureDemo = Future {
            Thread.sleep(3000)
            2 + 2
        }
        // 必须在2秒内返回结果，否则会抛出异常
        val finalOutput = Await.result(testFutureDemo, 2 second)
        println(finalOutput)
    }
}

class TestFuture {

}
