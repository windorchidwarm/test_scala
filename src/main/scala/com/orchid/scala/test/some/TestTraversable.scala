package com.orchid.scala.test.some

import Array._

/**
  * @auther hugh Chen 
  *         created on 2021/3/18 14:16
  */
object TestTraversable {

    def main(args: Array[String]): Unit = {
        // array 可变的
        val myArray = range(5, 20)
        val myArray2 = range(5, 20, 2)
        val myArray3 = concat(myArray, myArray2)
        for(x <- myArray3) {
            println(x + " ")
        }

        // 多维数组
        val myMetrix = ofDim[Int](4, 4)
        for(i <- 0 to 3)
            for(j <- 0 to 3)
                myMetrix(i)(j) = j

        // List 不可变的
        val myCities = "chengdu" :: "beijing" :: "ny" :: Nil
        val myCities2 = List("chengdu", "beijing", "ny" )
        // 连接
        var myCities3 = myCities ::: myCities2

        // set 无重复的无序集合 显示只有 1 2 3 5
        val mySet = Set(1, 2, 1, 3, 5)
        println(mySet)

        // 元组 基于位置访问，从1开始
        val myTuple = (20, "hello", "北京")
        println(myTuple._1)
    }

}
