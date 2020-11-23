package com.orchid.scala.grammar.test

import com.orchid.scala.grammar.algorithm.SortedLine

object Hello {
  def main(args: Array[String]): Unit = {
    println("hello world")
    var nums:Array[Int] = Array(2, 0, 0, 0, 0,0, 0,2, 2,2,2,2,1, 1, 1)

    nums = SortedLine.sortedList(nums)
    nums.foreach(println)
    println(32 >> 33)
  }

}
